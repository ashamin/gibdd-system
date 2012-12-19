<%@page import="model.Inspector"%>
<%@page import="model.DriverLicenseInspector"%>
<%@page import="model.DutyInspector"%>
<%@page import="model.PatrolInspector"%>
<%@page import="model.VehicleInspector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	Inspector inspector = (Inspector) session.getAttribute("inspector");

	// If patrol inspector sign in, than update workspace page every 5 seconds
	if (inspector instanceof PatrolInspector) {
%>
<meta http-equiv="refresh" content="5">
<%
	}
%>
<title>Информационная система ГИБДД: Рабочее пространство
	инспектора</title>
</head>
<body>
	<%
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
		<h1>Водительские удостоверения</h1>
		<form>
			<!-- Table Driver Licenses -->
			<table border="1">
				<tr>
					<th></th>
					<th>№</th>
					<th>ФИО</th>
					<th>Серия/номер паспорта</th>
					<th>Адрес</th>
					<th>Дата выдачи</th>
					<th>Дата истечения срока удостоверения</th>
					<th>Категории</th>
				</tr>

				<%
					// TODO: implement for-loop over all driver licenses
				%>
				<tr>
					<td><input type="button" value="Ред."
						onclick="location.href='driver-license-form.jsp?id='"></td>
				</tr>
				<%
					// End of for-loop
				%>
			</table>
			<p>
				<input type="button" value="Новое водительское удостоверение"
					onclick="location.href='driver-license-form.jsp'">
			</p>
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
		<h1>Наряды</h1>
		<form>
			<table border="1">
				<tr>
					<th></th>
					<th>№</th>
					<th>Назначенные инспекторы</th>
					<th>Автоматические регистраторы</th>
					<th>Дата начала</th>
					<th>Дата окончания</th>
					<th>Состояние</th>
				</tr>
				<%
					// TODO: Implement for-loop over all duty tours
				%>
				<tr>
					<td><input type="button" value="Ред."
						onclick="location.href='duty-tour-form.jsp?id='"></td>
				</tr>
				<%
					// End of for-loop
				%>
			</table>
			<p>
				<input type="button" value="Новый наряд"
					onclick="location.href='duty-tour-form.jsp'" />
			</p>
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
		<h1>Протоколы</h1>
		<form>
			<table border="1">
				<tr>
					<th></th>
					<th>№</th>
					<th>ФИО</th>
					<th>Номер кузова</th>
					<th>Номер двигателя</th>
					<th>Цвет</th>
					<th>Марка</th>
					<th>Год выпуска</th>
					<th>Тип нарушения</th>
					<th>Действия</th>
					<th>Ответственность</th>
					<th>Дата</th>
					<th>Регистрационный номер</th>
					<th>Состояние</th>
				</tr>
				<%
					// TODO: Implement for-loop over all protocols
				%>
				<tr>
					<td><input type="button" value="Ред."
						onclick="location.href='protocol-form.jsp?id='"></td>
				</tr>
				<%
					// End of for-loop
				%>
			</table>
			<p>
				<input type="button" value="Новый протокол"
					onclick="location.href='protocol-form.jsp'" />
			</p>
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
		<h1>Транспортные средства</h1>
		<form>
			<table border="1">
				<tr>
					<th></th>
					<th>№</th>
					<th>ФИО</th>
					<th>Серия/номер паспорта</th>
					<th>Адрес</th>
					<th>Номер кузова</th>
					<th>Номер двигателя</th>					
					<th>Цвет</th>
					<th>Марка</th>
					<th>Год выпуска</th>
					<th>Регистрационный номер</th>
					<th>Дата постановки на учет</th>
					<th>Дата снятия с учета</th>
				</tr>
				<%
					// TODO: Implement for-loop over all vehicle registration certificates
				%>
				<tr>
					<td><input type="button" value="Ред."
						onclick="location.href='vehicle-registration-certificate-form.jsp?id='"></td>
				</tr>
				<%
					// End of for-loop
				%>
			</table>
			<p>
				<input type="button" value="Новое свидетельство о регистрации"
					onclick="location.href='vehicle-registration-certificate-form.jsp'">
			</p>
		</form>
	</div>
	<%
		} else {
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>