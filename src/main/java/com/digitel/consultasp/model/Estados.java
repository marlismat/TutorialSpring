package com.digitel.consultasp.model;

import java.util.List;


public class Estados {

	private List<Estado> Estado;

	public List<Estado> getEstado() {
		return Estado;
	}

	public void setEstado(List<Estado> estado) {
		Estado = estado;
	}

	@Override
	public String toString() {
		return "Estados [Estado=" + Estado + "]";
	}

	public Estados(List<Estado> estado) {
		super();
		Estado = estado;
	}

	public Estados() {
		super();
	}
	
	

}
