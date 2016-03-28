package com.cc.admin.controller;

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
import com.cc.admin.service.AdminService;
import com.cc.base.BaseController;
import com.utils.common.JPage;
import com.utils.common.PageDTO;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;
import com.utils.token.CookieHandler;



@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {
	
	@Autowired
	private CookieHandler cookieHandler;
	@Autowired
	private AdminService adminService;
	

	@RequestMapping(value = "/login")
	@ResponseBody
	public JsonObject login(@Validated Admin admin,HttpServletRequest request,HttpServletResponse response) throws Exception {

		String loginId = admin.getLoginId();
		
		Admin item = this.adminService.getByLoginId(loginId);
		
		if(item == null){
			throw new Exception("用户不存在");
		}else if(!item.getPassword().equals(admin.getPassword())){
			throw new Exception("密码不正确");
		}
		
		return new JsonData(item);
	}
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public JsonObject add(@Validated Admin admin,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		int id = this.adminService.add(admin);
		
		return new JsonData(id);
	}
	
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public JsonObject update(@Validated Admin admin,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		
		this.adminService.update(admin);
		
		return new JsonData(admin);
	}
	
	
	@RequestMapping(value = "/updateInfo")
	@ResponseBody
	public JsonObject updateInfo(@Validated Admin admin,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		
		this.adminService.updateInfo(admin);
		
		return new JsonData(admin);
	}
	
	@RequestMapping(value = "/updatePassword")
	@ResponseBody
	public JsonObject updatePassword(@Validated Admin admin,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		this.adminService.updatePassword(admin);
		
		return new JsonData(admin);
	}
	
	@RequestMapping(value = "/getById")
	@ResponseBody
	public JsonObject getById(@Validated Admin admin,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return new JsonData(this.adminService.getById(admin));
	}
	
	
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public JsonObject queryList(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") Integer pageCount) throws Exception {
		JPage page = new JPage(startNum,pageCount);
		List<Admin> list = this.adminService.queryList(page);		
		int count = this.adminService.count();
		int currentPage = startNum/pageCount + 1;
		PageDTO dto = new PageDTO();		
		dto.setList(list);
		dto.setCount(count);
		dto.setStartNum(startNum);
		dto.setCurrentPage(currentPage);
		dto.setPageCount(pageCount);			
		return new JsonData(dto);
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JsonObject delete(@Validated Admin admin,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		this.adminService.delete(admin);
		
		return new JsonSuccess();
	}
	
	
}