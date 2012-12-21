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
</head>
<body>
	<%
		Inspector inspector = (Inspector) session.getAttribute("inspector");

		if (inspector instanceof VehicleInspector) {
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
	<!-- Vehicle registration certificate form div  -->
	<div>
		<h1>Редактирование информации о регистрации автомобиля</h1>
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
					<td><b>Информация о человеке</b></td>
				</tr>
				<tr>
					<td>ФИО:</td>
					<td><input type="text" name="name" style='width: 100%'
						value="<%=vrc.getHuman().getName()%>" /></td>
				</tr>
				<tr>
					<td>Серия/номер паспорта:</td>
					<td><input type="text" name="passportNumber"
						style='width: 100%'
						value="<%=vrc.getHuman().getPassportNumber()%>" /></td>
				</tr>
				<tr>
					<td>Адрес:</td>
					<td><textarea name="adress" cols="16" rows="1"></textarea></td>
				</tr>
				<tr>
					<td><b>Информация об автомобиле</b></td>
				</tr>
				<tr>
					<td>Номер кузова:</td>
					<td><input type="text" name="VIN" style='width: 100%'
						value="<%=vrc.getVehicle().getVIN()%>" /></td>
				</tr>
				<tr>
					<td>Номер двигателя:</td>
					<td><input type="text" name="EIN" style='width: 100%'
						value="<%=vrc.getVehicle().getEIN()%>" /></td>
				</tr>
				<tr>
					<td>Цвет:</td>
					<td><input type="text" name="color" style='width: 100%'
						value="<%=vrc.getVehicle().getColor()%>" /></td>
				</tr>
				<tr>
					<td>Марка:</td>
					<td><select name="brand">
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
					<td><input type="text" name="year" style='width: 100%'
						value="<%=vrc.getVehicle().getYear().toString()%>" /></td>
				</tr>
				<tr>
					<td>Регистрационный номер:</td>
					<td><input type="text" name="registrationNumber"
						style='width: 100%' value="<%=vrc.getRegistrationNumber()%>" /></td>
				</tr>
				<tr>
					<td><b>Другая информация</b></td>
				</tr>
				<tr>
					<td>Дата постановки на учет:</td>
					<td><input type="text" name="registrationDate"
						style='width: 100%'
						value="<%=vrc.getRegistrationDate().toString()%>" /></td>
				</tr>
				<tr>
					<td>Дата снятия с учета:</td>
					<td><input type="text" name="leaveDate" style='width: 100%'
						value="<%=(vrc.getLeaveDate() == null) ? "-" : vrc
						.getLeaveDate()%>" /></td>
				</tr>
			</table>
			<p>
				<%
					if (vrc.getId() != DBObject.UNDEFINED_ID) {
				%>
				<input type="button" value="Обновить" /> <input type="button"
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