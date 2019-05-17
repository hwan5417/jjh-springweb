<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글쓰기완료</title>
</head>
<body>
	<p>
	게시글 번호 : ${article.articleId }.
	</p>
	<p>
	제목 : ${article.title }.
	</p>
	<p>
	내용 : ${article.content }.
	</p>
	<p>
	학번 : ${article.userId }.
	</p>
	<p>
	이름 : ${article.name }.
	</p>
	<p>
	현재시간 : ${article.cdate }.
	</p>
	<p>
	수정한시간 : ${article.udate }.
	</p>
	<hr />
	<p>${article.contentHtml }</p>
	<hr />
</body>
</html>