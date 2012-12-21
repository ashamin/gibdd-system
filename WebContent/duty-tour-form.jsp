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
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<%
		Inspector inspector = (Inspector) session.getAttribute("inspector");

		if (inspector instanceof DutyInspector) {
			DutyInspector dutyInspector = (DutyInspector) inspector;
	%>
	<!-- Top div -->
	<div id="content_top">
		<table border="0" width="100%">
			<tr>
				<td width="10%">Пользователь:</td>
				<td width="30%"><%=dutyInspector.getName()%></td>
				<td align="right"><a href="logout" class="href_style">Выход
						из системы</a></td>
			</tr>
			<tr>
				<td>Должность:</td>
				<td>дежурный инспектор</td>
			</tr>
		</table>
	</div>
	<br>
	<!-- Main div -->
	<div id="content_middle">
		<h1 class="title_align">Редактирование информации о наряде</h1>
		<form>
			<table>
				<tr>
					<td>Инспекторы:</td>
				</tr>
				<tr>
					<td></td>
					<td class="checkbox_style">
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
					<td class="checkbox_style">
						<%
							// TODO: Implement for-loop over all automatic recorders
						%> <input type="checkbox" name="" value="no"> <br /> <%
 	// End of for-loop
 %>
					</td>
				</tr>
				<tr>
					<td class="title_style"><b>Другая информация</b></td>
				</tr>
				<tr>
					<td>Дата начала наряда:</td>
					<td><input type="text" class="input_style" name="startDate"></td>
				</tr>
				<tr>
					<td>Дата окончания наряда:</td>
					<td><input type="text" class="input_style" name="finishDate"></td>
				</tr>
			</table>
			<p class="title_align">
				<%
					if (request.getParameter("id") == null) {
				%>
				<input type="button" class="button_style" value="Запустить">
				<%
					} else {
				%>
				<input type="button" class="button_style" value="Остановить">
				<input type="button" class="button_style" value="Обновить">
				<input type="button" class="button_style" value="Удалить">
				<%
					}
				%>
				<input type="button" class="button_style" value="Назад"
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