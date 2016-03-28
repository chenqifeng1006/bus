package com.cc.line.controller;

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
import com.cc.line.service.LineService;
import com.utils.common.JPage;
import com.utils.common.PageDTO;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;
import com.utils.token.CookieHandler;



@Controller
@RequestMapping("line")
public class LineController extends BaseController {
	
	@Autowired
	private CookieHandler cookieHandler;
	@Autowired
	private LineService lineService;
	

	
	@RequestMapping(value = "/add")
	@ResponseBody
	public JsonObject add(@Validated Line line,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		int id = this.lineService.add(line);
		
		return new JsonData(id);
	}
	
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public JsonObject update(@Validated Line line,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		
		this.lineService.update(line);
		
		return new JsonData(line);
	}
	
	
	
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public JsonObject queryList(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") Integer pageCount) throws Exception {
		JPage page = new JPage(startNum,pageCount);
		List<Line> list = this.lineService.queryList(page);		
		int count = this.lineService.count();
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
	public JsonObject delete(@Validated Line line,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		this.lineService.delete(line);
		
		return new JsonSuccess();
	}
	
	
}