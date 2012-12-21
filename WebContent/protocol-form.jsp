<%@page import="model.DBObject"%>
<%@page import="model.Protocol"%>
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
<body>
	<%
		Inspector inspector = (Inspector) session.getAttribute("inspector");

		if (inspector instanceof PatrolInspector) {
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
		<h1>Редактирование информации о протоколе</h1>
		<%
			Protocol protocol = new Protocol();
				if (request.getParameter("id") != null) {
					int id = DBObject.UNDEFINED_ID;

					try {
						id = Integer.parseInt(request.getParameter("id"));
					} catch (Exception e) {
					}

					protocol.select(id);
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
						value="<%=protocol.getHuman().getName()%>"></td>
				</tr>
				<tr>
					<td>Серия/номер паспорта:</td>
					<td><input type="text" name="passportNumber"
						style='width: 100%'
						value="<%=protocol.getHuman().getPassportNumber()%>"></td>
				</tr>
				<tr>
					<td>Адрес:</td>
					<td><textarea name="adress" cols="34" rows="1"><%=protocol.getHuman().getAddress()%></textarea></td>
				</tr>
				<tr>
					<td><b>Информация о нарушении</b></td>
				</tr>
				<tr>
					<td>Тип нарушения:</td>
					<td><textarea name="title" cols="34" rows="3"><%=protocol.getViolation().getTitle()%></textarea></td>
				</tr>
				<tr>
					<td>Действия:</td>
					<td><textarea name="description" cols="34" rows="3"><%=protocol.getViolation().getDescription()%></textarea></td>
				</tr>
				<tr>
					<td>Ответственность:</td>
					<td><textarea name="punishment" cols="34" rows="3"><%=protocol.getViolation().getPunishment()%></textarea></td>
				</tr>
				<tr>
					<td><b>Информация об автомобиле</b></td>
				</tr>

				<tr>
					<td>Номер кузова:</td>
					<td><input type="text" name="VIN" style='width: 100%'
						value="<%=protocol.getVehicle().getVIN()%>"></td>
				</tr>
				<tr>
					<td>Номер двигателя:</td>
					<td><input type="text" name="EIN" style='width: 100%'
						value="<%=protocol.getVehicle().getEIN()%>"></td>
				</tr>
				<tr>
					<td>Цвет:</td>
					<td><input type="text" name="color" style='width: 100%'
						value="<%=protocol.getVehicle().getColor()%>"></td>
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
						value="<%=protocol.getVehicle().getYear().toString()%>"></td>
				</tr>
				<tr>
					<td><b>Другая информация о нарушении</b></td>
				</tr>
				<tr>
					<td>Дата:</td>
					<td><input type="text" name="date" style='width: 100%'
						value="<%=protocol.getDate().toString()%>"></td>
				</tr>
				<tr>
					<td>Регистрационный номер:</td>
					<td><input type="text" name="registrationNumber"
						style='width: 100%' value="?"></td>
				</tr>
			</table>
			<p>
				<%
					if (protocol.getId() != DBObject.UNDEFINED_ID) {
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