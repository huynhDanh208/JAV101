<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả đăng ký</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/result_sign_up.css">
</head>

<body>

    <nav>
        <jsp:include page="menu.jsp"></jsp:include>
    </nav>

    <div class="result-container">
        <div class="result-card">

            <h2>Kết quả đăng ký</h2>

            <div class="row">
                <span class="label">Họ và tên:</span>
                <span class="value">${bean.fullname}</span>
            </div>

            <div class="row">
                <span class="label">Giới tính:</span>
                <span class="value">
                    ${bean.gender == 'Male' ? 'Nam' : bean.gender == 'Female' ? 'Nữ' : 'Khác'}
                </span>
            </div>

            <div class="row">
                <span class="label">Tình trạng hôn nhân:</span>
                <span class="value">${bean.married}</span>
            </div>

            <div class="row">
                <span class="label">Quốc gia:</span>
                <span class="value">${bean.country}</span>
            </div>

            <div class="row">
                <span class="label">Sở thích:</span>
                <span class="value">
                    <c:if test="${not empty bean.hobbies}">
                        <ul>
                            <c:forEach var="h" items="${bean.hobbies}">
                                <li>${h}</li>
                            </c:forEach>
                        </ul>
                    </c:if>
                    <c:if test="${empty bean.hobbies}">
                        Không có sở thích nào
                    </c:if>
                </span>
            </div>

            <div class="row">
                <span class="label">Ghi chú:</span>
                <span class="value">${bean.note}</span>
            </div>

            <div class="avatar-box">
                <p>Ảnh đại diện:</p>
                <img src="${pageContext.request.contextPath}/files/${bean.avatar}" alt="Avatar">
            </div>

        </div>
    </div>

</body>
</html>
