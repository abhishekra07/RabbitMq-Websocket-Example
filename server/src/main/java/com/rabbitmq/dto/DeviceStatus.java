package com.rabbitmq.dto;

public class DeviceStatus {

	private String serialNumber;
	private String  productType;
	private String deviceStatus;
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getDeviceStatus() {
		return deviceStatus;
	}
	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	@Override
	public String toString() {
		return "DeviceStatus [serialNumber=" + serialNumber + ", productType=" + productType + ", deviceStatus="
				+ deviceStatus + "]";
	}
}
