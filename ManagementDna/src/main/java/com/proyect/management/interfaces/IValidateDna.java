package com.proyect.management.interfaces;

import com.proyect.management.dto.RequestDTO;

/**
 * interface interface.
 * @author HABUR
 *
 */
public interface IValidateDna {
	
	/**
	 * validate DnaList.
	 * @param dna RequestDTO.
	 * @return boolean is valid.
	 */
	public boolean validateDnaList(final RequestDTO  dna);

}
