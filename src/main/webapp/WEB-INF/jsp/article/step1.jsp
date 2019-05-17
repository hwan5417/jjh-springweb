<!doctype html>
<!-- 
p.277 [리스트 11.9] 회원가입 화면
 -->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글작성</title>
</head>
<body>
	<h2>글입력</h2>
	<form action="./app/article/step2" method="post">
		<p>
			제목:<br> <input type="title" name="title" value="${param.title }">
		</p>
		<p>
			내용:<textarea name="content" style="width: 100%; height: 200px;" required></textarea>
		</p>
		<button type="submit">글쓰기 완료</button>
	</form>
</body>
</html>