package com.cc.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cc.bus.dao.BusMapper;
import com.cc.bus.dto.Bus;
import com.cc.driver.dao.DriverMapper;
import com.cc.driver.dto.Driver;
import com.cc.line.dao.LineMapper;
import com.cc.line.dto.Line;
import com.utils.common.JPage;

@Service
@Transactional
public class BusService {
	
	@Autowired
	private DriverMapper driverMapper;
	@Autowired
	private BusMapper busMapper;
	@Autowired
	private LineMapper lineMapper;
	
	public List<Bus> queryList(JPage page){
		return this.busMapper.queryList(page);
	}
	
	public int count(){
		return this.busMapper.count();
	}
	
	public int countByLineId(Bus bus){
		return this.busMapper.countByLineId(bus);
	}
	
	public void update(Bus bus){
		this.busMapper.update(bus);
	}
	
	public int add(Bus bus){
		return this.busMapper.add(bus);
	}
	
	public void delete(Bus bus){
		this.busMapper.delete(bus);
	}
	
	public Bus getById(Bus bus){
		return this.busMapper.getById(bus);
	}
	
	public void bindDriver(Bus b,Driver d){
		Bus bus = this.busMapper.getById(b);
		Driver driver = this.driverMapper.getById(d);
		bus.setDriverId(driver.getId());
		driver.setBusId(bus.getId());
		this.busMapper.update(bus);
		this.driverMapper.update(driver);
	}
	
	public void unBindDriver(Bus b,Driver d){
		Bus bus = this.busMapper.getById(b);
		Driver driver = this.driverMapper.getById(d);
		bus.setDriverId(0);
		driver.setBusId(0);
		this.busMapper.update(bus);
		this.driverMapper.update(driver);
	}
	
	
	public void bindLine(Bus b,Line l){
		Bus bus = this.busMapper.getById(b);
		Line line = this.lineMapper.getById(l);
		bus.setLineId(line.getId());
		this.busMapper.update(bus);
	}
	
	public void unBindLine(Bus b){
		Bus bus = this.busMapper.getById(b);
		bus.setLineId(0);
		this.busMapper.update(bus);
	}
	

}