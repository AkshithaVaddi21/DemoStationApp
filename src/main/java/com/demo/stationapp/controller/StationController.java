package com.demo.stationapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.stationapp.entity.Station;
import com.demo.stationapp.service.StationService;

@RestController
@RequestMapping("/station")
public class StationController {

	@Autowired
	private StationService stationService;
	
	@GetMapping
	public List<Station> findAllStations() {
		List<Station> stations = stationService.findAllStations();
		return stations;
	}
	
}
