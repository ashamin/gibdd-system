package model;

import java.util.Date;

/**
 * Класс описывает параметры инспектора, выдающего водительское удостоверение. <br/>
 * Является наследником класса Inspector. Реализует добавление, удаление и
 * исправление указанных данных об инспекторе, выдающем водительские
 * удостоверения, а также представление объекта в виде строки и поиск объекта по
 * id.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class DriverLicenseInspector extends Inspector {

	/**
	 * Конструктор по умолчанию для класса DriverLicenseInspector. <br/>
	 * Создает экземпляр класса со стандартными значениями полей “ФИО”,
	 * “Серия/номер паспорта”, “Адрес”, “Звание”, “Должность”, “Логин”,
	 * “Пароль”.
	 */
	public DriverLicenseInspector() {
		super();
	}

	/**
	 * Создает экземпляр класса DriverLicenseInspector. <br/>
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
	public DriverLicenseInspector(String name, String passportNumber,
			String address, String rank, String post, String login,
			String password) {
		super(name, passportNumber, address, rank, post, login, password);
	}

	/**
	 * Конструктор копирования для класса DriverLicenseInspector. <br/>
	 * Создает копию объекта DriverLicenseInspector(объект с идентичными
	 * значениями параметров входного экземпляра класса DriverLicenseInspector).
	 * Входным параметром является объект класса DriverLicenseInspector.
	 * 
	 * @param inspector
	 */
	public DriverLicenseInspector(DriverLicenseInspector inspector) {
		super((Inspector) inspector);
	}

	/**
	 * Заполняет объект типа водительское удостоверение в соответствии с
	 * данными, указанными в параметрах и записывает информацию о нем в базу
	 * данных. <br/>
	 * Входными параметрами являются human, registrationDate, leaveDate,
	 * categories обозначающими соответственно объект ''Человек'', дату выдачи
	 * водительского удостоверения, дату окончания действия водительского
	 * удостоверения и категории, на которые открыто водительское удостоверение.
	 * 
	 * @param human
	 * @param registrationDate
	 * @param leaveDate
	 * @param categories
	 * @return
	 */
	public DriverLicense createDriverLicense(Human human,
			Date registrationDate, Date leaveDate, String categories) {
		DriverLicense driverLicense = new DriverLicense(human, this,
				registrationDate, leaveDate, categories);
		driverLicense.insert();
		return driverLicense;
	}

	/**
	 * Изменяет объект типа водительское удостоверение в соответствии с данными,
	 * указанными в параметрах и записывает информацию о нем в базу данных.<br/>
	 * Входными параметрами являются driverLicense, human, registrationDate,
	 * leaveDate, categories обозначающими соответственно изменяемое
	 * водительское удостоверение, объект ''Человек'', дату выдачи водительского
	 * удостоверения, дату окончания действия водительского удостоверения и
	 * категории, на которые открыто водительское удостоверение.
	 * 
	 * @param driverLicense
	 * @param human
	 * @param registrationDate
	 * @param leaveDate
	 * @param categories
	 */
	public void updateDriverLicense(DriverLicense driverLicense, Human human,
			Date registrationDate, Date leaveDate, String categories) {
		driverLicense.setHuman(human);
		driverLicense.setRegistrationDate(registrationDate);
		driverLicense.setLeaveDate(leaveDate);
		driverLicense.setCategories(categories);
		driverLicense.setInspector(this);
		driverLicense.update();
	}

	/**
	 * Удаляет объект типа водительское удостоверение из базы данных.
	 * 
	 * @param driverLicense
	 */
	public void deleteDriverLicense(DriverLicense driverLicense) {
		driverLicense.delete();
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
