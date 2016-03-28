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

import com.cc.admin.dto.Admin;
import com.cc.base.BaseController;
import com.cc.bus.dto.Bus;
import com.cc.bus.service.BusService;
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
	
	@RequestMapping(value = "/getById")
	@ResponseBody
	public JsonObject getById(@Validated Bus bus,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return new JsonData(this.busService.getById(bus));
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JsonObject delete(@Validated Bus bus,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		this.busService.delete(bus);
		
		return new JsonSuccess();
	}
	
}