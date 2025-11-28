<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gửi mail</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/send_mail.css">

</head>
<body>

<nav>
    <jsp:include page="menu.jsp"></jsp:include>
</nav>
<br><br>
<form action="Bai03" method="post" enctype="multipart/form-data">


    <p>Gửi tới:</p>
    <input name="to" type="text" required><br><br>

    <p>Tiêu đề:</p>
    <input name="subject" type="text" required><br><br>

    <p>Nội dung:</p>
    <textarea name="body" rows="5" cols="40"></textarea><br><br>

    <p>File đính kèm:</p>
    <input name="file" type="file"><br><br>

    <button type="submit">Gửi email</button>

    <p style="color:green">${message}</p>

</form>

</body>
</html>
