package com.jjh.article_jjh;

public class Article {
	String articleId; // 게시글 번호
	String title; // 제목
	String content; // 내용
	String userId; // 학번
	String name; // 이름
	String cdate; // 현재시간
	String udate; // 수정한 시간
	
	public Article() {
	}
	
	public Article(String title, String content, String userId, String name) {
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.name = name;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getUdate() {
		return udate;
	}

	public void setUdate(String udate) {
		this.udate = udate;
	}
	
	public String getContentHtml() {
		if (content != null)
			return content.replace("\n", "<br/>");
		return null;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", title=" + title + ", content=" + content + ", userId=" + userId
				+ ", name=" + name + ", cdate=" + cdate + ", udate=" + udate + ", getArticleId()=" + getArticleId()
				+ ", getTitle()=" + getTitle() + ", getContent()=" + getContent() + ", getUserId()=" + getUserId()
				+ ", getName()=" + getName() + ", getCdate()=" + getCdate() + ", getUdate()=" + getUdate()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}