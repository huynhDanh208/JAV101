<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/calculator.css">

<meta charset="UTF-8">
<title>Bài 2</title>
</head>
<body>
	<nav>
		<jsp:include page="menu.jsp"></jsp:include>
	</nav>

	<form action="${pageContext.request.contextPath}/calculator"
		method="post" id="calcForm">
		<input name="soA" type="number" step="any" required><br>
		<input name="soB" type="number" step="any" required><br>

		<!-- sử dụng contextPath để không phụ thuộc tên project -->
		<button type="submit"
			formaction="${pageContext.request.contextPath}/calculator/pls">+</button>
		<button type="submit"
			formaction="${pageContext.request.contextPath}/calculator/sub">-</button>
		<button type="submit"
			formaction="${pageContext.request.contextPath}/calculator/mul">x</button>
		<button type="submit"
			formaction="${pageContext.request.contextPath}/calculator/div">:</button>
	</form>

	<c:if test="${not empty result}">
		<h3>${result}</h3>
	</c:if>
	<c:if test="${not empty error}">
		<p style="color: red">${error}</p>
	</c:if>
</body>
</html>
