<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/result_sign_up.css">

<meta charset="UTF-8">
<title>Bài 3</title>
</head>
<body>

	<nav>
		<jsp:include page="menu.jsp"></jsp:include>
	</nav>

	<p>Username: ${username}</p>
	<br>
	<p>Password: ${password}</p>
	<br>
	<p>
		Giới tính:
		<c:choose>
			<c:when test="${gender=='True'}">Nam</c:when>
			<c:otherwise>Nữ</c:otherwise>
		</c:choose>
	</p>
	<br>
	<p>Đã có gia đình: ${married}</p>
	<br>
	<p>Country: ${country}</p>
	<br>
	<p>
		Sở thích:
		<c:if test="${not empty hobbies}">
			<ul>
				<c:forEach var="hobby" items="${hobbies}">
					<li>${hobby}</li>
				</c:forEach>
			</ul>
		</c:if>
		<c:if test="${empty hobbies}"> Khong co so thich duoc chon </c:if>
	</p>
	<br>
	<p>Ghi chú: ${note}</p>

	<br>
	<p>Ảnh đại diện:</p>
	<img src="${photoURL}">
</body>
</html>
