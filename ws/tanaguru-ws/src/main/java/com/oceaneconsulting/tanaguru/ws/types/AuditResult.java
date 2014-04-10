package com.oceaneconsulting.tanaguru.ws.types;

import java.io.Serializable;

public class AuditResult implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -13067243016941886L;
	
	
	private String url;
	private Float score;
	private String status;
	private String message;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Audit result [url=" + url + ", score=" + score + ", status="
				+ status + ", message=" + message + "]";
	}
	
	
}