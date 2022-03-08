package com.proyect.management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.management.dto.ProcessInfoDTO;
import com.proyect.management.entity.InfoAdnDetailEntity;
import com.proyect.management.entity.InfoAdnEntity;
import com.proyect.management.interfaces.IPersistenceDna;
import com.proyect.management.repository.InfoAdnDao;

@Service
public class PersistenceDnaServiceImpl implements  IPersistenceDna{

	@Autowired
	private InfoAdnDao infoAdnDao;
	 
	@Override
	public void saveRegister(final ProcessInfoDTO request) {
		InfoAdnEntity entity = new InfoAdnEntity();
		entity.setCountDna(request.getCountMutant());
		
		
		 List<InfoAdnDetailEntity> elementList = request.getAdnList().stream().collect(    Collectors.mapping(
			      p -> new InfoAdnDetailEntity(p, entity),
			      Collectors.toList()));

	
	    
		entity.setInfoAdnDetailList(elementList);

		infoAdnDao.save(entity);
		
	}


}
