<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<form action="/TS02418_Lab02/form/update" method="post">

		<div>Fullname</div>
		<input name="fullname" value="${user. fullname}"> <br>

		<div>Gender :</div>
		<input type="radio" name="gender" value="true"
			${user.gender=='true' ? 'checked' : ''}> Nam <br> <input
			type="radio" name="gender" value="false"
			${user.gender=='false' ? 'checked' : ''}> Nữ <br>
		<div>country:</div>
		<select name="country">
			<option value="vn" ${user.country=='vn' ? 'selected': '' }>Việt
				Nam</option>

			<option value="usa" ${user.country=='usa' ? 'selected': ''}>Mỹ</option>

			<option value="cn" ${user.country=='cn' ? 'selected': ''}>Trung
				Quốc</option>
		</select>
		<HR />

		<p>Gender: ${user.gender}</p>

		<button formaction="/TS02418_Lab02/form/create">Create</button>

		<button>UPDATE</button>
		${capnhat}
	</form>

</body>
</html>