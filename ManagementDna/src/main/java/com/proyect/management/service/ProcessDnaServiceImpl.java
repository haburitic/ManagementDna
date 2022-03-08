package com.proyect.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.management.dto.ProcessInfoDTO;
import com.proyect.management.dto.RequestDTO;
import com.proyect.management.interfaces.IPersistenceDna;
import com.proyect.management.interfaces.IProcessDna;
import com.proyect.management.interfaces.ITraverseDnaList;
import com.proyect.management.interfaces.IValidateDna;

/**
 * Service ProcessDna.
 * @author HABUR
 *
 */
@Service
public class ProcessDnaServiceImpl implements IProcessDna {

	@Autowired
	ITraverseDnaList taverseDnaList;

	@Autowired
	IPersistenceDna persistenceDna;
	
	@Autowired
	IValidateDna validateDna;

	@Override
	public Boolean processArray(RequestDTO dna) {
		
		validateDna.validateDnaList(dna);

		ProcessInfoDTO response = taverseDnaList.dnaList(dna);
		response.setAdnList(dna.getAdnList());
		persistenceDna.saveRegister(response);

		return response.getCountMutant() > 0;
	}

}
