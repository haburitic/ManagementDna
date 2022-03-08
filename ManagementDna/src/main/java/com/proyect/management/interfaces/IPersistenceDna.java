package com.proyect.management.interfaces;

import com.proyect.management.dto.ProcessInfoDTO;

/**
 * PersistenceDna interface.
 * @author HABUR
 *
 */
public interface IPersistenceDna {
	
	/**
	 * save process response. 
	 * @param request ProcessInfoDTO.
	 */
	public void saveRegister(final ProcessInfoDTO request) ;
}
