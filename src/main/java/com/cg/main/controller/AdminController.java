package com.cg.main.controller;

import java.util.List;

import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.main.DAO.BlockMasterDAO;
import com.cg.main.DAO.PlotMasterDAO;
import com.cg.main.DAO.SensorNodeDAO;
import com.cg.main.DAO.SensorNodeDiscoverDAO;
import com.cg.main.model.BlockMaster;
import com.cg.main.model.PlotMaster;
import com.cg.main.model.SensorNode;
import com.cg.main.model.SensorNodeDiscover;

@Controller
public class AdminController {
	@Autowired
	SensorNodeDiscoverDAO sensorNodeDiscoverDAO;
	@Autowired
	PlotMasterDAO plotMasterDAO;
	@Autowired
	SensorNodeDAO sensorNodeDAO;
		@Autowired
	BlockMasterDAO blockMasterDAO;

		// Admin controllers
	@CrossOrigin
	@RequestMapping(value = "/saveParkingMapping", method= RequestMethod.POST)
	@ResponseBody
	public String saveParkingMapping(@RequestBody List<SensorNode> nodemapping) {

		for (SensorNode node : nodemapping) {
			System.out.println("saving objects with " + node.getPlotId());
			node.setAvailable("2");
			sensorNodeDAO.save(node);
			sensorNodeDiscoverDAO.delete(new SensorNodeDiscover(node.getMacAddress()));
			PlotMaster p=plotMasterDAO.findByPlotid(node.getPlotId());
			p.setAlloted(true);
			plotMasterDAO.save(p);
		}
		return "success";
	}

	@CrossOrigin
	@RequestMapping(value = "/saveNewPlot")
	@ResponseBody
	public void saveNewPlot(@RequestBody List<PlotMaster> nodemapping) {

		for (PlotMaster node : nodemapping) {
			System.out.println("saving objects with " + node.getPlotid());
			plotMasterDAO.save(node);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/saveNewBlock")
	@ResponseBody
	public void saveNewBlock(@RequestBody List<BlockMaster> nodemapping) {

		for (BlockMaster node : nodemapping) {
			System.out.println("saving objects with " + node.getBlockName());
			blockMasterDAO.save(node);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getNodeDiscovery")	
	@ResponseBody
	public List<SensorNodeDiscover> NodeDiscovery() {
		return (List<SensorNodeDiscover>) sensorNodeDiscoverDAO.findAll();
	}

	@CrossOrigin
	@RequestMapping(value = "/getPlotId/{name}")
	@ResponseBody
	public List<PlotMaster> getPlotId(@PathVariable("name") String name) {
		return (List<PlotMaster>) plotMasterDAO.findByNameAndAlloted(name,false);
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/getBlock")
	@ResponseBody
	public List<BlockMaster> getBlock() {
		return (List<BlockMaster>) blockMasterDAO.findAllByOrderByBlockNameAsc();
	}
	
}
