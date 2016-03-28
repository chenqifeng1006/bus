package com.cc.driver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cc.bus.dao.BusMapper;
import com.cc.bus.dto.Bus;
import com.cc.driver.dao.DriverMapper;
import com.cc.driver.dto.Driver;
import com.cc.line.dao.LineMapper;
import com.utils.common.JPage;

@Service
@Transactional
public class DriverService {
	
	@Autowired
	private DriverMapper driverMapper;
	@Autowired
	private BusMapper busMapper;
	@Autowired
	private LineMapper lineMapper;
	
	public List<Driver> queryList(JPage page){
		return this.driverMapper.queryList(page);
	}
	
	public int count(){
		return this.driverMapper.count();
	}
	
	
	public Driver getByLoginId(String loginId){
		return this.driverMapper.getByLoginId(loginId);
	}
	
	public void updateInfo(Driver driver){
		this.driverMapper.updateInfo(driver);
	}
	
	public void updatePassword(Driver driver){
		this.driverMapper.updatePassword(driver);
	}
	
	public void update(Driver driver){
		this.driverMapper.update(driver);
	}
	
	public int add(Driver driver){
		return this.driverMapper.add(driver);
	}
	
	public void delete(Driver driver){
		int driverId = driver.getId();
		this.busMapper.removeDriver(driverId);
		this.driverMapper.delete(driver);
	}
	
	public Driver getById(Driver driver){
		return this.driverMapper.getById(driver);
	}
	
	public void bindBus(Driver d,Bus b){
		Driver driver = this.driverMapper.getById(d);
		Bus bus = this.busMapper.getById(b);
		driver.setBusId(bus.getId());
		bus.setDriverId(driver.getId());
		this.driverMapper.update(driver);
		this.busMapper.update(bus);
	}
	
	public void unBindBus(Driver d,Bus b){
		Driver driver = this.driverMapper.getById(d);
		Bus bus = this.busMapper.getById(b);
		driver.setBusId(0);
		bus.setDriverId(0);
		this.driverMapper.update(driver);
		this.busMapper.update(bus);
	}
	
	public void removeBus(int busId){
		this.driverMapper.removeBus(busId);
	}

}