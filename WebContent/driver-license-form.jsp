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
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<%
		Inspector inspector = (Inspector) session.getAttribute("inspector");

		if (inspector instanceof DriverLicenseInspector) {
			DriverLicenseInspector driverLicenseInspector = (DriverLicenseInspector) inspector;
	%>
	<!-- Top div -->
	<div id="content_top">
		<table border="0" width="100%">
			<tr>
				<td width="10%">Пользователь:</td>
				<td width="40%"><%=driverLicenseInspector.getName()%></td>
				<td align="right"><a href="logout" class="href_style">Выход
						из системы</a></td>
			</tr>
			<tr>
				<td>Должность:</td>
				<td>инспектор, выдающий права</td>
			</tr>
		</table>
	</div>
	<br>
	<!-- Main div -->
	<div id="content_middle">
		<h1 class="title_align">Редактирование информации о водительском
			удостоверении</h1>
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
					<td class="title_style"><b>Информация о человеке</b></td>
				</tr>
				<tr>
					<td>ФИО:</td>
					<td><input type="text" class="input_style" name="name"
						value="<%=driverLicense.getHuman().getName()%>" /></td>
				</tr>
				<tr>
					<td>Серия/номер паспорта:</td>
					<td><input type="text" class="input_style"
						name="passportNumber"
						value="<%=driverLicense.getHuman().getPassportNumber()%>" /></td>
				</tr>
				<tr>
					<td>Адрес:</td>
					<td><textarea name="adress" class="textarea_style" cols="16"
							rows="1"><%=driverLicense.getHuman().getAddress()%></textarea></td>
				</tr>
				<tr>
					<td class="title_style"><b>Другая информация</b></td>
				</tr>
				<tr>
					<td>Дата выдачи удостоверения:</td>
					<td><input type="text" class="input_style"
						name="registrationDate"
						value="<%=driverLicense.getRegistrationDate().toString()%>" /></td>
				</tr>
				<tr>
					<td>Дата истечения срока удостоверения:</td>
					<td><input type="text" class="input_style" name="leaveDate"
						value="<%=driverLicense.getLeaveDate().toString()%>" /></td>
				</tr>
				<tr>
					<td>Категории:</td>
					<td><input type="text" class="input_style" name="categories"
						value="<%=driverLicense.getCategories()%>" /></td>
				</tr>
			</table>
			<p class="title_align">
				<%
					if (driverLicense.getId() != DBObject.UNDEFINED_ID) {
				%>
				<input type="button" class="button_style" value="Обновить" /> <input
					type="button" class="button_style" value="Удалить" />
				<%
					} else {
				%>
				<input type="button" class="button_style" value="Сохранить" />
				<%
					}
				%>
				<input type="button" class="button_style" value="Назад"
					onclick="location.href='workspace.jsp'" />
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