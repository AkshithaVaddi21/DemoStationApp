package com.demo.stationapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STATION")
public class Station implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "STATIONID")
	private String stationId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "HDENABLED")
	private boolean hdEnabled;
	
	@Column(name = "CALLSIGN")
	private String callSign;

}
