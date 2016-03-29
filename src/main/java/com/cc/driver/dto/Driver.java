package com.cc.driver.dto;

public class Driver {

	int id;
	
	String loginId;
	
	String username;
	
	String password;
	
	String telephone;
	
	String lisenceno;
	
	public int getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(int maxPerson) {
		this.maxPerson = maxPerson;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getAllStationName() {
		return allStationName;
	}

	public void setAllStationName(String allStationName) {
		this.allStationName = allStationName;
	}

	int maxPerson;
	
	int busId;
	
	String busNo;
	
	String lineName;
	
	String allStationName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getLisenceno() {
		return lisenceno;
	}

	public void setLisenceno(String lisenceno) {
		this.lisenceno = lisenceno;
	}
	
	
	
}
