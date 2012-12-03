package model;

/**
 * Человек. <br/>
 * Базовый класс, включающий основные свойства, присущие всем участникам
 * дорожного движения. Содержит информацию о ФИО, серии/номере паспорта, адресе
 * человека. Является наследником класса DBObject. Реализует добавление,
 * удаление и исправление указанных данных о человеке, а также представление
 * объекта в виде строки и поиск объекта по id.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class Human extends DBObject {

	/**
	 * 
	 */
	protected String name;

	/**
	 * 
	 */
	protected String passportNumber;

	/**
	 * 
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
	 * Создает экземпляр класса, включающий основные свойства человека. <br/>
	 * Входными параметрами являются name, passportNumber, adress, обозначающими
	 * соответственно для данного объекта “ФИО”, “Серия/номер паспорта”,
	 * “Адрес”.
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
	 * входного экземпляра класса Human). Входным параметром является объект
	 * класса Human.
	 * 
	 * @param human
	 */
	public Human(Human human) {
		super();
		this.name = human.name;
		this.passportNumber = human.passportNumber;
		this.address = human.address;
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
	 * Возвращает значение поля “ФИО” для данного объекта.
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Устанавливает значение поля “ФИО” для данного объекта. <br/>
	 * Входными данными является параметр name, обозначающий ФИО для данного
	 * объекта.
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
	 * Входящий параметр passportNumber обозначает поле “Серия/номер паспорта”.
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
	 * Входящий параметр adress обозначает поле “Адрес”.
	 * 
	 * @param adress
	 */
	public void setAddress(String adress) {
		this.address = adress;
	}

}
