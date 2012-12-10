package model;

import java.util.Date;

/**
 * Класс описывает параметры инспектора, выдающего права. <br/>
 * Является наследником класса Inspector. Реализует добавление, удаление и
 * исправление указанных данных об инспекторе, регистрирующем ТС, а также
 * представление объекта в виде строки и поиск объекта по id.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class VehicleInspector extends Inspector {

	/**
	 * Конструктор по умолчанию для класса VehicleInspector. <br/>
	 * Создает экземпляр класса со стандартными значениями полей “ФИО”,
	 * “Серия/номер паспорта”, “Адрес”, “Звание”, “Должность”, “Логин”,
	 * “Пароль”.
	 */
	public VehicleInspector() {
		super();
	}

	/**
	 * Создает экземпляр класса VehicleInspector. <br/>
	 * Входными параметрами являются name, passportNumber, adress, rank, post,
	 * login, password, обозначающими соответственно для данного объекта “ФИО”,
	 * “Серия/номер паспорта”, “Адрес”, “Звание”, “Должность”, “Логин для входа
	 * в систему”, “Пароль”.
	 * 
	 * @param name
	 * @param passportNumber
	 * @param address
	 * @param rank
	 * @param post
	 * @param login
	 * @param password
	 */
	public VehicleInspector(String name, String passportNumber, String address,
			String rank, String post, String login, String password) {
		super(name, passportNumber, address, rank, post, login, password);
	}

	/**
	 * Конструктор копирования для класса VehicleInspector. <br/>
	 * Создает копию объекта VehicleInspector(объект с идентичными значениями
	 * параметров входного экземпляра класса VehicleInspector). Входным
	 * параметром является объект класса VehicleInspector.
	 * 
	 * @param inspector
	 */
	public VehicleInspector(VehicleInspector inspector) {
		super((Inspector) inspector);
	}

	/**
	 * Заполняет объект типа свидетельство о регистрации транспортного средства
	 * в соответствии с данными, указанными в параметрах и записывает информацию
	 * о нем в базу данных. <br/>
	 * Входными параметрами являются vehicle, human, registrationNumber,
	 * registrationDate, leaveDate, обозначающими соответственно объект
	 * ''Автомобиль'', объект ''Человек'', регистрационный номер, дату
	 * регистрации, дату окончания регистрации.
	 * 
	 * @param vehicle
	 * @param human
	 * @param registrationNumber
	 * @param registrationDate
	 * @param leaveDate
	 * @return
	 */
	public VehicleRegistrationCertificate createVehicleRegistrationCertificate(
			Vehicle vehicle, Human human, String registrationNumber,
			Date registrationDate, Date leaveDate) {
		VehicleRegistrationCertificate vehicleRegistrationCertificate = new VehicleRegistrationCertificate(
				vehicle, human, registrationNumber, registrationDate,
				leaveDate, this);
		return vehicleRegistrationCertificate;
	}

	/**
	 * Изменяет объект типа свидетельство о регистрации транспортного средства в
	 * соответствии с данными, указанными в параметрах и записывает информацию о
	 * нем в базу данных. <br/>
	 * Входными параметрами являются vehicleRegistrationSertificate, vehicle,
	 * human, registrationNumber, registrationDate, leaveDate, обозначающими
	 * соответственно свидетельство о регистрации, объект ''Автомобиль'', объект
	 * ''Человек'', регистрационный номер, дату регистрации, дату окончания
	 * регистрации.
	 * 
	 * @param vehicleRegistrationCertificate
	 * @param vehicle
	 * @param human
	 * @param registrationNumber
	 * @param registrationDate
	 * @param leaveDate
	 */
	public void updateVehicleRegistrationCertificate(
			VehicleRegistrationCertificate vehicleRegistrationCertificate,
			Vehicle vehicle, Human human, String registrationNumber,
			Date registrationDate, Date leaveDate) {
		vehicleRegistrationCertificate.setHuman(human);
		vehicleRegistrationCertificate.setLeaveDate(leaveDate);
		vehicleRegistrationCertificate.setRegistrationDate(registrationDate);
		vehicleRegistrationCertificate
				.setRegistrationNumber(registrationNumber);
		vehicleRegistrationCertificate.setVehicle(vehicle);
		vehicleRegistrationCertificate.setVehicleInspector(this);
		vehicleRegistrationCertificate.update();
	}

	/**
	 * Удаляет объект типа свидетельство о регистрации транспортного средства из
	 * базы данных.
	 * 
	 * @param vehicleRegistrationCertificate
	 */
	public void deleteVehicleRegistrationCertificate(
			VehicleRegistrationCertificate vehicleRegistrationCertificate) {
		vehicleRegistrationCertificate.delete();
	}

	@Override
	public void insert() {
		// TODO implement database insert operation
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public void update() {
		// TODO implement database update operation
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public void delete() {
		// TODO implement database delete operation
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public void select(int id) {
		// TODO implement database select operation
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public String toString() {
		// TODO implement string representation of the object
		throw new UnsupportedOperationException("not implemented");
	}

}
