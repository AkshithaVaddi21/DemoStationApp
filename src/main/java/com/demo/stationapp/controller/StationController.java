package com.demo.stationapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		return stationService.findAllStations();
	}
	
	@PostMapping
	public ResponseEntity<Station> createStation(@RequestBody Station station) {
		 station = stationService.createStation(station);
		return new ResponseEntity<>(station, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Station> updateStation(@RequestBody Station station) {
		stationService.updateStation(station);
		return new ResponseEntity<>(station, HttpStatus.ACCEPTED);
	}

	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<HttpStatus> removeStationByStationId(@PathVariable("id") String stationId) {
		stationService.deleteStationById(stationId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
