<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Detail</title>
</head>

<body>
   <jsp:include page="index.jsp"></jsp:include>
<div>
    <div class="body">
        <c:forEach var="item" items="${selectedItems}">
            <div class="card" style="display: flex; align-items: center;">
                <img class="card-img-top" src="/TS02418_Lab03/image/${item.image}" alt="Card image cap" width="500px" height="500px">
                <div class="card-content">
                    <div class="card-body text-center">
                        <h5 class="card-title ">${item.name}</h5>
                    </div>
                    <div class="card-body">
                        <strike>${item.price}</strike> ${item.price * (1 - item.discount)}
                    </div>
                    <div class="card-action">
                        <a href="http://localhost:8080/TS02418_Lab03/Bai04">Trở về</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>