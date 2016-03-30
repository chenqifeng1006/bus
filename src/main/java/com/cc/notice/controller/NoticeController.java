package com.cc.notice.controller;

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
import com.cc.notice.dto.Notice;
import com.cc.notice.service.NoticeService;
import com.utils.common.JPage;
import com.utils.common.PageDTO;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;
import com.utils.token.CookieHandler;



@Controller
@RequestMapping("notice")
public class NoticeController extends BaseController {
	
	@Autowired
	private CookieHandler cookieHandler;
	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public JsonObject add(@Validated Notice notice,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		notice.setTime(new Date());
		int id = this.noticeService.add(notice);
		
		return new JsonData(id);
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public JsonObject update(@Validated Notice notice,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		int id = this.noticeService.update(notice);
		
		return new JsonData(id);
	}
	

	
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public JsonObject queryList(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") Integer pageCount) throws Exception {
		JPage page = new JPage(startNum,pageCount);
		List<Notice> list = this.noticeService.queryList(page);		
		int count = this.noticeService.count();
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
	public JsonObject getById(@Validated Notice notice,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return new JsonData(this.noticeService.getById(notice));
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JsonObject delete(@Validated Notice notice,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		this.noticeService.delete(notice);
		
		return new JsonSuccess();
	}
	
	
}