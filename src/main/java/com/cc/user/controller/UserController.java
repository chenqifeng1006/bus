package com.cc.user.controller;

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
import com.cc.record.dto.Record;
import com.cc.user.dto.User;
import com.cc.user.service.UserService;
import com.utils.common.JPage;
import com.utils.common.PageDTO;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;
import com.utils.token.CookieHandler;



@Controller
@RequestMapping("user")
public class UserController extends BaseController {
	
	@Autowired
	private CookieHandler cookieHandler;
	@Autowired
	private UserService userService;
	

	@RequestMapping(value = "/login")
	@ResponseBody
	public JsonObject login(@Validated User user,HttpServletRequest request,HttpServletResponse response) throws Exception {

		String loginId = user.getLoginId();
		
		User item = this.userService.getByLoginId(loginId);
		
		if(item == null){
			throw new Exception("用户不存在");
		}else if(!item.getPassword().equals(user.getPassword())){
			throw new Exception("密码不正确");
		}
		cookieHandler.addCookies(response, "user_name", item.getUsername(), 7);
		return new JsonData(item);
	}
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public JsonObject add(@Validated User user,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		int id = this.userService.add(user);
		
		return new JsonData(id);
	}
	
	
	
	@RequestMapping(value = "/updateInfo")
	@ResponseBody
	public JsonObject updateInfo(@Validated User user,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		
		this.userService.updateInfo(user);
		
		return new JsonData(user);
	}
	
	@RequestMapping(value = "/updatePassword")
	@ResponseBody
	public JsonObject updatePassword(@Validated User user,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		this.userService.updatePassword(user);
		
		return new JsonData(user);
	}
	
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public JsonObject queryList(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") Integer pageCount) throws Exception {
		JPage page = new JPage(startNum,pageCount);
		List<User> list = this.userService.queryList(page);		
		int count = this.userService.count();
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
	public JsonObject getById(@Validated User user,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return new JsonData(this.userService.getById(user));
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JsonObject delete(@Validated User user,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		this.userService.delete(user);
		
		return new JsonSuccess();
	}
	
	
	
}