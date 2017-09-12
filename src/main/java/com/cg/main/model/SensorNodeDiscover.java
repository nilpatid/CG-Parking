package com.cg.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table
public class SensorNodeDiscover
{

	
	public String ipAddress;
	@Id
    public String macAddress;
    
    public SensorNodeDiscover(){}
    public SensorNodeDiscover(String macAddress){super(); this.macAddress = macAddress;}
    
	public SensorNodeDiscover(String ipAddress, String macAddress) {
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

	@Override
	public String toString() {
		return "SensorNodeDiscover [ipAddress=" + ipAddress + ", macAddress=" + macAddress + "]";
	}

	
}