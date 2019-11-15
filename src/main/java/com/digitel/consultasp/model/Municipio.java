package com.digitel.consultasp.model;

public class Municipio {

	private String municipio;
	private String ciudad;
	
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "Muncipio [municipio=" + municipio + ", ciudad=" + ciudad + "]";
	}
	public Municipio(String municipio, String ciudad) {
		super();
		this.municipio = municipio;
		this.ciudad = ciudad;
	}
	public Municipio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
