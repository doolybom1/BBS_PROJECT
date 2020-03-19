package com.dooly.bbs.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dooly.bbs.domain.CommentVO;
import com.dooly.bbs.repository.CommentDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentServiceImp implements CommentService{

	private final CommentDao cmDao;
	
//	@Autowired
//	public CommentServiceImp(CommentDao cmDao) {
//		this.cmDao = cmDao;
//	}

	@Override
	public List<CommentVO> selectAll() {
		
		return cmDao.selectAll();
	}

	@Override
	public CommentVO findById(long c_id) {
		
		return cmDao.findById(c_id);
	}

	@Override
	public List<CommentVO> findByBId(long c_b_id) {
		return cmDao.findByBIdLevel(c_b_id);
	}

	@Override
	public List<CommentVO> findByPId(long c_p_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(CommentVO commentVO) {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		commentVO.setC_date_time(ldt.format(df));
		
		
		return cmDao.insert(commentVO);
	}

	@Override
	public int update(CommentVO commentVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long c_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
