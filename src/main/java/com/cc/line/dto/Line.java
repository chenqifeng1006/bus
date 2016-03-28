package com.cc.line.dto;

import java.util.Date;

public class Line {

	int id;
	
	String name;
	
	String firstStation;
	
	String lastStation;
	
	Date firstStationEarlystTime;
	
	Date lastStationEarlyStTime;
	
	Date firstStationLastestTime;
	
	Date lastStationLastestTime;
	
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

	public String getFirstStation() {
		return firstStation;
	}

	public void setFirstStation(String firstStation) {
		this.firstStation = firstStation;
	}

	public String getLastStation() {
		return lastStation;
	}

	public void setLastStation(String lastStation) {
		this.lastStation = lastStation;
	}

	public Date getFirstStationEarlystTime() {
		return firstStationEarlystTime;
	}

	public void setFirstStationEarlystTime(Date firstStationEarlystTime) {
		this.firstStationEarlystTime = firstStationEarlystTime;
	}

	public Date getLastStationEarlyStTime() {
		return lastStationEarlyStTime;
	}

	public void setLastStationEarlyStTime(Date lastStationEarlyStTime) {
		this.lastStationEarlyStTime = lastStationEarlyStTime;
	}

	public Date getFirstStationLastestTime() {
		return firstStationLastestTime;
	}

	public void setFirstStationLastestTime(Date firstStationLastestTime) {
		this.firstStationLastestTime = firstStationLastestTime;
	}

	public Date getLastStationLastestTime() {
		return lastStationLastestTime;
	}

	public void setLastStationLastestTime(Date lastStationLastestTime) {
		this.lastStationLastestTime = lastStationLastestTime;
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
