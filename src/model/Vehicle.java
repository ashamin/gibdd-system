package model;

import java.util.Date;

/**
 * Класс транспортного средства. <br/>
 * Содержит информацию о характеристиках транспортного средства, а также его
 * приметы и уникальные идентифицирующие номера. Реализует добавление, удаление
 * и исправление указанных данных об ТС, а также представление объекта в виде
 * строки и поиск объекта по id.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class Vehicle extends DBObject {

	/**
	 * 
	 */
	private String VIN;

	/**
	 * 
	 */
	private String EIN;

	/**
	 * 
	 */
	private String color;

	/**
	 * 
	 */
	private String brand;

	/**
	 * 
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
		this.year = new Date();
	}

	/**
	 * Создает объект соответствующий транспортному средству. <br/>
	 * Входными параметрами являются VIN, EIN, color, brand, year, обозначающими
	 * соответственно для данного объекта VIN, номер двигателя, цвет, марку
	 * транспортного средства, год выпуска.
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
	 * входного экземпляра класса Vehicle). Входным параметром является объект
	 * класса Vehicle.
	 * 
	 * @param vehicle
	 */
	public Vehicle(Vehicle vehicle) {
		this.VIN = vehicle.VIN;
		this.EIN = vehicle.EIN;
		this.color = vehicle.color;
		this.brand = vehicle.brand;
		this.year = vehicle.year;
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
	 * Устанавливает VIN транспортного средства. <br/>
	 * Входящий параметр VIN обозначает поле “VIN автомобиля”.
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
	 * Устанавливает номер двигателя транспортного средства. <br/>
	 * Входящий параметр EIN обозначает поле “Номер двигателя ТС”.
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
	 * Устанавливает указанный в параметре цвет автомобиля. <br/>
	 * Входящий параметр color обозначает поле “Цвет автомобиля”.
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
	 * Устанавливает марку транспортного средства. <br/>
	 * Входящий параметр brand обозначает поле “Марка ТС”.
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
	 * Устанавливает год выпуска транспортного средства. <br/>
	 * Входящий параметр year обозначает поле “Год выпуска ТС”.
	 * 
	 * @param year
	 */
	public void setYear(Date year) {
		this.year = year;
	}

}
