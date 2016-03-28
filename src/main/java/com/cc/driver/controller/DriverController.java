package com.cc.driver.controller;

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
import com.cc.driver.dto.Driver;
import com.cc.driver.service.DriverService;
import com.utils.common.JPage;
import com.utils.common.PageDTO;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;
import com.utils.token.CookieHandler;



@Controller
@RequestMapping("driver")
public class DriverController extends BaseController {
	
	@Autowired
	private CookieHandler cookieHandler;
	@Autowired
	private DriverService driverService;
	

	@RequestMapping(value = "/login")
	@ResponseBody
	public JsonObject login(@Validated Driver driver,HttpServletRequest request,HttpServletResponse response) throws Exception {

		String loginId = driver.getLoginId();
		
		Driver item = this.driverService.getByLoginId(loginId);
		
		if(item == null){
			throw new Exception("用户不存在");
		}else if(!item.getPassword().equals(driver.getPassword())){
			throw new Exception("密码不正确");
		}
		
		return new JsonData(item);
	}
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public JsonObject add(@Validated Driver driver,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		int id = this.driverService.add(driver);
		
		return new JsonData(id);
	}
	
	
	
	@RequestMapping(value = "/updateInfo")
	@ResponseBody
	public JsonObject updateInfo(@Validated Driver driver,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		
		this.driverService.updateInfo(driver);
		
		return new JsonData(driver);
	}
	
	@RequestMapping(value = "/updatePassword")
	@ResponseBody
	public JsonObject updatePassword(@Validated Driver driver,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		this.driverService.updatePassword(driver);
		
		return new JsonData(driver);
	}
	
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public JsonObject queryList(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") Integer pageCount) throws Exception {
		JPage page = new JPage(startNum,pageCount);
		List<Driver> list = this.driverService.queryList(page);		
		int count = this.driverService.count();
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
	public JsonObject getById(@Validated Driver driver,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return new JsonData(this.driverService.getById(driver));
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JsonObject delete(@Validated Driver driver,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		this.driverService.delete(driver);
		
		return new JsonSuccess();
	}
	
}