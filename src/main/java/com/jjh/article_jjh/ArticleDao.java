package com.jjh.article_jjh;

import java.util.List;

public interface ArticleDao {
	//게시글 목록
	List<Article> selectAll(int offset, int count);
	//게시글 쓰기
	void write(Article article);
	//게시글 조회
	Article search(String articleId);
	//게시글 갯수 확인
	int countAll();
	//게시글 수정
	int updateArticle(Article article);
	//게시글 삭제
	int deleteArticle(String articleId);
	
}

