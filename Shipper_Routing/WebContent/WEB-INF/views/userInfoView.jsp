<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
<link href="css/style_sheet.css" rel="stylesheet" type="text/css" />
</head>
<body id=homeview>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>
		Hello: <b>${user.userName}</b>
	</h3>
	User Name:
	<b>${user.userName}</b>
	<br /> Ho Ten:
	<b>${user.tennv }</b>
	<br /> Password:
	<b>${user.password}</b>
	<br /> Ma Nv:
	<b>${user.manv }</b>
	<br /> Dia Chi:
	<b>${user.diachinv }</b>
	<br /> sdt:
	<b>${user.sdtnv}</b>
	<br /> Ngay Vao Lam:
	<b>${user.ngayvaolam }</b>
	<br />

</body>
</html>