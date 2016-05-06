<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toa Do List</title>
<link href="css/style_sheet.css" rel="stylesheet" type="text/css" />
</head>
<body id=homeview>
<body>


	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Toa Do List</h3>

	<p style="color: red;">${errorString}</p>

	<div id=tb_toado>
		<table>
			<tr>
				<th>Ma KH</th>
				<th>Ten KH</th>
				<th>Dia Chi</th>
				<th>SDT</th>
				<th>Ngay Mua</th>
			</tr>
			<c:forEach items="${KhachhangList}" var="kh">
				<tr>
					<td>${kh.makh}</td>
					<td>${kh.tenkh}</td>
					<td>${kh.diachi}</td>
					<td>${kh.sdt}</td>
					<td>${kh.ngaymua}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id=tb_toado>
		<table>
			<tr>
				<th>ID</th>
				<th>Ma KH</th>
				<th>Lat</th>
				<th>Lang</th>
			</tr>
			<c:forEach items="${ToadoList}" var="toado">
				<tr>
					<td>${toado.madh}</td>
					<td>${toado.manv}</td>
					<td>${toado.makh}</td>
					<td>${toado.lat}</td>
					<td>${toado.lang}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>