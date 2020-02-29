package com.dooly.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dooly.bbs.domain.BBsVO;
import com.dooly.bbs.service.BBsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BBsController {

	@Autowired
	private BBsService bbsService;
	
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		List<BBsVO> bList = bbsService.selectAll();
		model.addAttribute("BBS_LIST", bList);
		return "bbs_list";
	}
	
	@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String insert() {
		return "bbs_write";
	}

	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String insert(BBsVO bbsVO) {
		
		bbsService.insert(bbsVO);
		return "redirect:/list";
	}
}
