<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="css/style_sheet.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyASxdPzoprKu6vtP5N5DIjqqfHuUaHixhQ&language=vi">
	
</script>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body id=homeviewLogin>

	<jsp:include page="_header.jsp"></jsp:include>

	<div>
		<h2 class="formlogin">Account Login</h2>

		<div id=loginView_form>
			<form method="POST" action="doLogin">
				<table>
					<tr>
						<td>User Name</td>
						<td><input type="text" class="inputForm" name="userName"
							value="${user.userName}" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" class="inputForm" name="password"
							value="${user.password}" /></td>
					</tr>
					<tr>
						<td>Remember me</td>
						<td><input type="checkbox" name="rememberMe" value="Y" /></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center; padding-top: 10px;">
							<input class="myButton" type="submit" value="LOGIN" /> <a
							href="register" class="register">Register?</a>
						</td>
					</tr>
				</table>

			</form>
			<p style="color: red;">${errorString}</p>
		</div>

	</div>

</body>
</html>