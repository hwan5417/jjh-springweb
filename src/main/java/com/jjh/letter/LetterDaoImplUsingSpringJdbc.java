package com.jjh.letter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("letterDao")
public class LetterDaoImplUsingSpringJdbc implements LetterDao {
	static final String RECEIVE_ALL = "";
	static final String SEND_ALL = "";
	static final String GET_LETTER = "";
	static final String SAVE_LETTER = "";
	static final String DELETE_LETTER = "";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	final RowMapper<Letter> memberRowMapper = new BeanPropertyRowMapper<>(
			Letter.class);
	
	//받은 목록
	public List<Letter> receiveAll(int offset, int count) {
		jdbcTemplate.query(RECEIVE_ALL, memberRowMapper, offset, count);
	}
	//보낸 목록
	public List<Letter> sendAll(int offset, int count) {
		jdbcTemplate.query(SEND_ALL, memberRowMapper, offset, count);
	}
	//편지 조회
	public Letter getLetter(String letterId) {
		return jdbcTemplate.queryForObject(GET_LETTER,
				new BeanPropertyRowMapper<>(Letter.class), letterId);
	}
	//편지 저장
	public int saveLetter(String letterId) {
		
	}
	//편지 삭제
	public int deleteLetter(String senderId, String receiverId) {
		return jdbcTemplate.update(DELETE_LETTER, senderId, receiverId);
	}
}
