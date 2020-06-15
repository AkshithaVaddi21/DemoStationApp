package com.demo.stationapp.service;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.demo.stationapp.entity.Station;

public class StationSpec {

	public static Specification<Station> getStationsByCriteria(Station station) {
		return (root, query, cb) -> {
			 List<Predicate> list = new ArrayList<>();
			 if(nonNull(station.getName()))
				 list.add(cb.equal(root.get("name"), station.getName()));
			 if(nonNull(station.getStationId()))
				 list.add(cb.equal(root.get("stationId"), station.getStationId()));
			 if(nonNull(station.getHdEnabled()))
				 list.add(cb.equal(root.get("hdEnabled"), station.getHdEnabled()));
			 
			 return cb.and(list.toArray(new Predicate[0]));
		};
	}
	
	public static Specification<Station> hasStationId(String stationId) {
		return (root, query, cb) -> nonNull(stationId) ? cb.equal(root.get("stationId"), stationId) : null;
	}
	
	public static Specification<Station> hasName(String name) {
		return (root, query, cb) -> nonNull(name) ? cb.equal(root.get("name"), name) : null;
	}
	
	public static Specification<Station> hasHDEnabled(Boolean hdEnabled) {
		return (root, query, cb) -> nonNull(hdEnabled) ? cb.equal(root.get("hdEnabled"), hdEnabled): null;
	}


}
