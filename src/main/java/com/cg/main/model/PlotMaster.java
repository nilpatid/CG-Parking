package com.cg.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table
public class PlotMaster
{

	@Id
	public String plotid;
    public String name;
    public boolean alloted;
    
    public PlotMaster(){}
    public PlotMaster(String plotid){
    	super();
		this.plotid = plotid;
		
    }
	public String getPlotid() {
		return plotid;
	}
	public void setPlotid(String plotid) {
		this.plotid = plotid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getAlloted() {
		return alloted;
	}
	public void setAlloted(boolean alloted) {
		this.alloted = alloted;
	}
	public PlotMaster(String plotid, String name, boolean alloted) {
		super();
		this.plotid = plotid;
		this.name = name;
		this.alloted = alloted;
	}
	public PlotMaster(String plotid, boolean alloted) {
		super();
		this.plotid = plotid;
		this.alloted = alloted;
	}
	@Override
	public String toString() {
		return "PlotMaster [plotid=" + plotid + ", name=" + name + ", alloted=" + alloted + "]";
	}
    
    
    
	
}