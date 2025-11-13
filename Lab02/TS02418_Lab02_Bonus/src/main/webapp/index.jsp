<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
<nav>
	<jsp:include page="menu.jsp"></jsp:include>
</nav>

 <h2>Trang mua sắm áo bóng đá</h2>
 <p>Sản phẩm ví dụ</p>
<div class="anhSP">
		<jsp:include page="item.jsp">
			<jsp:param value="Barcalona_Away.jpg" name="img" />
			<jsp:param value="Áo sân khách Barcalona" name="name" />
		</jsp:include>
	</div>
	<div class="anhSP">
		<jsp:include page="item.jsp">
			<jsp:param value="Manchester_City_Away.jpg" name="img" />
			<jsp:param value="Áo sân khách Manchester City" name="name" />
		</jsp:include>
	</div>
	
	<div class="anhSP">
		<jsp:include page="item.jsp">
			<jsp:param value="Manchester_United_Home.jpg" name="img" />
			<jsp:param value="Áo sân nhà Manchester United" name="name" />
		</jsp:include>
	</div>
	
</body>
</html>