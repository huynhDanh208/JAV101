<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>đây là trang sp</title>
<link rel="stylesheet" href="sanpham.css">
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	
	<div class="anhSP">
		<jsp:include page="item.jsp">
			<jsp:param value="Barcalona_Away.jpg" name="img" />
			<jsp:param value="Áo sân khách Barcalona" name="name" />
		</jsp:include>
	</div>
	<div class="anhSP">
		<jsp:include page="item.jsp">
			<jsp:param value="Barcalona_Home.jpg" name="img" />
			<jsp:param value="Áo sân nhà Barcalona" name="name" />
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
			<jsp:param value="Manchester_City_Home.jpg" name="img" />
			<jsp:param value="Áo sân nhà Manchester City" name="name" />
		</jsp:include>
	</div>
	<div class="anhSP">
		<jsp:include page="item.jsp">
			<jsp:param value="Manchester_United_Away.jpg" name="img" />
			<jsp:param value="Áo sân khách Manchester United" name="name" />
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