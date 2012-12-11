package model;

import java.util.Date;

/**
 * DriverLicenseInspector Класс описывает параметры инспектора, оформляющего ТС.
 * Является наследником класса Inspector. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Так как инспектор выдающий права, является объектом, хранящимся в базе
 * данных, в нашей системе, помимо основных свойств, присущих инспектору
 * выдающем права, ему присвоен уникальный идентификатор или id. Этот id
 * является полем базового класса DBObect. Класс DriverLicenseInspector
 * наследуется от класса Human. Таким образом объект инспектор, определяется в
 * том числе и полями класса Human: name, passportNumber, address. Также класс
 * DriverLicenseInspector наследуется от класса Inspector. Таким образом объект
 * инспектор, определяется в том числе и полями класса Inspector: rank, post,
 * login, password <br/>
 * <br/>
 * Класс DriverLicenseInspector характеризуется следующими полями: id, name,
 * passportNumber, address, rank, post, login, password
 * <ul>
 * <li>A(id) = Уникальный идентификатор</li>
 * <li>A(name) = ФИО</li>
 * <li>A(passportNumber) = Номер паспорта</li>
 * <li>A(address) = Адрес</li>
 * <li>A(rank) = Звание</li>
 * <li>A(post) = Должность</li>
 * <li>A(login) = Логин</li>
 * <li>A(password) = Пароль</li>
 * </ul>
 * <br/>
 * <br/>
 * Инвариант представления <br/>
 * <ul>
 * <li>id - неотрицательное целое число, уникальное в пределах таблицы БД</li>
 * <li>name - НЕ null и не пустая строка</li>
 * <li>passportNumber - НЕ null и не пустая строка</li>
 * <li>Address - НЕ null</li>
 * <li>rank - НЕ null и не пустая строка</li>
 * <li>post - НЕ null и не пустая строка</li>
 * <li>login - НЕ null и не пустая строка</li>
 * <li>password - НЕ null и не пустая строка</li>
 * </ul>
 * <br/>
 * <br/>
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
	 * Создает экземпляр класса DriverLicenseInspector.
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
	 * 
	 * @param inspector
	 */
	public DriverLicenseInspector(DriverLicenseInspector inspector) {
		super((Inspector) inspector);
	}

	/**
	 * Заполняет объект типа водительское удостоверение в соответствии с
	 * данными. <br/>
	 * Метод создает объект класса DriverLicense с заданными параметрами, затем
	 * записывает его базу данных (вызывает метод insert() созданного объекта) и
	 * возвращает его.
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
	 * Изменяет объект типа водительское удостоверение. <br/>
	 * Метод изменяет значение полей объекта класса DriverLicense на
	 * соответствующие значения заданные в параметрах, затем обновляет
	 * представление объекта в базе данных (вызывает метод update() для
	 * заданного объекта).
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
	 * Удаляет объект типа водительское удостоверение из базы данных. <br/>
	 * Метод удаляет представление объекта класса DriverLicense из базы данных
	 * (вызывает метод delete() для заданного объекта).
	 * 
	 * @param driverLicense
	 */
	public void deleteDriverLicense(DriverLicense driverLicense) {
		driverLicense.delete();
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

}
