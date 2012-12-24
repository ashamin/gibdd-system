<%@page import="model.AutomaticRecorder"%>
<%@page import="model.DutyTour"%>
<%@page import="model.Violation"%>
<%@page import="model.Protocol"%>
<%@page import="model.Vehicle"%>
<%@page import="model.VehicleRegistrationCertificate"%>
<%@page import="model.Human"%>
<%@page import="model.DriverLicense"%>
<%@page import="model.Inspector"%>
<%@page import="model.DriverLicenseInspector"%>
<%@page import="model.DutyInspector"%>
<%@page import="model.PatrolInspector"%>
<%@page import="model.VehicleInspector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	Inspector inspector = (Inspector) session.getAttribute("inspector");

	// If patrol inspector sign in, than update workspace page every 5 seconds
	if (inspector instanceof PatrolInspector) {
%>
<meta http-equiv="refresh" content="5">
<%
	}
%>
<title>Информационная система ГИБДД: Рабочее пространство
	инспектора</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<%
		if (inspector instanceof DriverLicenseInspector) {
			DriverLicenseInspector driverLicenseInspector = (DriverLicenseInspector) inspector;
	%>
	<!-- Top div -->
	<div id="content_top">
		<table border="0" width="100%">
			<tr>
				<td width="10%">Пользователь:</td>
				<td width="30%"><%=driverLicenseInspector.getName()%></td>
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
	<div id="content_middle_main">
		<h1>Водительские удостоверения</h1>
		<form>
			<!-- Table Driver Licenses -->
			<table class="formdata" border="1">
				<tr>
					<th></th>
					<th>№</th>
					<th>ФИО</th>
					<th>Серия/номер паспорта</th>
					<th>Адрес</th>
					<th>Дата выдачи</th>
					<th>Дата истечения срока удостоверения</th>
					<th>Категории</th>
				</tr>

				<%
					int i = 0;
						for (DriverLicense driverLicense : driverLicenseInspector
								.selectDriverLicenses()) {
							Human human = driverLicense.getHuman();
				%>
				<tr>
					<td><input type="button" class="button_edit" value="Ред."
						onclick="location.href='driver-license-form.jsp?id=<%=driverLicense.getId()%>'"></td>
					<td><%=++i%></td>
					<td><%=human.getName()%></td>
					<td><%=human.getPassportNumber()%></td>
					<td><%=human.getAddress()%></td>
					<td><%=driverLicense.getRegistrationDate().toString()%></td>
					<td><%=driverLicense.getLeaveDate().toString()%></td>
					<td><%=driverLicense.getCategories()%></td>
				</tr>
				<%
					} // End of for-loop
				%>

			</table>
			<p>
				<input type="button"
					class="button_style_main_driver_license_vehicle"
					value="Новое водительское удостоверение"
					onclick="location.href='driver-license-form.jsp'">
			</p>
		</form>
	</div>

	<%
		} else if (inspector instanceof DutyInspector) {
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
	<div id="content_middle_main">
		<!-- Current duty tour table -->
		<h1>Текущий наряд</h1>

		<form>
			<%
				DutyTour currentDutyTour = (DutyTour) session
							.getAttribute("current-duty-tour");
					if (currentDutyTour != null) {
			%>
			<table class="formdata" border="1">
				<tr>
					<th></th>
					<th>Назначенные инспекторы</th>
					<th>Автоматические регистраторы</th>
					<th>Дата начала</th>
				</tr>
				<tr>
					<td><input type="button" class="button_edit" value="Ред."
						onclick="location.href='duty-tour-form.jsp?action=edit'"></td>
					<td>
						<ul>
							<%
								for (PatrolInspector patrolInspector : currentDutyTour
												.getPatrolInspectors()) {
							%>
							<li><%=patrolInspector.getName()%></li>
							<%
								}
							%>
						</ul>
					</td>
					<td>
						<ul>
							<%
								for (AutomaticRecorder automaticRecorder : currentDutyTour
												.getAutomaticRecorders()) {
							%>
							<li><%=automaticRecorder.getUID()%></li>
							<%
								}
							%>
						</ul>
					</td>
					<td><%=currentDutyTour.getStartDate()%></td>
				</tr>
			</table>
			<p>
				<input type="button" value="Остановить наряд"
					onclick="location.href='duty-tour-form.jsp?action=stop'" />
			</p>
			<%
				} else {
			%>
			На данный момент нарядов нет
			<p>
				<input type="button" value="Запустить наряд"
					onclick="location.href='duty-tour-form.jsp?action=start'" />
			</p>
			<%
				}
			%>
		</form>
		
		<h1>Прошлые наряды</h1>
		<!-- Table Duty Tours -->
		<table class="formdata" border="1">
			<tr>
				<th>№</th>
				<th>Назначенные инспекторы</th>
				<th>Дата начала</th>
				<th>Дата окончания</th>
			</tr>
			<%
				int i = 0;
					for (DutyTour dutyTour : dutyInspector.selectDutyTours()) {
			%>
			<tr>
				<td><%=++i%></td>
				<td>
					<ul>
						<%
							for (PatrolInspector patrolInspector : dutyTour
											.getPatrolInspectors()) {
						%>
						<li><%=patrolInspector.getName()%></li>
						<%
							}
						%>
					</ul>
				</td>
				<td><%=dutyTour.getStartDate()%></td>
				<td><%=dutyTour.getFinishDate()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<br />
	</div>
	<%
		} else if (inspector instanceof PatrolInspector) {
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
	<div id="content_middle_main">
		<h1>Протоколы</h1>
		<form>
			<!-- Table Protocols -->
			<table class="formdata" border="1">
				<tr>
					<th></th>
					<th>№</th>
					<th>ФИО</th>
					<th>Номер авто</th>
					<th>Цвет</th>
					<th>Марка</th>
					<th>Тип нарушения</th>
					<th>Действия</th>
					<th>Ответственность</th>
					<th>Дата</th>
					<th>Состояние</th>
				</tr>
				<%
					int i = 0;
						for (Protocol protocol : patrolInspector.selectProtocols()) {
							Human human = protocol.getHuman();
							Vehicle vehicle = protocol.getVehicle();
							Violation violation = protocol.getViolation();
				%>
				<tr>
					<td><input type="button" class="button_edit" value="Ред."
						onclick="location.href='protocol-form.jsp?id=<%=protocol.getId()%>'"></td>
					<td><%=++i%></td>
					<td><%=human.getName()%></td>
					<td>?</td>
					<td><%=vehicle.getColor()%></td>
					<td><%=vehicle.getBrand()%></td>
					<td><%=violation.getTitle()%></td>
					<td><%=violation.getDescription()%></td>
					<td><%=violation.getPunishment()%></td>
					<td><%=protocol.getDate().toString()%></td>
					<td>?</td>
				</tr>
				<%
					}
				%>
			</table>
			<p>
				<input type="button" class="button_style_main_duty_tour_protocol"
					value="Новый протокол" onclick="location.href='protocol-form.jsp'" />
			</p>
		</form>
	</div>
	<%
		} else if (inspector instanceof VehicleInspector) {
			VehicleInspector vehicleInspector = (VehicleInspector) inspector;
	%>
	<!-- Top div -->
	<div id="content_top">
		<table border="0" width="100%">
			<tr>
				<td width="10%">Пользователь:</td>
				<td width="30%"><%=vehicleInspector.getName()%></td>
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
	<!-- Main div  -->
	<div id="content_middle_main">
		<h1>Транспортные средства</h1>
		<form>
			<!-- Table Vehicle Registration Sertificates -->
			<table class="formdata" border="1">
				<tr>
					<th></th>
					<th>№</th>
					<th>ФИО</th>
					<th>Номер кузова</th>
					<th>Номер двигателя</th>
					<th>Цвет</th>
					<th>Марка</th>
					<th>Год выпуска</th>
					<th>Регистрационный номер</th>
					<th>Дата постановки на учет</th>
					<th>Дата снятия с учета</th>
				</tr>
				<%
					// TODO: Implement for-loop over all vehicle registration certificates
						int i = 0;
						for (VehicleRegistrationCertificate vrc : vehicleInspector
								.selectVehicleRegistrationCertificates()) {
							Human human = vrc.getHuman();
							Vehicle vehicle = vrc.getVehicle();
				%>
				<tr>
					<td><input type="button" class="button_edit" value="Ред."
						onclick="location.href='vehicle-registration-certificate-form.jsp?id=<%=vrc.getId()%>'"></td>
					<td><%=++i%></td>
					<td><%=human.getName()%></td>
					<td><%=vehicle.getVIN()%></td>
					<td><%=vehicle.getEIN()%></td>
					<td><%=vehicle.getColor()%></td>
					<td><%=vehicle.getBrand()%></td>
					<td><%=vehicle.getYear().toString()%></td>
					<td><%=vrc.getRegistrationNumber()%></td>
					<td><%=vrc.getRegistrationDate().toString()%></td>
					<td><%=(vrc.getLeaveDate() == null) ? "-" : vrc
							.getLeaveDate().toString()%></td>
				</tr>
				<%
					}
				%>
			</table>
			<p>
				<input type="button"
					class="button_style_main_driver_license_vehicle"
					value="Новое свидетельство о регистрации"
					onclick="location.href='vehicle-registration-certificate-form.jsp'">
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