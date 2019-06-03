<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시판</title>
<script type="text/javascript">
	function confirmDelete() {
		if (confirm("삭제하시겠습니까?"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h2>상세정보</h2>
	<p>
		<a href="./app/letter/listReceived">받은 목록</a>
		<a href="./app/letter/listSent">보낸 목록</a>
			<a href="./app/letter/delete?letterId=${letter.letterId }"
				onclick="return confirmDelete();">삭제</a>
	</p>
	<hr />
	<p>
		<span>편지 번호 : ${letter.letterId }</span>  
	</p>
	<p>
		<span>내 ID : ${letter.senderId }</span> | <span>내 이름 : ${letter.senderName }</span>
	</p>
	<hr />
	<p>
		<span style="font-weight: bold;">제목 : ${letter.title }</span>
	</p>
	<p>
		<span style="font-weight: bold;">내용 : ${letter.content }</span>
	</p>
	<hr />
	<p>
		<span>상대방 ID : ${letter.receiverId }</span> | <span>상대방 이름 : ${letter.receiverName }</span>
	</p>
	<p>
		<span>보낸 시간 : ${letter.cdate }</span>
	</p>
</body>
</html>