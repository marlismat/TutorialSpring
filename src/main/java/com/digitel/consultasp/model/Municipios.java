package com.digitel.consultasp.model;

import java.util.List;

public class Municipios {

 private List<Municipio> Municipios;

@Override
public String toString() {
	return "Municipios [Municipios=" + Municipios + "]";
}

public Municipios(List<Municipio> municipios) {
	super();
	Municipios = municipios;
}

public List<Municipio> getMunicipios() {
	return Municipios;
}

public void setMunicipios(List<Municipio> municipios) {
	Municipios = municipios;
}

public Municipios() {
	super();
	// TODO Auto-generated constructor stub
} 
 
 
}
