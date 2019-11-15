package com.digitel.consultasp.model;

import java.util.List;

public class Ciudades {

	private List<Ciudades> ciudades;

	public List<Ciudades> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudades> ciudades) {
		this.ciudades = ciudades;
	}

	@Override
	public String toString() {
		return "Ciudades [ciudades=" + ciudades + "]";
	}

	public Ciudades(List<Ciudades> ciudades) {
		super();
		this.ciudades = ciudades;
	}

	public Ciudades() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
