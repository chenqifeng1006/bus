package com.cc.line.dto;

import java.util.Date;

public class Line {

	int id;
	
	String name;
	
	String allStationname;
	
	int busNum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAllStationname() {
		return allStationname;
	}

	public void setAllStationname(String allStationname) {
		this.allStationname = allStationname;
	}

	public int getBusNum() {
		return busNum;
	}

	public void setBusNum(int busNum) {
		this.busNum = busNum;
	}
	
	
}
