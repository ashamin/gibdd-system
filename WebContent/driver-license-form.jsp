<%@page import="model.Inspector"%>
<%@page import="model.DriverLicenseInspector"%>
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
		<h1>Редактирование информации о водительском удостоверении</h1>
		<form name="DriverLicense">
			<table>
				<tr>
					<td><b>Информация о человеке</b></td>
				</tr>
				<tr>
					<td>ФИО:</td>
					<td><input type="text" name="name" style='width: 100%' /></td>
				</tr>
				<tr>
					<td>Серия/номер паспорта:</td>
					<td><input type="text" name="passportNumber"
						style='width: 100%' /></td>
				</tr>
				<tr>
					<td>Адрес:</td>
					<td><textarea name="adress" cols="16" rows="1"></textarea></td>
				</tr>
				<tr>
					<td><b>Другая информация</b></td>
				</tr>
				<tr>
					<td>Дата выдачи удостоверения:</td>
					<td><input type="text" name="registrationDate"
						style='width: 100%' /></td>
				</tr>
				<tr>
					<td>Дата истечения срока удостоверения:</td>
					<td><input type="text" name="leaveDate" style='width: 100%' /></td>
				</tr>
				<tr>
					<td>Категории:</td>
					<td><input type="text" name="categories" style='width: 100%' /></td>
				</tr>
			</table>
			<p>
				<%
					if (request.getParameter("id") != null) {
				%>
				<input type="button" value="Обновить" /><input type="button"
					value="Удалить" />
				<%
					} else {
				%>
				<input type="button" value="Сохранить" />
				<%
					}
				%>
				<input type="button" value="Назад"
					onclick="location.href='workspace.jsp'" />
			</p>
		</form>
	</div>
	<%
		} else {

		}
	%>
</body>
</html>