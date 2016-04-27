<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link href="css/style_sheet.css" rel="stylesheet" type="text/css" />
</head>
<body id=homeview>
	<div>

		<jsp:include page="_header.jsp"></jsp:include>
		<jsp:include page="_menu.jsp"></jsp:include>

		<h3>Home Page</h3>

		This is demo Simple web application using jsp,servlet &amp; Jdbc. <br>
		<br> <b>It includes the following functions:</b>
		<ul>
			<li>Login</li>
			<li>Storing user information in cookies</li>
			<li>Product List</li>
			<li>Create Product</li>
			<li>Edit Product</li>
			<li>Delete Product</li>
			<li>Map Google</li>
		</ul>

		<jsp:include page="_footer.jsp"></jsp:include>

	</div>
</body>
</html>