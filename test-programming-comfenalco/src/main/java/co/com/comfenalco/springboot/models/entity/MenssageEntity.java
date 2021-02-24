package co.com.comfenalco.springboot.models.entity;

import java.io.Serializable;

public class MenssageEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String codError;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCodError() {
		return codError;
	}

	public void setCodError(String codError) {
		this.codError = codError;
	}
	
}
