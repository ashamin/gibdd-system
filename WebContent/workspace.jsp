<%@page import="model.VehicleInspector"%>
<%@page import="model.DriverLicenseInspector"%>
<%@page import="model.DutyInspector"%>
<%@page import="model.PatrolInspector"%>

<%@page import="model.Inspector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Информационная система ГИБДД: Рабочее пространство
	инспектора</title>
</head>
<body>
	<%
		Inspector inspector = (Inspector) session.getAttribute("inspector");

		if (inspector instanceof DriverLicenseInspector) {
			DriverLicenseInspector driverLicenseInspector = (DriverLicenseInspector) inspector;
	%>
	<!-- Top div -->
	<div>
		<p>
			Пользователь:
			<%=driverLicenseInspector.getName()%>
			| Должность: Инспектор, выдающий права | <a href="logout">Выход
				из системы</a>
		</p>
	</div>
	<!-- Main div -->
	<div>
		<form name="LicenseInspector_main">
			<fieldset>
				<legend>Меню</legend>
				<table>
					<tr>
						<td><input type="button"
							value="Новое водительское удостоверение" style='width: 100%'
							onclick="location.href='#'"></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>

	<%
		} else if (inspector instanceof DutyInspector) {
			DutyInspector dutyInspector = (DutyInspector) inspector;
	%>
	<!-- Top div -->
	<div>
		<p>
			Пользователь:
			<%=dutyInspector.getName()%>
			| Должность: Дежурный инспектор | <a href="logout">Выход из
				системы</a>
		</p>
	</div>
	<!-- Main div -->
	<div>
		<form name="DutyInspector_main">
			<fieldset>
				<legend>Меню</legend>
				<table>
					<tr>
						<td colspan="2"><input type="button"
							value="Просмотреть наряд" style='width: 100%'
							onclick="location.href='#'"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" value="Добавить наряд"
							style='width: 100%' onclick="location.href='#'"></td>
					</tr>
					<tr>
						<td><input type="submit" value="Запустить наряд"
							style='width: 100%'></td>
						<td><input type="submit" value="Остановить наряд"
							style='width: 100%'></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
	<%
		} else if (inspector instanceof PatrolInspector) {
			PatrolInspector patrolInspector = (PatrolInspector) inspector;
	%>
	<!-- Top div -->
	<div>
		<p>
			Пользователь:
			<%=patrolInspector.getName()%>
			| Должность: Патрульный инспектор | <a href="logout">Выход из
				системы</a>
		</p>
	</div>
	<!-- Main div -->
	<div>
		<form name="PatrolInspector_main">
			<fieldset>
				<legend>Меню</legend>
				<table>
					<tr>
						<td>Протоколов в очереди:</td>
						<td>??????????????</td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" style='width: 100%'
							value="Заполнить следующий протокол"
							onclick="location.href='#'"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" style='width: 100%'
							value="Просмотреть протокол"
							onclick="location.href='#'"></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
	<%
		} else if (inspector instanceof VehicleInspector) {
			VehicleInspector vehicleInspector = (VehicleInspector) inspector;
	%>
	<!-- Top div -->
	<div>
		<p>
			Пользователь:
			<%=vehicleInspector.getName()%>
			| Должность: Инспектор, оформляющий ТС | <a href="logout">Выход
				из системы</a>
		</p>
	</div>
	<!-- Main div  -->
	<div>
		<form name="VehicleInspector_main">
			<fieldset>
				<legend>Меню</legend>
				<table>
					<tr>
						<td><input type="button"
							value="Новое свидетельство о регистрации" style='width: 100%'
							onclick="location.href='#'">
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
	<%
		} else {
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>