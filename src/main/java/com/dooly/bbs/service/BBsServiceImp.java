package com.dooly.bbs.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.dooly.bbs.domain.BBsVO;
import com.dooly.bbs.repository.BBsDao;

@Service
public class BBsServiceImp implements BBsService {

	BBsDao bbsDao;
	
	@Autowired	
	public BBsServiceImp(BBsDao bbsDao) {
		this.bbsDao = bbsDao;
	}

	@Override
	public List<BBsVO> selectAll() {
		
		return bbsDao.selectAll();
	}

	@Override
	public BBsVO findById(long b_id) {
		return bbsDao.findById(b_id);
	}

	@Override
	public List<BBsVO> findBySubject(String b_Subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BBsVO> findByWriter(String b_writer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BBsVO bbsVO) {
		
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		bbsVO.setB_date_time(ldt.format(dt).toString());
		
		return bbsDao.insert(bbsVO);
	}

	@Override
	public int update(BBsVO bbsVO) {

		return bbsDao.update(bbsVO);
	}

	@Override
	public int delete(long b_id) {
		
		return bbsDao.delete(b_id);
	}

}
