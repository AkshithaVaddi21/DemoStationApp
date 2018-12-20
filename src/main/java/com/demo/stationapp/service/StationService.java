package com.demo.stationapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.stationapp.entity.Station;
import com.demo.stationapp.repository.StationRepository;

@Service
public class StationService {

	@Autowired
	private StationRepository stationRepo;
	
	public List<Station> findAllStations() {
		List<Station> stations = (List<Station>) stationRepo.findAll();
		return stations;
	}
}
