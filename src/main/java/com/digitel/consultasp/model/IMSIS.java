package com.digitel.consultasp.model;

import java.util.List;

public class IMSIS {

	  private List<IMSI> IMSIS;
	  private String codigo;
	  private String mensaje;
	  private String execution_code;
	  
	public IMSIS(List<IMSI> iMSIS) {
		super();
		IMSIS = iMSIS;
	}

	public IMSIS(List<IMSI> iMSIS, String codigo, String mensaje, String execution_code) {
		super();
		IMSIS = iMSIS;
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.execution_code = execution_code;
	}

	public List<IMSI> getIMSIS() {
		return IMSIS;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getExecution_code() {
		return execution_code;
	}

	public void setExecution_code(String execution_code) {
		this.execution_code = execution_code;
	}

	public void setIMSIS(List<IMSI> iMSIS) {
		IMSIS = iMSIS;
	}

	public IMSIS() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
