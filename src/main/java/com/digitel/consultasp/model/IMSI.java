package com.digitel.consultasp.model;


public class IMSI {

	  private String MSISDN;
	  private String IMSI;
	  private String VAR_OUT;
	public String getMSISDN() {
		return MSISDN;
	}
	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}
	public String getIMSI() {
		return IMSI;
	}
	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}
	public String getVAR_OUT() {
		return VAR_OUT;
	}
	public void setVAR_OUT(String vAR_OUT) {
		VAR_OUT = vAR_OUT;
	}
	@Override
	public String toString() {
		return "Imsi2 [MSISDN=" + MSISDN + ", IMSI=" + IMSI + ", VAR_OUT=" + VAR_OUT + "]";
	}
	public IMSI(String mSISDN, String iMSI, String vAR_OUT) {
		super();
		MSISDN = mSISDN;
		IMSI = iMSI;
		VAR_OUT = vAR_OUT;
	}
	public IMSI() {
		super();
		// TODO Auto-generated constructor stub
	}

}
