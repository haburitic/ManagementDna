package com.proyect.management.service;

import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.proyect.management.dto.RequestDTO;
import com.proyect.management.interfaces.IValidateDna;

/**
 * class validated RequestDTO.
 * @author HABUR
 *
 */
@Service
public class ValidateDnaServiceImpl implements  IValidateDna{

	@Override
	public boolean validateDnaList(final RequestDTO dnaList) {
		
		if(dnaList.getAdnList().size()!=6) {
			throw new ValidationException("Tama�o de las listas no valido");
		}
		return false;
	}


}
