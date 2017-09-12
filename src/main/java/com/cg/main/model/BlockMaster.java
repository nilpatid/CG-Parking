package com.cg.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table
public class BlockMaster
{

	@Id
	public String blockName;
    public String BlockLocation;
    public String Plots;
    
    public BlockMaster(){}
    public BlockMaster(String blockName){
    	super();
		this.blockName = blockName;
		
    }
	public BlockMaster(String blockName, String blockLocation, String plots) {
		super();
		this.blockName = blockName;
		BlockLocation = blockLocation;
		Plots = plots;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public String getBlockLocation() {
		return BlockLocation;
	}
	public void setBlockLocation(String blockLocation) {
		BlockLocation = blockLocation;
	}
	public String getPlots() {
		return Plots;
	}
	public void setPlots(String plots) {
		Plots = plots;
	}
	@Override
	public String toString() {
		return "BlockMaster [blockName=" + blockName + ", BlockLocation=" + BlockLocation + ", Plots=" + Plots + "]";
	}
    
	
    
    
	
}