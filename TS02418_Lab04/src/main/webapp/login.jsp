<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/login.css">

<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<nav>
		<jsp:include page="menu.jsp"></jsp:include>
	</nav>
	<div class="form_login">

		<form action="Bai01" method="post">
			<p>Nhập username:</p>
			<input type="text" name="username">
			<p>Nhập password:</p>
			<input type="password" name="password">
			<button>Login</button>
		</form>
	</div>
	${message}
</body>
</html>