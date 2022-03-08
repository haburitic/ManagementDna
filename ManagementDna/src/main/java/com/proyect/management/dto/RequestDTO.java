package com.proyect.management.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

/**
 * process request.
 * 
 * @author HABUR
 *
 */
public class RequestDTO {
	@NotEmpty
	private List<@NotNull(message = "no puede estar vacio") @Pattern(regexp = "^[ATCG]+$", message = "no cumple la exprecion regular") @Length(max = 6, min = 6, message = "no cunple con el tamaño requerido") String> adnList;

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
