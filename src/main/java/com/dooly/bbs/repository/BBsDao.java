package com.dooly.bbs.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.dooly.bbs.domain.BBsVO;

public interface BBsDao {
	
	@Select("SELECT * FROM tbl_bbs")
	public List<BBsVO> selectAll();
	
	@Select("SELECT * FROM tbl_bbs WHERE b_id = #{b_id}")
	public BBsVO findById(long b_id);
	
	public List<BBsVO> findBySubject(String b_Subject);
	public List<BBsVO> findByWriter(String b_writer);
	
	public int insert(BBsVO bbsVO);
	
	public int update(BBsVO bbsVO);

	@Delete("DELETE tbl_bbs WHERE b_id = #{b_id}")
	public int delete(long b_id);
}
