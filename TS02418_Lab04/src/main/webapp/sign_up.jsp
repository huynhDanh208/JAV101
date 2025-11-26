<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>Bài 3</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/sign_up.css">

</head>
<body>

    <nav>
        <jsp:include page="menu.jsp"></jsp:include>
    </nav>

    <div class="signup-container">
        <h2>Đăng ký tài khoản</h2>

        <form action="Bai03" method="post" enctype="multipart/form-data">

            <div class="form-group">
                <label>Username</label>
                <input name="usernameip" type="text" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input name="passwordip" type="password" required>
            </div>

            <div class="form-group">
                <label>Ảnh đại diện</label>
                <input name="avatarip" type="file">
            </div>

            <div class="form-group">
                <label>Giới tính</label>
                <div class="inline">
                    <label><input type="radio" name="genderip" value="True"> Nam</label>
                    <label><input type="radio" name="genderip" value="False"> Nữ</label>
                </div>
            </div>

            <div class="form-group checkbox">
                <label><input name="marriedip" type="checkbox"> Đã có gia đình?</label>
            </div>

            <div class="form-group">
                <label>Quốc gia</label>
                <select name="countryip">
                    <option disabled selected>Chọn quốc gia</option>
                    <option value="Vietnamese">Việt Nam</option>
                    <option value="Spain">Tây Ban Nha</option>
                    <option value="USA">Hoa Kỳ</option>
                    <option value="Germany">Đức</option>
                </select>
            </div>

            <div class="form-group">
                <label>Sở thích</label>
                <div class="inline checkbox-group">
                    <label><input name="hobbiesip" type="checkbox" value="Coding"> Lập trình</label>
                    <label><input name="hobbiesip" type="checkbox" value="Travel"> Du lịch</label>
                    <label><input name="hobbiesip" type="checkbox" value="Game"> Chơi game</label>
                    <label><input name="hobbiesip" type="checkbox" value="Sport"> Thể thao</label>
                </div>
            </div>

            <div class="form-group">
                <label>Ghi chú</label>
                <textarea name="noteip"></textarea>
            </div>

            <button class="submit-btn" type="submit">Đăng ký</button>

        </form>
    </div>

</body>
</html>
