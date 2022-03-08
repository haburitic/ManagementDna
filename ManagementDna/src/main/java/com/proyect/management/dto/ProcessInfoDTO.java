package com.proyect.management.dto;

import java.util.List;

/**
 * almacena los resultados del proceso.
 * @author HABUR
 *
 */
public class ProcessInfoDTO {
	
	private  char[][]  mutanteList;
	private int countMutant;
	private List<String> adnList;


	/**
	 * @return the mutanteList
	 */
	public char[][] getMutanteList() {
		return mutanteList;
	}

	/**
	 * @param mutanteList the mutanteList to set
	 */
	public void setMutanteList(char[][] mutanteList) {
		this.mutanteList = mutanteList;
	}

	/**
	 * @return the countMutant
	 */
	public int getCountMutant() {
		return countMutant;
	}


	
	public void incrementMutant() {
		countMutant++;
	}

	/**
	 * @return the adnList
	 */
	public List<String> getAdnList() {
		return adnList;
	}

	/**
	 * @param adnList the adnList to set
	 */
	public void setAdnList(List<String> adnList) {
		this.adnList = adnList;
	}
	
	

}
