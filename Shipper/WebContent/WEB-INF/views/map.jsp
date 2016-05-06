<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="select"%>
<!DOCTYPE html>
<html>
<head>
<title>Map API Google NgocKhanhLe</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<link href="css/style_sheet.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyASxdPzoprKu6vtP5N5DIjqqfHuUaHixhQ&language=vi&libraries=places">
	
</script>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body id=homeview onload="initialize()">
	<div id="container">

		<div id="header">
			<jsp:include page="_header.jsp"></jsp:include>
		</div>

		<div id="main">
			<div class="sidebar"
				style="font-size: 18px; font-family: monospace; padding-left: 10px;">
				<p class="pclass">INFORMATTION MAP</p>

				<div>
					<input id="idLookup" type="text" placeholder="Enter a location"
						onkeydown="if (event.keyCode == 13) { doSearch() ;return false;}" />

					<a id="searchlocal" onclick="doSearch()">Search</a>
				</div>

				<div>
					<input id=btEdit type="image" src="images/lg1.png"
						onclick="initialize()">
					<!-- <div class="a" style=" display: none;">Map Direction</div> -->
					<input id=btEdit type="image" src="images/lg2.png"
						onclick="doEdit()">
					<!-- 	<div class="b" style=" display: none;">Information</div> -->
					<input id=btEdit type="image" src="images/lg3.png"
						onclick="doTimer()">
					<div class="c" style="display: none;">Help User</div>

				</div>

				<div id="divMapOption">
					<div>
						<b>Warehouse-Start :</b> <select id="start">
							<option
								value="Số 12 Nguyễn Văn Bảo, Phường 4, Quận Gò Vấp, Thành phố Hồ Chí Minh">Kho
								Hang 1</option>
							<option value="1 quang trung, go vap">Kho Hang 2</option>
						</select>
					</div>
					<div>
						<b>Addresss:</b><br /> <select multiple id="waypoints"
							style="width: 97%; height: 100px;">
							<c:forEach items="${KhachhangList}" var="kh">
								<option value="${kh.diachi}">${kh.diachi}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<b>Warehouse-End :</b> <select id="end">
							<option
								value="Số 12 Nguyễn Văn Bảo, Phường 4, Quận Gò Vấp, Thành phố Hồ Chí Minh">Kho
								Hang 1</option>
							<option value="quang trung, go vap">Kho Hang 2</option>
						</select> <br> <input type="submit" value="Direction" id="submit">
					</div>
					<div>
						<b>Mode:</b> <select id="mode">
							<option value="DRIVING">Driving</option>
							<option value="WALKING">Walking</option>
							<option value="BICYCLING">Bicycling</option>
							<option value="TRANSIT">Transit</option>
						</select>
					</div>

				</div>


				<div id=directions-panel></div>
			</div>



			<div class="content">
				<div id="map-canvas"></div>
			</div>


			<div id="contentTable"></div>

			<div class="clear"></div>
		</div>


		<div id="footer">
			<jsp:include page="_footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>