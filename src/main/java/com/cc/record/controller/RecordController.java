package com.cc.record.controller;

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
import com.cc.record.dto.Record;
import com.cc.record.service.RecordService;
import com.utils.common.JPage;
import com.utils.common.PageDTO;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;
import com.utils.token.CookieHandler;



@Controller
@RequestMapping("record")
public class RecordController extends BaseController {
	
	@Autowired
	private CookieHandler cookieHandler;
	@Autowired
	private RecordService recordService;
	

	
	@RequestMapping(value = "/add")
	@ResponseBody
	public JsonObject add(@Validated Record record,HttpServletRequest request,HttpServletResponse response) throws Exception {
		record.setTime(new Date());
		int id = this.recordService.add(record);
		
		return new JsonData(id);
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public JsonObject update(@Validated Record record,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		
		this.recordService.update(record);
		
		return new JsonData(record);
	}
	

	
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public JsonObject queryList(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") Integer pageCount,String filter) throws Exception {
		JPage page = new JPage(startNum,pageCount);
		if(filter != null){
			page.setFilter(filter);
		}
		List<Record> list = this.recordService.queryList(page);		
		int count;
		if(filter != null){
			count = this.recordService.countByBusId(filter);
		}else{
			count = this.recordService.count();
		}
		
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
	public JsonObject getById(@Validated Record record,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return new JsonData(this.recordService.getById(record));
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JsonObject delete(@Validated Record record,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		this.recordService.delete(record);
		
		return new JsonSuccess();
	}
	
	
	
}