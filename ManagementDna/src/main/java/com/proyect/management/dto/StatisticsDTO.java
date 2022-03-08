package com.proyect.management.dto;

/**
 * Statistics DTO.
 * @author HABUR
 *
 */
public class StatisticsDTO {
	private Integer countMutantDna;
	private Integer countHumanDna;
	private String ratio;
	
	
	
	/**
	 * @param cantidad
	 * @param suma
	 */
	public StatisticsDTO(Integer countMutantDna, Integer countHumanDna,String string) {
		super();
		this.countMutantDna = countMutantDna;
		this.countHumanDna = countHumanDna;
		this.ratio = string;

	}



	/**
	 * @return the countMutantDna
	 */
	public Integer getCountMutantDna() {
		return countMutantDna;
	}


	/**
	 * @return the countHumanDna
	 */
	public Integer getCountHumanDna() {
		return countHumanDna;
	}



	/**
	 * @param countHumanDna the countHumanDna to set
	 */
	public void setCountHumanDna(Integer countHumanDna) {
		this.countHumanDna = countHumanDna;
	}



	/**
	 * @return the ratio
	 */
	public String getRatio() {
		return ratio;
	}



	/**
	 * @param ratio the ratio to set
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}


	
}
