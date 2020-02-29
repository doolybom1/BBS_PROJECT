package com.dooly.bbs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BBsVO {

	private long b_id;
	private long b_p_id;
	private String b_date_time;
	private String b_writer;
	private String b_subject;
	private String b_content;
	private String b_file;
}
