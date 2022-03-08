package com.proyect.management.dto;

/**
 * dto frror.
 * @author HABUR
 *
 */
public class ErrorDTO {


	private String mensaje;

	private String codigo;

	private String detalle;

	public ErrorDTO(String codigo, String mensaje, String detalle) {
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.detalle = detalle;

	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	
	
}
