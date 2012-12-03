package model;

import java.util.Date;

/**
 * Класс свидетельство о регистрации. <br/>
 * Содержит всю информацию о транспортном средстве с определенным
 * регистрационным номером, а также даты постановки транспортного средства на
 * регистрационный учет и его снятия. Является наследником класса DBObject.
 * Реализует добавление, удаление и исправление указанных данных в свидетельстве
 * о регистрации ТС, а также представление объекта в виде строки и поиск объекта
 * по id.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class VehicleRegistrationCertificate extends DBObject {

	/**
	 * 
	 */
	private Vehicle vehicle;

	/**
	 * 
	 */
	private Human human;

	/**
	 * 
	 */
	private String registrationNumber;

	/**
	 * 
	 */
	private Date registrationDate;

	/**
	 * 
	 */
	private Date leaveDate;

	/**
	 * 
	 */
	private VehicleInspector vehicleInspector;

	/**
	 * Конструктор по умолчанию для класса VehicleRegistrationSertificate. <br/>
	 * Создает экземпляр класса со стандартными значениями полей класса
	 * ''Свидетельство о регистрации ТС''.
	 */
	public VehicleRegistrationCertificate() {
		this.vehicle = new Vehicle();
		this.human = new Human();
		this.registrationNumber = "";
		this.registrationDate = new Date();
		this.leaveDate = new Date();
		this.vehicleInspector = new VehicleInspector();
	}

	/**
	 * Создает объект типа "Свидетельство о регистрации ТС". <br/>
	 * В параметрах передаются: параметры автомобиля, параметры владельца ТС,
	 * регистрационный номер ТС, дата регистрации, дата окончания строка
	 * регистрации, инспектор, зарегистрировавший ТС, обозначающиеся
	 * соответственно: vehicle, human, registrationNumber, registrationDate,
	 * leaveDate, vehicleInspector.
	 * 
	 * @param vehicle
	 * @param human
	 * @param registrationNumber
	 * @param registrationDate
	 * @param leaveDate
	 * @param vehicleInspector
	 */
	public VehicleRegistrationCertificate(Vehicle vehicle, Human human,
			String registrationNumber, Date registrationDate, Date leaveDate,
			VehicleInspector vehicleInspector) {
		this.vehicle = vehicle;
		this.human = human;
		this.registrationNumber = registrationNumber;
		this.registrationDate = registrationDate;
		this.leaveDate = leaveDate;
		this.vehicleInspector = vehicleInspector;
	}

	/**
	 * Конструктор копирования для класса VehicleRegistrationSertificate. <br/>
	 * Создает копию объекта VehicleRegistrationSertificate(объект с идентичными
	 * значениями параметров входного экземпляра класса
	 * VehicleRegistrationSertificate). Входным параметром является объект
	 * класса VehicleRegistrationSertificate.
	 * 
	 * @param vehicleRegistrationCertificate
	 */
	public VehicleRegistrationCertificate(
			VehicleRegistrationCertificate vehicleRegistrationCertificate) {
		this.vehicle = vehicleRegistrationCertificate.vehicle;
		this.human = vehicleRegistrationCertificate.human;
		this.registrationNumber = vehicleRegistrationCertificate.registrationNumber;
		this.registrationDate = vehicleRegistrationCertificate.registrationDate;
		this.leaveDate = vehicleRegistrationCertificate.leaveDate;
		this.vehicleInspector = vehicleRegistrationCertificate.vehicleInspector;
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

	/**
	 * Устанавливает регистрационный номер. <br/>
	 * Входящий параметр registrationNumber обозначает поле “Регистрационный
	 * номер ТС”.
	 * 
	 * @param registrationNumber
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * Возвращает регистрационный номер.
	 * 
	 * @return
	 */
	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	/**
	 * Устанавливает объект автомобиль, который соответствует данному
	 * свидетельству о регистрации. <br/>
	 * Входящий параметр vehicle обозначает поле “Транспортное средство”.
	 * 
	 * @param vehicle
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * Возвращает объект автомобиль, который соответствует данному свидетельству
	 * о регистрации.
	 * 
	 * @return
	 */
	public Vehicle getVehicle() {
		return this.vehicle;
	}

	/**
	 * Устанавливает владельца транспортного средства. <br/>
	 * Входящий параметр human обозначает поле “Владелец ТС”.
	 * 
	 * @param human
	 */
	public void setHuman(Human human) {
		this.human = human;
	}

	/**
	 * Возвращает владельца транспортного средства.
	 * 
	 * @return
	 */
	public Human getHuman() {
		return this.human;
	}

	/**
	 * Устанавливает инспектора оформившего транспортное средство. <br/>
	 * Входящий параметр vehicleInspector обозначает поле “Инспектор,
	 * зарегистрировавший ТС”.
	 * 
	 * @param vehicleInspector
	 */
	public void setVehicleInspector(VehicleInspector vehicleInspector) {
		this.vehicleInspector = vehicleInspector;
	}

	/**
	 * Возвращает инспектора, оформившего транспортное средство.
	 * 
	 * @return
	 */
	public VehicleInspector getVehicleInspector() {
		return this.vehicleInspector;
	}

	/**
	 * Возвращает дату постановки на учет.
	 * 
	 * @return
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * Устанавливает дату регистрации ТС. <br/>
	 * Входящий параметр date обозначает поле “Дата регистрации ТС”.
	 * 
	 * @param registrationDate
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * Возвращает дату снятия с учета.
	 * 
	 * @return
	 */
	public Date getLeaveDate() {
		return leaveDate;
	}

	/**
	 * Устанавливает дату снятия с учета. <br/>
	 * Входящий параметр date обозначает поле “Дата снятия ТС с учета”.
	 * 
	 * @param leaveDate
	 */
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

}
