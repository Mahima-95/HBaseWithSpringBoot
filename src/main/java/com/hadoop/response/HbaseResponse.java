package com.hadoop.response;

public class HbaseResponse {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HbaseResponse [message=" + message + "]";
	}

}
