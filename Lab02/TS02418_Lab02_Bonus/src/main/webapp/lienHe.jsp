<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="lienhe.css">
</head>
<body>
	<nav>
		<jsp:include page="menu.jsp"></jsp:include>
	</nav>
	<div class="anhDev">
		<jsp:include page="item.jsp">
			<jsp:param value="Chào sân giải FPT.jpg" name="img" />
			<jsp:param value="Huỳnh Lê Đức Anh" name="name" />
		</jsp:include>
	</div>
	<div class="info">
	<p>SDT: 0928163582</p>
	<p>Mail: anhhldts02418@gmail.com</p>
	<p>Facebook: Huynh Le Duc Anh</p>
	<p>Instagram: huynh_leducanh</p>
	</div>
</body>
</html>