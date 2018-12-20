package com.demo.stationapp.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.stationapp.entity.Station;
import com.demo.stationapp.exception.DataNotFoundException;
import com.demo.stationapp.repository.StationRepository;

@Service
@Transactional
public class StationService {

	@Autowired
	private StationRepository stationRepo;
	
	public List<Station> findAllStations() {
		return (List<Station>) stationRepo.findAll();
	}
	
	public Station createStation(Station station) {
		String stationId = UUID.randomUUID().toString();
		station.setStationId(stationId);
		stationRepo.save(station);
		return station;
	}
	
	public void updateStation(Station station) {
		String stationId = station.getStationId();
		Station actualStation = stationRepo.findOne(stationId);
		
		if(Objects.isNull(actualStation)) {
			throw new DataNotFoundException("The reqested stationId: "+stationId+" not present.");
		}
		
		stationRepo.save(station);
	}
	
	public void deleteStationById(String stationId) {
		if(Objects.isNull(stationRepo.findOne(stationId))) {
			throw new DataNotFoundException("The reqested stationId: "+stationId+" not present.");
		}
		stationRepo.delete(stationId);
	}
}
