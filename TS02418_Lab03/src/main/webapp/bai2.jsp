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
	<table>
		<thead>
			<tr>
				<th>No.</th>
				<th>Id</th>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ct" items="${countries}" varStatus="vs">
				<tr>
					<td>${vs.count}</td>
					<td>${ct.id}</td>
					<td>${ct.name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>