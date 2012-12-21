<%@page import="model.DBObject"%>
<%@page import="model.DriverLicense"%>
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
		<%
			DriverLicense driverLicense = new DriverLicense();

				if (request.getParameter("id") != null) {
					int id = DBObject.UNDEFINED_ID;

					try {
						id = Integer.parseInt(request.getParameter("id"));
					} catch (Exception e) {
					}

					driverLicense.select(id);
				}
		%>
		<form>
			<table>
				<tr>
					<td><b>Информация о человеке</b></td>
				</tr>
				<tr>
					<td>ФИО:</td>
					<td><input type="text" name="name" style='width: 100%'
						value="<%=driverLicense.getHuman().getName()%>" /></td>
				</tr>
				<tr>
					<td>Серия/номер паспорта:</td>
					<td><input type="text" name="passportNumber"
						style='width: 100%'
						value="<%=driverLicense.getHuman().getPassportNumber()%>" /></td>
				</tr>
				<tr>
					<td>Адрес:</td>
					<td><textarea name="adress" cols="16" rows="1"><%=driverLicense.getHuman().getAddress()%></textarea></td>
				</tr>
				<tr>
					<td><b>Другая информация</b></td>
				</tr>
				<tr>
					<td>Дата выдачи удостоверения:</td>
					<td><input type="text" name="registrationDate"
						style='width: 100%'
						value="<%=driverLicense.getRegistrationDate().toString()%>" /></td>
				</tr>
				<tr>
					<td>Дата истечения срока удостоверения:</td>
					<td><input type="text" name="leaveDate" style='width: 100%'
						value="<%=driverLicense.getLeaveDate().toString()%>" /></td>
				</tr>
				<tr>
					<td>Категории:</td>
					<td><input type="text" name="categories" style='width: 100%'
						value="<%=driverLicense.getCategories()%>" /></td>
				</tr>
			</table>
			<p>
				<%
					if (driverLicense.getId() != DBObject.UNDEFINED_ID) {
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