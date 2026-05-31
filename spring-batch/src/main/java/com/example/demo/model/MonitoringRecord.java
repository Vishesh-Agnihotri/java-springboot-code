package com.example.demo.model;

public class MonitoringRecord {

	private String serviceName;
	private String status;

	public MonitoringRecord() {
	}

	public MonitoringRecord(String serviceName, String status) {
		this.serviceName = serviceName;
		this.status = status;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
