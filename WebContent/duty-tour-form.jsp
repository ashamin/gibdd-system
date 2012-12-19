<%@page import="model.DutyInspector"%>
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

		if (inspector instanceof DutyInspector) {
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
		<h1>Редактирование информации о наряде</h1>
		<form name="DriverLicense">
			<table>
				<tr>
					<td>Инспекторы:</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<%
							// TODO: Implement for-loop over all inspectors
						%> <input type="checkbox" name="" value="no"> <br /> <%
 	// End of for-loop
 %>
					</td>
				</tr>
				<tr>
					<td>Автоматические регистраторы:</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<%
							// TODO: Implement for-loop over all automatic recorders
						%> <input type="checkbox" name="" value="no"> <br /> <%
 	// End of for-loop
 %>
					</td>
				</tr>
				<tr>
					<td><b>Другая информация</b></td>
				</tr>
				<tr>
					<td>Дата начала наряда:</td>
					<td><input type="text" name="startDate" style='width: 100%'></td>
				</tr>
				<tr>
					<td>Дата окончания наряда:</td>
					<td><input type="text" name="finishDate" style='width: 100%'></td>
				</tr>
			</table>
			<p>
				<%
					if (request.getParameter("id") == null) {
				%>
				<input type="button" value="Запустить">
				<%
					} else {
				%>
				<input type="button" value="Остановить"> <input
					type="button" value="Обновить"> <input type="button"
					value="Удалить">
				<%
					}
				%>
				<input type="button" value="Назад"
					onclick="location.href='workspace.jsp'">
			</p>
		</form>
	</div>
	<%
		} else {

		}
	%>
</body>
</html>