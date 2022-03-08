package com.proyect.management.dto;

/**
 * posociona elemento en la lista.
 * @author HABUR
 *
 */
public class PosicionElementDTO {
	private Integer fila,columna;

	public PosicionElementDTO(Integer fila, Integer columna) {
		super();
		this.fila = fila;
		this.columna = columna;
	}

	/**
	 * @return the fila
	 */
	public Integer getFila() {
		return fila;
	}



	/**
	 * @return the columna
	 */
	public Integer getColumna() {
		return columna;
	}



}
