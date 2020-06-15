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
import com.demo.stationapp.model.ErrorMessage;
import com.demo.stationapp.service.StationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/station")
@Api(tags = "Station Controller")
public class StationController {

	@Autowired
	private StationService stationService;
	
	@ApiOperation(value = "search all station", notes = "", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "retrieved stations successfully", response = Station.class),
			@ApiResponse(code = 400, message = "Invalid request parameters", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Server error retrieving stations", response = ErrorMessage.class) })
	@GetMapping
	public List<Station> findAllStations(Station station) {
		return stationService.findAllStations(station);
	}
	
	@ApiOperation(value = "Create station", notes = "", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Station created successfully", response = Station.class),
			@ApiResponse(code = 400, message = "Invalid request parameters", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Server error creating station", response = ErrorMessage.class) })
	@PostMapping
	public ResponseEntity<Station> createStation(@RequestBody Station station) {
		 station = stationService.createStation(station);
		return new ResponseEntity<>(station, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update station", notes = "", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "Station created successfully", response = Station.class),
			@ApiResponse(code = 404, message = "Invalid request parameters", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Server error updating station", response = ErrorMessage.class) })
	@PutMapping(value="/{id}")
	public ResponseEntity<Station> updateStation(@PathVariable("id") String stationId, @RequestBody Station station) {
		station.setStationId(stationId);
		stationService.updateStation(station);
		return new ResponseEntity<>(station, HttpStatus.ACCEPTED);
	}
	
	@ApiOperation(value = "remove station", notes = "", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "Station deleted successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Invalid request parameters", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Server error deleting station", response = ErrorMessage.class) })
	@DeleteMapping(value="/{id}")
	public ResponseEntity<HttpStatus> removeStationByStationId(@PathVariable("id") String stationId) {
		stationService.deleteStationById(stationId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
