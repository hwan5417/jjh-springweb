<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시글 목록</title>
</head>
<body>
	<p>전체 ${totalCount }건</p>
	<form action="./app/articles">
		<input type="number" name="page" value="${param.page }" placeholder="페이지"
			min="1" max="${totalCount / 100 + 1 }" step="1" style="width: 50px;">
		<button type="submit">조회</button>
	</form>
	<table>
		<thead>
			<tr>
				<td>게시글 아이디</td>
				<td>제목</td>
				<td>내용</td>
				<td>학번</td>
				<td>이름</td>
				<td>현재시간</td>
				<td>수정한시간</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${articles}">
				<tr>
					<td><a href="./app/article/step3?articleId=${article.articleId }">${article.articleId }</a></td>
					<td>${article.title }</td>
					<td>${article.content }</td>
					<td>${article.userId }</td>
					<td>${article.name }</td>
					<td>${article.cdate }</td>
					<td>${article.udate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</head>
</html>