package com.proyect.management.dto;

/**
 * dto que se llena cuando se generen errores globales.
 * @author hburiticao
 *
 */

public class ApiGlobalErrorDTO {
  private String code;
  
  

public ApiGlobalErrorDTO(String code) {
	super();
	this.code = code;
}

/**
 * @return the code
 */
public String getCode() {
	return code;
}

/**
 * @param code the code to set
 */
public void setCode(String code) {
	this.code = code;
}
  
}