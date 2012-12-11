package model;

/**
 * Human Класс, включающий основные свойства, присущие всем участникам дорожного
 * движения. Содержит информацию о ФИО, серии/номере паспорта, адресе человека.
 * Является наследником класса DBObject. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Так как человек, является объектом, хранящимся в базе данных, в нашей
 * системе, помимо основных свойств, присущих человеку, ему присвоен уникальный
 * идентификатор или id. Этот id является полем базового класса DBObect.
 * 
 * Класс Human характеризуется следующими полями: id, name, passportNumber,
 * address <br/>
 * <ul>
 * <li>A(id) = Уникальный идентификатор
 * <li>A(name) = ФИО
 * <li>A(passportNumber) = Номер паспорта
 * <li>A(address) = Адрес
 * </ul>
 * <br/>
 * <br/>
 * Инвариант представления <br/>
 * <ul>
 * <li>id - неотрицательное целое число, уникальное в пределах таблицы БД
 * <li>name - НЕ null и не пустая строка
 * <li>passportNumber - НЕ null и не пустая строка
 * <li>Address - НЕ null
 * </ul>
 * <br/>
 * <br/>
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class Human extends DBObject {

	/**
	 * ФИО
	 */
	protected String name;

	/**
	 * Номер паспорта
	 */
	protected String passportNumber;

	/**
	 * Адрес
	 */
	protected String address;

	/**
	 * Конструктор по умолчанию для класса Human. <br/>
	 * Создает экземпляр класса со стандартными значениями полей “ФИО”,
	 * “Серия/номер паспорта”, “Адрес”.
	 */
	public Human() {
		super();
		this.name = "";
		this.passportNumber = "";
		this.address = "";
	}

	/**
	 * Создает экземпляр класса, включающий основные свойства человека.
	 * 
	 * @param name
	 * @param passportNumber
	 * @param address
	 */
	public Human(String name, String passportNumber, String address) {
		super();
		this.name = name;
		this.passportNumber = passportNumber;
		this.address = address;
	}

	/**
	 * Конструктор копирования для класса Human. <br/>
	 * Создает копию объекта Human(объект с идентичными значениями параметров
	 * входного экземпляра класса Human).
	 * 
	 * @param human
	 */
	public Human(Human human) {
		super();
		this.name = human.name;
		this.passportNumber = human.passportNumber;
		this.address = human.address;
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
	 * Возвращает значение поля “ФИО” для данного объекта.
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Устанавливает значение поля “ФИО” для данного объекта. <br/>
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Возвращает значение поля “Серия/номер паспорта” для данного объекта.
	 * 
	 * @return
	 */
	public String getPassportNumber() {
		return this.passportNumber;
	}

	/**
	 * Устанавливает значение поля “Серия/номер паспорта” для данного объекта. <br/>
	 * 
	 * @param value
	 */
	public void setPassportNumber(String pasportNumber) {
		this.passportNumber = pasportNumber;
	}

	/**
	 * Возвращает значение поля “Адрес” для данного объекта.
	 * 
	 * @return
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Устанавливает значение поля “Адрес” для данного объекта. <br/>
	 * 
	 * @param adress
	 */
	public void setAddress(String adress) {
		this.address = adress;
	}

}
