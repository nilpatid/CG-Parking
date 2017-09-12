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

import com.cg.main.DAO.PlotMasterDAO;
import com.cg.main.DAO.SensorNodeDAO;
import com.cg.main.DAO.SensorNodeDiscoverDAO;
import com.cg.main.model.PlotMaster;
import com.cg.main.model.SensorNode;
import com.cg.main.model.SensorNodeDiscover;

@Controller
public class ParkingController {
	@Autowired
	SensorNodeDiscoverDAO sensorNodeDiscoverDAO;
	@Autowired
	PlotMasterDAO plotMasterDAO;
	@Autowired
	SensorNodeDAO sensorNodeDAO;

	

	@CrossOrigin
	@RequestMapping(value = "/getParkingData")
	@ResponseBody
	public List<SensorNode> getParkingMain() {
		return (List<SensorNode>) sensorNodeDAO.findAllByOrderByPlotIdAsc();
	}

	@CrossOrigin
	@RequestMapping(value = "/saveDiscovery")
	@ResponseBody
	public void saveDiscovery(@RequestBody List<SensorNodeDiscover> nodemapping) {

		for (SensorNodeDiscover node : nodemapping) {
			List<SensorNode> gotnode=sensorNodeDAO.findAllByMacAddress(node.getMacAddress());
			if(gotnode.size()>0){
				SensorNode sensorNode=new SensorNode(node.getIpAddress(), node.getMacAddress());
				sensorNodeDAO.save(sensorNode);
			}
			System.out.println("saving objects with " + node.getMacAddress());
			sensorNodeDiscoverDAO.save(node);
		}
	}
	@CrossOrigin
	@RequestMapping(value = "/saveParkingStatus")
	@ResponseBody
	public void saveParkingStatus(@RequestBody List<SensorNode> nodemapping) {

		for (SensorNode node : nodemapping) {
			System.out.println("saving objects with " + node.getMacAddress());
			sensorNodeDAO.save(node);
		}
	}
}
