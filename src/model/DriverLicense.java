package model;

import java.util.Date;

/**
 * DriverLicense Класс водительское удостоверение. Содержит всю информацию о
 * владельце удостоверения, дата получения прав, дата истечения срока действия
 * прав, категории ТС, к управлению которыми допущен владелец прав, и информацию
 * об инспекторе, выдавшем права. Является наследником класса DBObject. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Так как водительское удостоверение, является объектом, хранящимся в базе
 * данных, в нашей системе, помимо основных свойств, присущих водительскому
 * удостоверению, ему присвоен уникальный идентификатор или id. Этот id является
 * полем базового класса DBObect. Информация о человеке и инспекторе, выдавшем
 * водительское удостоверение, содержится в классе, как ссылки на объекты
 * соответствующие человеку - владельцу прав и инспектору, который выдал эти
 * права.<br/>
 * <br/>
 * Класс DriverLicense характеризуется следующими полями: id, human, inspector,
 * registrationDate, leaveDate, categories <br/>
 * <ul>
 * <li>A(id) = Уникальный идентификатор</li>
 * <li>A(human) = Ссылка на человека</li>
 * <li>A(inspector) = Ссылка на инспектора</li>
 * <li>A(registrationDate) = Ссылка на дату регистрации</li>
 * <li>A(leaveDate) = Ссылка на дату истечения срока действия прав</li>
 * <li>A(categories) = Категории ТС</li>
 * </ul>
 * <br/>
 * <br/>
 * Инвариант представления <br/>
 * <ul>
 * <li>id - неотрицательное целое число, уникальное в пределах таблицы БД</li>
 * <li>human - НЕ null</li>
 * <li>inspector - НЕ null</li>
 * <li>registrationDate - НЕ null</li>
 * <li>leaveDate - НЕ null</li>
 * <li>categories - НЕ null и не пустая строка</li>
 * </ul>
 * <br/>
 * <br/>
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class DriverLicense extends DBObject {

	/**
	 * Человек
	 */
	private Human human;

	/**
	 * Инспектор
	 */
	private DriverLicenseInspector inspector;

	/**
	 * Дата регистрации
	 */
	private Date registrationDate;

	/**
	 * Дата истечения срока действия прав
	 */
	private Date leaveDate;

	/**
	 * Категории ТС
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
	 * Создает объект типа водительское удостоверение.
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
	 * параметров входного экземпляра класса DriverLicense).
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
	 * Устанавливает инспектора, выдавшего удостоверение на право управления
	 * транспортным средством.
	 * 
	 * @param value
	 */
	public void setInspector(DriverLicenseInspector value) {
		this.inspector = value;
	}

	/**
	 * Возвращает инспектора, выдавшего удостоверение на право управления
	 * транспортным средством.
	 * 
	 * @return
	 */
	public DriverLicenseInspector getInspector() {
		return this.inspector;
	}

	/**
	 * Устанавливает обладателя водительского удостоверения.
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
	 * допущен владелец водительского удостоверения.
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
	 * Устанавливает дату получения водительского удостоверения.
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
	 * Устанавливает дату истечения срока действия водительского удостоверения.
	 * 
	 * @param leaveDate
	 */
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

}
