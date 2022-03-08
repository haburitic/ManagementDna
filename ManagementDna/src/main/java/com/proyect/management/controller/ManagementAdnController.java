package com.proyect.management.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.management.dto.RequestDTO;
import com.proyect.management.dto.StatisticsDTO;
import com.proyect.management.interfaces.IDnaStatistics;
import com.proyect.management.interfaces.IProcessDna;


/**
 * Management Adn.
 * @author HABUR
 *
 */
@RestController
@RequestMapping("/")

public class ManagementAdnController {
	
	@Autowired
	private IProcessDna processDna;
	
	@Autowired
	private IDnaStatistics dnaStatistics;


    
    /**
     * process list, method post.
     * @param dna RequestDTO.
     * @param result BindingResult.
     * @return
     */
    @PostMapping(path = "/mutant", produces = "application/json")
    public ResponseEntity<Boolean> processArrayDna(@RequestBody @Valid RequestDTO dna) {
    	return ResponseEntity.ok().body(processDna.processArray(dna));
    	
    }
    
    /**
     * finds  Statistics.
     * @return StatisticsDTO response.
     */
    @GetMapping(path = "/stats", produces = "application/json")
    public ResponseEntity<StatisticsDTO> stats() {
    	return ResponseEntity.ok().body(dnaStatistics.process());
    	
    }

}
