package com.dooly.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dooly.bbs.domain.CommentVO;
import com.dooly.bbs.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/comment")
@Controller
public class CommentController {

	@Autowired
	CommentService cmService;
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String list(String b_id, Model model) {
		
		long c_b_id = Long.valueOf(b_id);
		List<CommentVO> cmtList = cmService.findByBId(c_b_id);
		model.addAttribute("CMT_LIST", cmtList);
		return "comment_list";
	}

	@RequestMapping(value = "/insert", method=RequestMethod.POST)
	public String insert(CommentVO cmtVO,Model model) {
		
		cmService.insert(cmtVO); 
		model.addAttribute("b_id", cmtVO.getC_b_id());
		
		return "redirect:/comment/list";
	}
}
