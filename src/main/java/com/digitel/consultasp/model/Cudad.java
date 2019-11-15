package com.digitel.consultasp.model;

public class Cudad {

	private String estado;
	private String ciudad;
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "Cudad [estado=" + estado + ", ciudad=" + ciudad + "]";
	}
	public Cudad(String estado, String ciudad) {
		super();
		this.estado = estado;
		this.ciudad = ciudad;
	}
	public Cudad() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
