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
<link rel="stylesheet" type="text/css" href="style.css" />
<body>
	<%
		Inspector inspector = (Inspector) session.getAttribute("inspector");

		if (inspector instanceof PatrolInspector) {
			PatrolInspector patrolInspector = (PatrolInspector) inspector;
	%>
	<!-- Top div -->
	<div id="content_top">
		<table border="0" width="100%">
			<tr>
				<td width="10%">Пользователь:</td>
				<td width="30%"><%=patrolInspector.getName()%></td>
				<td align="right"><a href="logout" class="href_style">Выход
						из системы</a></td>
			</tr>
			<tr>
				<td>Должность:</td>
				<td>патрульный инспектор</td>
			</tr>
		</table>
	</div>
	<br>
	<!-- Main div -->
	<div id="content_middle">
		<h1 class="title_align">Редактирование информации о протоколе</h1>
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
					<td class="title_style"><b>Информация о человеке</b></td>
				</tr>
				<tr>
					<td>ФИО:</td>
					<td><input type="text" class="input_style" name="name"
						value="<%=protocol.getHuman().getName()%>"></td>
				</tr>
				<tr>
					<td>Серия/номер паспорта:</td>
					<td><input type="text" class="input_style"
						name="passportNumber"
						value="<%=protocol.getHuman().getPassportNumber()%>"></td>
				</tr>
				<tr>
					<td>Адрес:</td>
					<td><textarea name="adress" class="textarea_style" cols="34"
							rows="3"><%=protocol.getHuman().getAddress()%></textarea></td>
				</tr>
				<tr>
					<td class="title_style"><b>Информация о нарушении</b></td>
				</tr>
				<tr>
					<td>Тип нарушения:</td>
					<td><textarea name="title" class="textarea_style" cols="34"
							rows="3"><%=protocol.getViolation().getTitle()%></textarea></td>
				</tr>
				<tr>
					<td>Действия:</td>
					<td><textarea name="description" class="textarea_style"
							cols="34" rows="3"><%=protocol.getViolation().getDescription()%></textarea></td>
				</tr>
				<tr>
					<td>Ответственность:</td>
					<td><textarea name="punishment" class="textarea_style"
							cols="34" rows="3"><%=protocol.getViolation().getPunishment()%></textarea></td>
				</tr>
				<tr>
					<td class="title_style"><b>Информация об автомобиле</b></td>
				</tr>

				<tr>
					<td>Номер кузова:</td>
					<td><input type="text" class="input_style" name="VIN"
						value="<%=protocol.getVehicle().getVIN()%>"></td>
				</tr>
				<tr>
					<td>Номер двигателя:</td>
					<td><input type="text" class="input_style" name="EIN"
						value="<%=protocol.getVehicle().getEIN()%>"></td>
				</tr>
				<tr>
					<td>Цвет:</td>
					<td><input type="text" class="input_style" name="color"
						value="<%=protocol.getVehicle().getColor()%>"></td>
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
						value="<%=protocol.getVehicle().getYear().toString()%>"></td>
				</tr>
				<tr>
					<td class="title_style"><b>Другая информация о нарушении</b></td>
				</tr>
				<tr>
					<td>Дата:</td>
					<td><input type="text" class="input_style" name="date"
						value="<%=protocol.getDate().toString()%>"></td>
				</tr>
				<tr>
					<td>Регистрационный номер:</td>
					<td><input type="text" class="input_style"
						name="registrationNumber" value="?"></td>
				</tr>
			</table>
			<p class="title_align">
				<%
					if (protocol.getId() != DBObject.UNDEFINED_ID) {
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