package com.digitel.consultasp.model;

public class UserTypes {

	private String userType;
	private String  code;
	private String  result;

	
	
	
	public UserTypes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserTypes(String userType, String code, String result) {
		super();
		this.userType = userType;
		this.code = code;
		this.result = result;
	}
	@Override
	public String toString() {
		return "UserTypes [userType=" + userType + ", code=" + code + ", result=" + result + "]";
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
