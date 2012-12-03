package model;

import java.util.Date;

/**
 * Класс водительское удостоверение. <br/>
 * Содержит всю информацию о владельце удостоверения и о самом удостоверении.
 * Является наследником класса DBObject. Реализует добавление, удаление и
 * исправление указанных данных о водительском удостоверении, а также
 * представление объекта в виде строки и поиск объекта по id.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class DriverLicense extends DBObject {

	/**
	 * 
	 */
	private Human human;

	/**
	 * 
	 */
	private DriverLicenseInspector inspector;

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
	private String categories;

	/**
	 * Конструктор по умолчанию для класса DriverLicense. <br/>
	 * Создает экземпляр класса со стандартными значениями полей владелец
	 * удостоверения, инспектор, выдавший удостоверение, категории, дата
	 * получения удостоверения, дата истечения срока удостоверения.
	 */
	public DriverLicense() {
		this.human = new Human();
		this.inspector = new DriverLicenseInspector();
		this.registrationDate = new Date();
		this.leaveDate = new Date();
		this.categories = "";
	}

	/**
	 * Создает объект типа водительское удостоверение. <br/>
	 * Входными параметрами являются human, inspector, registrationDate,
	 * leaveDate, categories, обозначающими соответственно для данного объекта
	 * владельца удостоверения, инспектора, выдавшего удостоверение, дату
	 * получения удостоверения, дату истечения срока удостоверения, категории.
	 * 
	 * @param human
	 * @param inspector
	 * @param registrationDate
	 * @param leaveDate
	 * @param categories
	 */
	public DriverLicense(Human human, DriverLicenseInspector inspector,
			Date registrationDate, Date leaveDate, String categories) {
		this.human = human;
		this.inspector = inspector;
		this.registrationDate = registrationDate;
		this.leaveDate = leaveDate;
		this.categories = categories;
	}

	/**
	 * Конструктор копирования для класса DriverLicense. <br/>
	 * Создает копию объекта DriverLicense(объект с идентичными значениями
	 * параметров входного экземпляра класса DriverLicense). Входным параметром
	 * является объект класса DriverLicense.
	 * 
	 * @param driverLicense
	 */
	public DriverLicense(DriverLicense driverLicense) {
		this.human = driverLicense.human;
		this.inspector = driverLicense.inspector;
		this.registrationDate = driverLicense.registrationDate;
		this.leaveDate = driverLicense.leaveDate;
		this.categories = driverLicense.categories;
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
	 * Устанавливает инспектора выдавшего удостоверение на право управления
	 * транспортным средством. <br/>
	 * Входящий параметр inspector обозначает поле “Инспектор, выдавший права”.
	 * 
	 * @param value
	 */
	public void setInspector(DriverLicenseInspector value) {
		this.inspector = value;
	}

	/**
	 * Возвращает инспектора выдавшего удостоверение на право управления
	 * транспортным средством.
	 * 
	 * @return
	 */
	public DriverLicenseInspector getInspector() {
		return this.inspector;
	}

	/**
	 * Устанавливает обладателя водительского удостоверения. <br/>
	 * Входящий параметр human обозначает поле “Человек, обладающий
	 * водительскими правами”.
	 * 
	 * @param human
	 */
	public void setHuman(Human human) {
		this.human = human;
	}

	/**
	 * Возвращает категории транспортных средств, к управлению которыми допущен
	 * владелец водительского удостоверения.
	 * 
	 * @return
	 */
	public Human getHuman() {
		return this.human;
	}

	/**
	 * Устанавливает категории транспортных средств, к управлению которыми
	 * допущен владелец водительского удостоверения. <br/>
	 * Входящий параметр categories обозначает поле “Категории”.
	 * 
	 * @param categories
	 */
	public void setCategories(String categories) {
		this.categories = categories;
	}

	/**
	 * Возвращает категории транспортных средств, к управлению которыми допущен
	 * владелец водительского удостоверения.
	 * 
	 * @return
	 */
	public String getCategories() {
		return this.categories;
	}

	/**
	 * Возвращает дату получения водительского удостоверения.
	 * 
	 * @return
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * Устанавливает дату получения водительского удостоверения. <br/>
	 * Входящий параметр registrationDate обозначает поле “Дата выдачи
	 * водительского удостоверения”.
	 * 
	 * @param registrationDate
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * Возвращает дату истечения срока действия водительского удостоверения.
	 * 
	 * @return
	 */
	public Date getLeaveDate() {
		return leaveDate;
	}

	/**
	 * Устанавливает дату истечения срока действия водительского удостоверения. <br/>
	 * Входящий параметр leaveDate обозначает поле “Дата истечения срока
	 * действия водительского удостоверения”.
	 * 
	 * @param leaveDate
	 */
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

}
