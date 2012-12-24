<%@page import="model.DBObject"%>
<%@page import="model.VehicleRegistrationCertificate"%>
<%@page import="model.VehicleInspector"%>
<%@page import="model.Inspector"%>
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

		if (inspector instanceof VehicleInspector) {
			VehicleInspector vehicleInspector = (VehicleInspector) inspector;
	%>
	<!-- Top div -->
	<div id="content_top">
		<table border="0" width="100%">
			<tr>
				<td width="10%">Пользователь:</td>
				<td width="40%"><%=vehicleInspector.getName()%></td>
				<td align="right"><a href="logout" class="href_style">Выход
						из системы</a></td>
			</tr>
			<tr>
				<td>Должность:</td>
				<td>инспектор, оформляющий ТС</td>
			</tr>
		</table>
	</div>
	<br>
	<!-- Vehicle registration certificate form div  -->
	<div id="content_middle">
		<h1 class="title_align">Редактирование информации о регистрации
			автомобиля</h1>
		<%
			VehicleRegistrationCertificate vrc = new VehicleRegistrationCertificate();
				if (request.getParameter("id") != null) {
					int id = DBObject.UNDEFINED_ID;

					try {
						id = Integer.parseInt(request.getParameter("id"));
					} catch (Exception e) {
					}

					vrc.select(id);
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
						value="<%=vrc.getHuman().getName()%>" /></td>
				</tr>
				<tr>
					<td>Серия/номер паспорта:</td>
					<td><input type="text" class="input_style"
						name="passportNumber"
						value="<%=vrc.getHuman().getPassportNumber()%>" /></td>
				</tr>
				<tr>
					<td>Адрес:</td>
					<td><textarea name="adress" class="textarea_style" cols="16"
							rows="1"><%=vrc.getHuman().getAddress()%></textarea></td>
				</tr>
				<tr>
					<td class="title_style"><b>Информация об автомобиле</b></td>
				</tr>
				<tr>
					<td>Номер кузова:</td>
					<td><input type="text" class="input_style" name="VIN"
						value="<%=vrc.getVehicle().getVIN()%>" /></td>
				</tr>
				<tr>
					<td>Номер двигателя:</td>
					<td><input type="text" class="input_style" name="EIN"
						value="<%=vrc.getVehicle().getEIN()%>" /></td>
				</tr>
				<tr>
					<td>Цвет:</td>
					<td><input type="text" class="input_style" name="color"
						value="<%=vrc.getVehicle().getColor()%>" /></td>
				</tr>
				<tr>
					<td>Марка:</td>
					<td><select name="brand" class="select_style">
							<%
								// TODO: Implement for-loop over all brands
							%>
							<option value=""></option>
							<%
								// End of for-loop
							%>
					</select></td>
				</tr>
				<tr>
					<td>Год выпуска:</td>
					<td><input type="text" class="input_style" name="year"
						value="<%=vrc.getVehicle().getYear().toString()%>" /></td>
				</tr>
				<tr>
					<td>Регистрационный номер:</td>
					<td><input type="text" class="input_style"
						name="registrationNumber" value="<%=vrc.getRegistrationNumber()%>" /></td>
				</tr>
				<tr>
					<td class="title_style"><b>Другая информация</b></td>
				</tr>
				<tr>
					<td>Дата постановки на учет:</td>
					<td><input type="text" class="input_style"
						name="registrationDate"
						value="<%=vrc.getRegistrationDate().toString()%>" /></td>
				</tr>
				<tr>
					<td>Дата снятия с учета:</td>
					<td><input type="text" class="input_style" name="leaveDate"
						value="<%=(vrc.getLeaveDate() == null) ? "-" : vrc
						.getLeaveDate()%>" /></td>
				</tr>
			</table>
			<p class="title_align">
				<%
					if (vrc.getId() != DBObject.UNDEFINED_ID) {
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