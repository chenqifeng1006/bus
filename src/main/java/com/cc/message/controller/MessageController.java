package com.cc.message.controller;

import java.util.Date;
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
import com.cc.line.dto.Line;
import com.cc.message.dto.Message;
import com.cc.message.service.MessageService;
import com.utils.common.JPage;
import com.utils.common.PageDTO;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;
import com.utils.token.CookieHandler;



@Controller
@RequestMapping("message")
public class MessageController extends BaseController {
	
	@Autowired
	private CookieHandler cookieHandler;
	@Autowired
	private MessageService messageService;
	
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public JsonObject add(@Validated Message message,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		message.setTime(new Date());
		int id = this.messageService.add(message);
		
		return new JsonData(id);
	}
	

	
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public JsonObject queryList(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") Integer pageCount,
			String filter) throws Exception {
		JPage page = new JPage(startNum,pageCount);
		if(filter != null){
			page.setFilter(filter);
		}
		List<Message> list = this.messageService.queryList(page);		
		int count = this.messageService.count();
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
	public JsonObject getById(@Validated Message message,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return new JsonData(this.messageService.getById(message));
	}
	
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JsonObject delete(@Validated Message message,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		this.messageService.delete(message);
		
		return new JsonSuccess();
	}
	
	
}