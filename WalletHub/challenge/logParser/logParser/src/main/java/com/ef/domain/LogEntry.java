package com.ef.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logentry")
public class LogEntry {

	@Id
	private Long id;
	
	@Column(name="ip")
	private String ip;
	
	private String date;
	
	private String request;
	
	private String status;
	
	private String userAgent;

	public LogEntry(String ip, String date, String request, String status, String userAgent) {
		
		super();
		this.ip = ip;
		this.date = date;
		this.request = request;
		this.status = status;
		this.userAgent = userAgent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	
}
