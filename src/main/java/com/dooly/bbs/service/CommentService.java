package com.dooly.bbs.service;

import java.util.List;

import com.dooly.bbs.domain.CommentVO;

public interface CommentService {
	public List<CommentVO> selectAll();
	public CommentVO findById(long c_id);
	
	public List<CommentVO> findByBId(long c_b_id);
	public List<CommentVO> findByPId(long c_p_id);
	
	public int insert(CommentVO commentVO);
	public int update(CommentVO commentVO);
	
	public int delete(long c_id);
}
