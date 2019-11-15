package com.digitel.consultasp.model;

public class Estado {

	private String Estado;

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	@Override
	public String toString() {
		return "Estado [Estado=" + Estado + "]";
	}

	public Estado(String estado) {
		super();
		Estado = estado;
	}

	public Estado() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
