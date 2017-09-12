package com.cg.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table
public class SensorNode
{

	
	public String ipAddress;
	@Id
    public String macAddress;
    public String available;
    public String plotId;
    
    
    public SensorNode(){}
    
	public SensorNode(String ipAddress, String macAddress, String available, String plotId) {
		super();
		this.ipAddress = ipAddress;
		this.macAddress = macAddress;
		this.available = available;
		this.plotId = plotId;
	}
	public SensorNode(String ipAddress, String macAddress) {
		super();
		this.ipAddress = ipAddress;
		this.macAddress = macAddress;
	}
	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String isAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	

	public String getPlotId() {
		return plotId;
	}

	public void setPlotId(String plotId) {
		this.plotId = plotId;
	}

	@Override
	public String toString() {
		return "SensorNode [ipAddress=" + ipAddress + ", macAddress=" + macAddress + ", available=" + available
				+ ", plotId=" + plotId + "]";
	}

	
   

	
}