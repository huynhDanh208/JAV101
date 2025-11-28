<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký tài khoản</title>

    <!-- giữ nguyên đường dẫn CSS của bạn -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sign_up.css">
</head>
<body>

    <nav>
        <jsp:include page="menu.jsp"></jsp:include>
    </nav>

    <div class="signup-container">
        <h2>Đăng ký tài khoản</h2>

        <!-- enctype giữ multipart để upload avatar -->
        <form action="Bai02" method="post" enctype="multipart/form-data">

            <!-- Fullname -->
            <div class="form-group">
                <label for="fullname">Họ và tên</label>
                <input id="fullname" name="fullname" type="text">
            </div>

            <!-- Gender -->
            <div class="form-group">
                <label>Giới tính</label>
                <div class="inline">
                    <label><input type="radio" name="gender" value="Male"> Nam</label>
                    <label><input type="radio" name="gender" value="Female"> Nữ</label>
                    <label><input type="radio" name="gender" value="Other"> Khác</label>
                </div>
            </div>

            <!-- Married: dùng hidden để luôn gửi giá trị mặc định 'false' nếu checkbox không được check -->
            <div class="form-group checkbox">
                <input type="hidden" name="married" value="false">
                <label><input id="married" name="married" type="checkbox" value="true"> Đã có gia đình?</label>
            </div>

            <!-- Birthday -->
            <div class="form-group">
                <label for="birthday">Ngày sinh</label>
                <input id="birthday" name="birthday" type="date" required>
            </div>

            <!-- Country -->
            <div class="form-group">
                <label for="country">Quốc gia</label>
                <select id="country" name="country" required>
                    <option disabled selected value="">Chọn quốc gia</option>
                    <option value="Vietnamese">Việt Nam</option>
                    <option value="Spain">Tây Ban Nha</option>
                    <option value="USA">Hoa Kỳ</option>
                    <option value="Germany">Đức</option>
                </select>
            </div>

            <!-- Hobbies (multiple) -->
            <div class="form-group">
                <label>Sở thích</label>
                <div class="inline checkbox-group">
                    <!-- name="hobbies" -> request.getParameterValues("hobbies") sẽ nhận được mảng -->
                    <label><input name="hobbies" type="checkbox" value="Coding"> Lập trình</label>
                    <label><input name="hobbies" type="checkbox" value="Travel"> Du lịch</label>
                    <label><input name="hobbies" type="checkbox" value="Game"> Chơi game</label>
                    <label><input name="hobbies" type="checkbox" value="Sport"> Thể thao</label>
                </div>
            </div>

            <!-- Avatar -->
            <div class="form-group">
                <label for="avatar">Ảnh đại diện</label>
                <input id="avatar" name="avatar" type="file" accept="image/*">
            </div>

            <!-- Note -->
            <div class="form-group">
                <label for="note">Ghi chú</label>
                <textarea id="note" name="note" rows="4" placeholder="Ghi chú thêm..."></textarea>
            </div>

            <button class="submit-btn" type="submit">Đăng ký</button>
        </form>
    </div>

</body>
</html>
