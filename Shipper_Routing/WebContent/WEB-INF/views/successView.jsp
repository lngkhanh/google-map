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
	<div id="successID">
		<div id="successID">
			<h1>
				Thank you !! Register success. Please click button <a href="login"
					style="text-decoration: none; color: white;">Login</a> to log back
				page.
			</h1>
			<a href="login" class="register">LOGIN</a> <a href="register"
				class="register">Register</a>
		</div>
	</div>

</body>
</html>