package com.dooly.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import com.dooly.bbs.domain.BBsVO;
import com.dooly.bbs.service.BBsService;
import com.dooly.bbs.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BBsController {

	@Autowired
	private BBsService bbsService;
	
	@Autowired
	private FileService fService;
	
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		List<BBsVO> bList = bbsService.selectAll();
		model.addAttribute("BBS_LIST", bList);
		return "bbs_list";
	}
	
	@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		model.addAttribute("INSERT", "INSERT");
		return "bbs_write";
	}

	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String insert(BBsVO bbsVO) {
		
		bbsService.insert(bbsVO);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/detail",method=RequestMethod.GET)
	public String detail(@RequestParam("b_id") String b_id, Model model) {
		BBsVO bbsVO = bbsService.findById(Long.valueOf(b_id));
		model.addAttribute("BBS", bbsVO);
		return "bbs_view";
	}
	
	
	@RequestMapping(value = "/update",method=RequestMethod.GET)
	public String update(@RequestParam("b_id") String b_id, Model model) {
		BBsVO bbsVO = bbsService.findById(Long.valueOf(b_id));
		model.addAttribute("BBS", bbsVO);
		return "bbs_write";
	}

	@RequestMapping(value = "/update",method=RequestMethod.POST)
	public String update(BBsVO bbsVO) {
		bbsService.update(bbsVO);
		return "redirect:/list";
	}
	
	
	@RequestMapping(value = "/delete",method=RequestMethod.GET)
	public String delete(@RequestParam("b_id") String b_id) {
		bbsService.delete(Long.valueOf(b_id));
		return "redirect:/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/image_up",method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String fileUp(MultipartFile upFile) {
		log.debug("업로드된 파일정보:" + upFile.getOriginalFilename());
		String retFileName = fService.fileUp(upFile);
		if(retFileName == null) {
			return "FAIL";
		}
		return retFileName;
	}
	
}
