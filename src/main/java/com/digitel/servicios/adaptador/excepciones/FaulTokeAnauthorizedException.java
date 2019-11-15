package com.digitel.servicios.adaptador.excepciones;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.UNAUTHORIZED)
public class FaulTokeAnauthorizedException extends RuntimeException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7241455786983012685L;
	

	public FaulTokeAnauthorizedException(String msg) {
		super(msg);
	}

	public FaulTokeAnauthorizedException(String msg, Throwable t) {
		super(msg, t);
	}
	
}