package com.cg.main.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cg.main.model.PlotMaster;
import com.cg.main.model.SensorNodeDiscover;



@Transactional
public interface PlotMasterDAO extends CrudRepository<PlotMaster, Long> {

	List<PlotMaster> findByNameAndAlloted(String name,boolean alloted);
	PlotMaster findByPlotid(String plotId);




} 
