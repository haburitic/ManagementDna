package com.proyect.management.interfaces;

import com.proyect.management.dto.ProcessInfoDTO;
import com.proyect.management.dto.RequestDTO;

/**
 * Traverse DnaList.
 * @author HABUR
 *
 */
public interface ITraverseDnaList {
	/**
	 * method Traverse dnaList.
	 * @param dna RequestDTO.
	 * @return ProcessInfoDTO.
	 */
	public ProcessInfoDTO dnaList(final RequestDTO dna);

}
