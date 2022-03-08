package com.proyect.management.dto;

import java.util.List;


/**
 * Dto que almacena la respuesta de los errores.
 * @author hburiticao
 *
 */

public class ApiErrorsViewDTO {
	
	
  private List<ErrorDTO> listaErrores;

  private List<ApiGlobalErrorDTO> globalErrors;
  
  

/**
 * @param listaErrores
 * @param globalErrors
 */
public ApiErrorsViewDTO(List<ErrorDTO> listaErrores, List<ApiGlobalErrorDTO> globalErrors) {
	super();
	this.listaErrores = listaErrores;
	this.globalErrors = globalErrors;
}

/**
 * @return the listaErrores
 */
public List<ErrorDTO> getListaErrores() {
	return listaErrores;
}

/**
 * @param listaErrores the listaErrores to set
 */
public void setListaErrores(List<ErrorDTO> listaErrores) {
	this.listaErrores = listaErrores;
}

/**
 * @return the globalErrors
 */
public List<ApiGlobalErrorDTO> getGlobalErrors() {
	return globalErrors;
}

/**
 * @param globalErrors the globalErrors to set
 */
public void setGlobalErrors(List<ApiGlobalErrorDTO> globalErrors) {
	this.globalErrors = globalErrors;
}


  
  
}