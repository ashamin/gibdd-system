<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Информационная система ГИБДД: Вход в систему</title>
</head>
<body>
	<div>
		<h1>Вход в систему</h1>
		<form method="post" action="login">
			<table>
				<tr>
					<td>Имя пользователя:</td>
					<td><input type="text" name="login"></td>
				</tr>
				<tr>
					<td>Пароль:</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<p>
				<input type="submit" value="Вход">
			</p>
		</form>
		<%
			String loginError = (String) session.getAttribute("login-error");
			if (loginError != null) {
				session.setAttribute("login-error", null);
		%>
		<div>
			<p>
				Ошибка:
				<%=loginError%></p>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>