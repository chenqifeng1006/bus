package com.cc.bus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.base.BaseController;
import com.cc.bus.dto.Bus;
import com.cc.bus.service.BusService;
import com.cc.driver.dto.Driver;
import com.cc.line.dto.Line;
import com.utils.common.JPage;
import com.utils.common.PageDTO;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;
import com.utils.token.CookieHandler;



@Controller
@RequestMapping("bus")
public class BusController extends BaseController {
	
	@Autowired
	private CookieHandler cookieHandler;
	@Autowired
	private BusService busService;
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public JsonObject add(@Validated Bus bus,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		int id = this.busService.add(bus);
		
		return new JsonData(id);
	}
	
	
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public JsonObject update(@Validated Bus bus,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		
		this.busService.update(bus);
		
		return new JsonData(bus);
	}
	
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public JsonObject queryList(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") Integer pageCount) throws Exception {
		JPage page = new JPage(startNum,pageCount);
		List<Bus> list = this.busService.queryList(page);		
		int count = this.busService.count();
		int currentPage = startNum/pageCount + 1;
		PageDTO dto = new PageDTO();		
		dto.setList(list);
		dto.setCount(count);
		dto.setStartNum(startNum);
		dto.setCurrentPage(currentPage);
		dto.setPageCount(pageCount);			
		return new JsonData(dto);
	}
	
	
	@RequestMapping(value = "/queryNoDriverList")
	@ResponseBody
	public JsonObject queryNoDriverList(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") Integer pageCount) throws Exception {
		JPage page = new JPage(startNum,pageCount);
		List<Bus> list = this.busService.queryNoDriverList(page);		
		int count = this.busService.noDriverCount();
		int currentPage = startNum/pageCount + 1;
		PageDTO dto = new PageDTO();		
		dto.setList(list);
		dto.setCount(count);
		dto.setStartNum(startNum);
		dto.setCurrentPage(currentPage);
		dto.setPageCount(pageCount);			
		return new JsonData(dto);
	}
	
	
	@RequestMapping(value = "/queryNoLineList")
	@ResponseBody
	public JsonObject queryNoLineList(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") Integer pageCount) throws Exception {
		JPage page = new JPage(startNum,pageCount);
		List<Bus> list = this.busService.queryNoLineList(page);		
		int count = this.busService.noLineCount();
		int currentPage = startNum/pageCount + 1;
		PageDTO dto = new PageDTO();		
		dto.setList(list);
		dto.setCount(count);
		dto.setStartNum(startNum);
		dto.setCurrentPage(currentPage);
		dto.setPageCount(pageCount);			
		return new JsonData(dto);
	}
	
	
	
	
	@RequestMapping(value = "/getById")
	@ResponseBody
	public JsonObject getById(@Validated Bus bus,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return new JsonData(this.busService.getById(bus));
	}
	
	@RequestMapping(value = "/countByLineId")
	@ResponseBody
	public JsonObject countByLineId(@Validated Bus bus,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return new JsonData(this.busService.countByLineId(bus));
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JsonObject delete(@Validated Bus bus,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		this.busService.delete(bus);
		
		return new JsonSuccess();
	}
	
	
	@RequestMapping(value = "/bindDriver")
	@ResponseBody
	public JsonObject bindDriver(int id,int driverId) throws Exception {
		
		Bus bus = new Bus();
		Driver driver = new Driver();
		bus.setId(id);
		driver.setId(driverId);
		this.busService.bindDriver(bus,driver);
		
		return new JsonSuccess();
	}
	
	@RequestMapping(value = "/unBindDriver")
	@ResponseBody
	public JsonObject unBindDriver(int id,int driverId) throws Exception {
		
		Bus bus = new Bus();
		Driver driver = new Driver();
		bus.setId(id);
		driver.setId(driverId);
		this.busService.unBindDriver(bus,driver);
		
		return new JsonSuccess();
	}
	
	@RequestMapping(value = "/bindLine")
	@ResponseBody
	public JsonObject bindLine(int id,int lineId) throws Exception {
		
		Bus bus = new Bus();
		Line line = new Line();
		bus.setId(id);
		line.setId(lineId);
		this.busService.bindLine(bus,line);
		
		return new JsonSuccess();
	}
	
	@RequestMapping(value = "/unBindLine")
	@ResponseBody
	public JsonObject unBindLine(int id) throws Exception {
		
		Bus bus = new Bus();
		bus.setId(id);
		this.busService.unBindLine(bus);
		
		return new JsonSuccess();
	}
	
	@RequestMapping(value = "/removeDriver")
	@ResponseBody
	public JsonObject removeDriver(int driverId) throws Exception {
		
		this.busService.removeDriver(driverId);
		
		return new JsonSuccess();
	}
	
	@RequestMapping(value = "/removeLine")
	@ResponseBody
	public JsonObject removeLine(int lineId) throws Exception {
		
		this.busService.removeLine(lineId);
		
		return new JsonSuccess();
	}
	
}