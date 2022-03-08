package com.proyect.management;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.proyect.management.entity.InfoAdnEntity;
import com.proyect.management.repository.InfoAdnDao;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class DnaManagementApplicationTests {
	
    @Autowired
    private MockMvc mvc;
    
	@Autowired
	private InfoAdnDao infoAdnDao;
	    
		@Test
		void isValidText() throws Exception {
			infoAdnDao.deleteAll();
			try {
				String json="{\"adnList\":[\"wTGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}";
				 mvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON).content(json))
					      .andExpect(status().isOk()).andReturn();
				 fail();

			} catch (Throwable e) {
			}
		}
		
		@Test
		void isNotValidText() throws Exception {
			infoAdnDao.deleteAll();
				String json="{\"adnList\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\"]}";
				 mvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON).content(json))
					      .andExpect(status().is2xxSuccessful())
					      .andExpect(jsonPath("$.mensaje", is("[Tama�o de las listas no valido]")));

		}

		@Test
		void validatTtheListIfItIsCorrectisMutantTrue() throws Exception {
			infoAdnDao.deleteAll();

				String json="{\"adnList\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}";
				mvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON).content(json))
					      .andExpect(status().isOk())
					      .andExpect(jsonPath("$", is(true)));	
				List<InfoAdnEntity> elements = infoAdnDao.findAll();
				 assertEquals(3,elements.get(0).getCountDna());	
		}
		
		@Test
		void validatTtheListIfItIsCorrectisMutantFalse() throws Exception {
			infoAdnDao.deleteAll();

				String json="{\"adnList\":[\"GTGCTA\",\"TAGTGC\",\"TTATGT\",\"AGAATG\",\"CCACTA\",\"TCACTG\"]}";
				mvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON).content(json))
					      .andExpect(status().isOk())
					      .andExpect(jsonPath("$", is(false)));	
				List<InfoAdnEntity> elements = infoAdnDao.findAll();
				 assertEquals(0,elements.get(0).getCountDna());	
		}

		
		@Test
		void validatstats() throws Exception {
			infoAdnDao.deleteAll();

			String json="{\"adnList\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}";
			mvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON).content(json))
				      .andExpect(status().isOk());
				      
				mvc.perform(get("/stats"))
					      .andExpect(status().isOk())
					      .andExpect(jsonPath("$.countMutantDna", is(1)))
					      .andExpect(jsonPath("$.countHumanDna", is(3)))
					      .andExpect(jsonPath("$.ratio", is("0.4")))

					      ;	
		}
		
		@Test
		void validatstatsNoData() throws Exception {
			infoAdnDao.deleteAll();
				      
				mvc.perform(get("/stats"))
					      .andExpect(status().isOk())
					      .andExpect(jsonPath("$.countMutantDna", is(0)))
					      .andExpect(jsonPath("$.countHumanDna", is(0)))
					      .andExpect(jsonPath("$.ratio", is("0.0")))

					      ;	
		}
		
		@Test
		void validatstats2() throws Exception {
			infoAdnDao.deleteAll();

			String json="{\"adnList\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAATG\",\"CCCCTA\",\"TCACTG\"]}";
			mvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON).content(json))
				      .andExpect(status().isOk());
				      
				mvc.perform(get("/stats"))
					      .andExpect(status().isOk())
					      .andExpect(jsonPath("$.countMutantDna", is(1)))
					      .andExpect(jsonPath("$.countHumanDna", is(2)))
					      .andExpect(jsonPath("$.ratio", is("0.5")))

					      ;	
		}
		
		@Test
		@Timed(millis = 1000)
		void validatstatsConcurrent100() throws Exception {
			infoAdnDao.deleteAll();
			
			for (int i = 0; i < 100; i++) {
				String json="{\"adnList\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}";
				mvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON).content(json))
					      .andExpect(status().isOk());
			}


				      
				mvc.perform(get("/stats"))
					      .andExpect(status().isOk())
					      .andExpect(jsonPath("$.countMutantDna", is(100)))
					      .andExpect(jsonPath("$.countHumanDna", is(300)))
					      .andExpect(jsonPath("$.ratio", is("0.4")))

					      ;	
		}

}
