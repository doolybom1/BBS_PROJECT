package com.dooly.bbs.service;

import java.util.List;

import com.dooly.bbs.domain.BBsVO;

public interface BBsService {

	public List<BBsVO> selectAll();
	public BBsVO findById(long b_id);
	
	public List<BBsVO> findBySubject(String b_Subject);
	public List<BBsVO> findByWriter(String b_writer);
	
	// insert, update mapper.xml 파일을 만들어서 구성 
	public int insert(BBsVO bbsVO);
	public int update(BBsVO bbsVO);

	public int delete(long b_id);
	
}

