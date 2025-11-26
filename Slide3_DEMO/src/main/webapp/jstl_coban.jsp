


<%@page import="jakarta.servlet.descriptor.TaglibDescriptor"%>
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
<body style="text-align: center;">
	<h1>Tag c:set</h1>
	<c:set var="ducanh" value="67">
	</c:set>
	${ducanh}
	<hr>
	<h1>Tag fmt:formatNumber</h1>
	<fmt:formatNumber value="${ntrang}" pattern="#,###,###"></fmt:formatNumber>
	${ntrang}
	<hr>
	<h1>Tag c:if</h1>

	<c:set var="tuoiteo" value="${Teo}"></c:set>
	<p>Tuổi của Tèo là: ${Teo}</p>
	<c:if test="${Teo >=100}">Tèo già chát</c:if>
	<c:if test="${Teo <100}">Tèo trẻ măng</c:if>

	<c:set var="tuoity" value="${Ty}"></c:set>
	<p>Tuổi của Tý là: ${Ty}</p>
	<c:if test="${Ty >=100}">Tý già chát</c:if>
	<c:if test="${Ty <100}">Tý trẻ măng</c:if>
	<hr>
	<h1>Tag c:choose-when</h1>

	<c:choose>
		<c:when test="${Ty >=100}">Tý già chát</c:when>
		<c:when test="${Ty >40}">Tý đã trưởng thành</c:when>
		<c:otherwise>Tý còn trẻ măng</c:otherwise>
	</c:choose>
	<hr>
	<h1>Tag c:foreach</h1>
	<table>
		<thead>
			<tr>
				<th>Số thứ tự</th>
				<th>tên</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bienten" items="${tenteo}" varStatus="stt">
				<tr>
					<td>${stt.index+1}</td>
					<td>${bienten}</td>
				</tr>
			</c:forEach>
		</tbody> 
	</table>
	
	<hr>
	<h1>Foreach lọc danh sách hình ảnh</h1>
	 <c:forEach var="ds" items="${dsao}">
	 <p><img alt="${ds.name}" src="${pageContext.request.contextPath}/image/${ds.image}" width="100px" height="auto"></p>
	 <p>${ds.name}</p>
	 <p>${ds.price}</p>
	 </c:forEach>

</body>
</html>