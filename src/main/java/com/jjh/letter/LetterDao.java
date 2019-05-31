package com.jjh.letter;

import java.util.List;

public class LetterDao {
	//받은목록
	List<Letter> receiveAll(int offset, int count);
	//보낸목록
	List<Letter> sendAll(int offset, int count);
	//편지조회
	Letter getLetter(String letterId);
	//편지저장
	int saveLetter(String letterId);
	//편지삭제
	int deleteLetter(String senderId, String receiverId);
}
