package com.jjh.article_jjh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("articleDao")
public class ArticleDaoImplUsingSpringJdbc implements ArticleDao {

	static final String INSERT = "INSERT INTO article(title,content,userId,name) VALUES(?,?,?,?)";

	static final String SELECT_ALL = "SELECT * FROM article ORDER BY articleId desc LIMIT ?,?";

	static final String COUNT_ALL = "SELECT count (articleId) count FROM article";
	 
	static final String UPDATE_ARTICLE = "update article set title=?, content=? where (articleId, userId) = (?,?)";

	static final String DELETE_ARTICLE = "delete from article where (articleId, userId) = (?,?)";

	static final String GET_ARTICLE = "SELECT articleId, title, content, userId, name, cdate FROM article WHERE articleId=?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	final RowMapper<Article> memberRowMapper = new BeanPropertyRowMapper<>(
										Article.class);


	@Override // 게시글 쓰기
	public void write(Article article) {
		jdbcTemplate.update(INSERT, article.getTitle(), article.getContent(), article.getUserId(), article.getName());
	}

	@Override // 게시글 목록
	public List<Article> selectAll(int offset, int count) {
		return jdbcTemplate.query(SELECT_ALL, memberRowMapper, offset, count);
	}

	@Override // 게시글 갯수 확인
	public int countAll() {
		return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	}

	// 게시글 수정
	public int updateArticle(Article article) {
		return jdbcTemplate.update(UPDATE_ARTICLE, article.getTitle(),
				article.getContent(), article.getArticleId(),
				article.getUserId());
	}
	//게시글 삭제
	public int deleteArticle(String articleId, String userId) {
		return jdbcTemplate.update(DELETE_ARTICLE, articleId, userId);
	}
	/**
	 * 글 상세
	 */
	@Override
	public Article getArticle(String articleId) {
		return jdbcTemplate.queryForObject(GET_ARTICLE,
				new BeanPropertyRowMapper<>(Article.class), articleId);
	}

}