package model;

import java.sql.Date;

/**
 * Класс транспортного средства. Содержит информацию о транспортном средстве. К
 * данной информации относится уникальный номер ТС, номер двигателя, цвет,
 * марка, год выпуска. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Так как транспортное средство, является объектом, хранящимся в базе данных, в
 * нашей системе, помимо основных свойств, присущих транспортному средству, ему
 * присвоен уникальный идентификатор или id. Этот id является полем базового
 * класса DBObect. <br/>
 * <br/>
 * Класс Vehicle характеризуется следующими полями: id, VIN, EIN, color, brand,
 * year <br/>
 * <ul>
 * <li>A(id) = Уникальный идентификатор</li>
 * <li>A(VIN) = Идентификационный номер транспортного средства</li>
 * <li>A(EIN) = Номер двигателя</li>
 * <li>A(color) = Цвет</li>
 * <li>A(brand) = Марка</li>
 * <li>A(year) = Год выпуска</li>
 * </ul>
 * <br/>
 * <br/>
 * Инвариант представления <br/>
 * <ul>
 * <li>id - неотрицательное целое число, уникальное в пределах таблицы БД</li>
 * <li>VIN - НЕ null и не пустая строка</li>
 * <li>EIN - НЕ null и не пустая строка</li>
 * <li>color - НЕ null и не пустая строка</li>
 * <li>brand - НЕ null и не пустая строка</li>
 * <li>year - НЕ null
 * </ul>
 * <br/>
 * <br/>
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class Vehicle extends DBObject {

	/**
	 * Идентификационный номер транспортного средства
	 */
	private String VIN;

	/**
	 * Номер двигателя
	 */
	private String EIN;

	/**
	 * Цвет
	 */
	private String color;

	/**
	 * Марка
	 */
	private String brand;

	/**
	 * Год выпуска
	 */
	private Date year;

	/**
	 * Конструктор по умолчанию для класса Vehicle. <br/>
	 * Создает экземпляр класса со стандартными значениями полей VIN, номер
	 * двигателя, цвет, марка транспортного средства, год выпуска.
	 */
	public Vehicle() {
		this.VIN = "";
		this.EIN = "";
		this.color = "";
		this.brand = "";
		this.year = new Date(0, 0, 0);
	}

	/**
	 * Создает объект соответствующий транспортному средству.
	 * 
	 * @param VIN
	 * @param EIN
	 * @param color
	 * @param brand
	 * @param year
	 */
	public Vehicle(String VIN, String EIN, String color, String brand, Date year) {
		this.VIN = VIN;
		this.EIN = EIN;
		this.color = color;
		this.brand = brand;
		this.year = year;
	}

	/**
	 * Конструктор копирования для класса Vehicle. <br/>
	 * Создает копию объекта Vehicle(объект с идентичными значениями параметров
	 * входного экземпляра класса Vehicle).
	 * 
	 * @param vehicle
	 */
	public Vehicle(Vehicle vehicle) {
		this.VIN = vehicle.VIN;
		this.EIN = vehicle.EIN;
		this.color = vehicle.color;
		this.brand = vehicle.brand;
		this.year = new Date(vehicle.year.getTime());
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
	 * Устанавливает VIN транспортного средства.
	 * 
	 * @param VIN
	 */
	public void setVIN(String VIN) {
		this.VIN = VIN;
	}

	/**
	 * Возвращает VIN транспортного средства.
	 * 
	 * @return
	 */
	public String getVIN() {
		return this.VIN;
	}

	/**
	 * Устанавливает номер двигателя транспортного средства.
	 * 
	 * @param EIN
	 */
	public void setEIN(String EIN) {
		this.EIN = EIN;
	}

	/**
	 * Возвращает номер двигателя транспортного средства.
	 * 
	 * @return
	 */
	public String getEIN() {
		return this.EIN;
	}

	/**
	 * Устанавливает указанный в параметре цвет автомобиля.
	 * 
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Возвращает цвет транспортного средства.
	 * 
	 * @return
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * Устанавливает марку транспортного средства.
	 * 
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Возвращает марку транспортного средства.
	 * 
	 * @return
	 */
	public String getBrand() {
		return this.brand;
	}

	/**
	 * Возвращает год выпуска транспортного средства.
	 * 
	 * @return
	 */
	public Date getYear() {
		return year;
	}

	/**
	 * Устанавливает год выпуска транспортного средства.
	 * 
	 * @param year
	 */
	public void setYear(Date year) {
		this.year = year;
	}

}
