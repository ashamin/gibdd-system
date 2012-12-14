package model;

import java.sql.Date;

/**
 * VehicleRegistrationSertificate Класс свидетельство о регистрации. Содержит
 * всю информацию о транспортном средстве, его владельце, а также даты
 * постановки транспортного средства на регистрационный учет и его снятия.
 * Является наследником класса DBObject. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Так как свидетельство о регистрации ТС, является объектом, хранящимся в базе
 * данных, в нашей системе, помимо основных свойств, присущих свидетельству о
 * регистрации, ему присвоен уникальный идентификатор или id. Этот id является
 * полем базового класса DBObect. Информация о транспортном средстве и его
 * владельце содержится в классе, как ссылки на объекты соответствующие
 * транспортному средству и владельцу данного транспортного средства. <br/>
 * <br/>
 * Класс VehicleRegistrationSertificate характеризуется следующими полями: id,
 * vehicle, human, registrationDate, leaveDate, vehicleInspector <br/>
 * <ul>
 * <li>A(id) = Уникальный идентификатор</li>
 * <li>A(vehicle) = Ссылка на транспортное средство</li>
 * <li>A(human) = Ссылка на человека</li>
 * <li>A(registrationDate) = Дата регистрации</li>
 * <li>A(leaveDate) = Дата снятия с учета</li>
 * <li>A(vehicleInspector) = Ссылка на инспектора</li>
 * </ul>
 * <br/>
 * <br/>
 * Инвариант представления <br/>
 * <ul>
 * <li>id - неотрицательное целое число, уникальное в пределах таблицы БД</li>
 * <li>vehicle - НЕ null</li>
 * <li>human - НЕ null</li>
 * <li>registrationDate - НЕ null</li>
 * <li>leaveDate - НЕ null</li>
 * <li>vehicleInspector - НЕ null</li>
 * </ul>
 * <br/>
 * <br/>
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class VehicleRegistrationCertificate extends DBObject {

	/**
	 * Транспортное средство
	 */
	private Vehicle vehicle;

	/**
	 * Человек
	 */
	private Human human;

	/**
	 * Регистрационный номер
	 */
	private String registrationNumber;

	/**
	 * Дата регистрации
	 */
	private Date registrationDate;

	/**
	 * Дата снятия с учета
	 */
	private Date leaveDate;

	/**
	 * Инспектор
	 */
	private VehicleInspector vehicleInspector;

	/**
	 * Конструктор по умолчанию для класса VehicleRegistrationSertificate. <br/>
	 * Создает экземпляр класса со стандартными значениями полей класса
	 * 'Свидетельство о регистрации ТС'.
	 */
	public VehicleRegistrationCertificate() {
		this.vehicle = new Vehicle();
		this.human = new Human();
		this.registrationNumber = "";
		this.registrationDate = new Date(0, 0, 0);
		this.leaveDate = new Date(0, 0, 0);
		this.vehicleInspector = new VehicleInspector();
	}

	/**
	 * Создает объект типа "Свидетельство о регистрации ТС".
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
	 * VehicleRegistrationSertificate).
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

	/**
	 * Переопределяются методы базового класса
	 */
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
	 * Устанавливает регистрационный номер.
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
	 * Устанавливает объект автомобиль.
	 * 
	 * @param vehicle
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * Возвращает объект автомобиль.
	 * 
	 * @return
	 */
	public Vehicle getVehicle() {
		return this.vehicle;
	}

	/**
	 * Устанавливает владельца транспортного средства.
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
	 * Устанавливает инспектора оформившего транспортное средство.
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
	 * Устанавливает дату регистрации ТС.
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
	 * Устанавливает дату снятия с учета.
	 * 
	 * @param leaveDate
	 */
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

}
