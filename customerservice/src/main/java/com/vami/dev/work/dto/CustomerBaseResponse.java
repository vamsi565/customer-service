package com.vami.dev.work.dto;

import org.springframework.http.HttpStatus;

public class CustomerBaseResponse {

	public CustomerBaseResponse(HttpStatus statusCode, boolean success) {
		super();
		this.statusCode = statusCode;
		this.success = success;
	}

	private HttpStatus statusCode;
	
	private boolean success;

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
