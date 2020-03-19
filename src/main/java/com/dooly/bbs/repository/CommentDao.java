package com.dooly.bbs.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.dooly.bbs.domain.CommentVO;

public interface CommentDao {
	
	@Select("SELECT * FROM tbl_comment")
	public List<CommentVO> selectAll();
	public CommentVO findById(long c_id);
	
	public List<CommentVO> findByBIdLevel(long c_b_id);
	
	@Select("SELECT * FROM tbl_comment"
			+ " WHERE c_b_id = #{c_b_id} AND c_p_id = 0 ORDER BY c_date_time DESC")
	public List<CommentVO> findByBId(long c_b_id);
	
	@Select("SELECT * FROM tbl_comment" 
			+ " WHERE c_b_id = #{c_b_id} ORDER BY c_date_time DESC")
	public List<CommentVO> findByPId(long c_p_id);
	
	public int insert(CommentVO commentVO);
	public int update(CommentVO commentVO);
	
	@Select("SELECT * FROM tbl_comment c_id = #{c_id}")
	public int delete(long c_id);
}
