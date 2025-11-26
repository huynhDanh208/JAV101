<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<jsp:include page="menu.jsp"></jsp:include>
	</nav>
	<select name="country">
		<c:forEach var="ct" items="${countries}">
		<option value="${ct.id}">${ct.name}</option>
		</c:forEach>
	</select>
</body>
</html>