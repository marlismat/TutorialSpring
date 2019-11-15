package com.digitel.consultasp.model;

public class SuperInfo {
	private UserTypes userType;
	private Ciudades ciudades;
	
	
	
	public SuperInfo() {
		super();
	}



	public SuperInfo(UserTypes userType, Ciudades ciudades) {
		super();
		this.userType = userType;
		this.ciudades = ciudades;
	}



	@Override
	public String toString() {
		return "SuperInfo [userType=" + userType + ", ciudades=" + ciudades + "]";
	}



	public UserTypes getUserType() {
		return userType;
	}



	public void setUserType(UserTypes userType) {
		this.userType = userType;
	}



	public Ciudades getCiudades() {
		return ciudades;
	}



	public void setCiudades(Ciudades ciudades) {
		this.ciudades = ciudades;
	}



}
