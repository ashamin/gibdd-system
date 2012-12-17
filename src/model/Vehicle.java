package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
		try {
			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement(
								"insert into gibdd_system_db.vehicles "
										+ "(vehicle_id, VIN, EIN, color, year, brand_id) "
										+ "values (default, ?, ?, ?, ?, ?)",
								Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, this.VIN);
				stmt.setString(2, this.EIN);
				stmt.setString(3, this.color);
				stmt.setDate(4, this.year);

				/*
				 * выбираем индекс марки автомобиля из таблицы Brands
				 */
				PreparedStatement stmtSel = conn
						.prepareStatement("select brand_id from gibdd_system_db.brands "
								+ "where brand = ?");
				stmtSel.setString(1, this.brand);
				ResultSet res = stmtSel.executeQuery();
				while (res.next()) {
					stmt.setInt(5, res.getInt(1));
				}

				stmt.executeUpdate();

				ResultSet key = stmt.getGeneratedKeys();
				key.next();
				this.id = key.getInt(1);

				System.out.println("...Row with string representation \n\t"
						+ this.toString() + "\nwas added");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		try {
			Vehicle tmp = new Vehicle(this);
			tmp.select(this.id);
			String oldRepr = tmp.toString();

			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("update gibdd_system_db.vehicles set "
								+ "VIN=?, EIN=?, "
								+ "color=?, year=?, brand_id=? "
								+ "where vehicle_id = "
								+ Integer.toString(this.id));
				stmt.setString(1, this.VIN);
				stmt.setString(2, this.EIN);
				stmt.setString(3, this.color);
				stmt.setDate(4, this.year);

				/*
				 * выбираем индекс марки автомобиля из таблицы Brands
				 */
				PreparedStatement stmtSel = conn
						.prepareStatement("select brand_id from gibdd_system_db.brands "
								+ "where brand = ?");
				stmtSel.setString(1, this.brand);
				ResultSet res = stmtSel.executeQuery();
				while (res.next()) {
					stmt.setInt(5, res.getInt(1));
				}

				stmt.executeUpdate();

				System.out
						.println("...Row in base with string representation \n\t"
								+ oldRepr
								+ "\nwas updated to\n\t"
								+ this.toString());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		try {
			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("delete from gibdd_system_db.vehicles where vehicle_id = "
								+ Integer.toString(this.id));
				stmt.executeUpdate();

				System.out.println("...Row with string representation \n\t"
						+ this.toString() + "\nwas deleted from base");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void select(int id) {
		try {
			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("select vehicles.vehicle_id, vehicles.VIN, vehicles.EIN, "
								+ "vehicles.color, vehicles.year, brands.brand "
								+ "from gibdd_system_db.vehicles, gibdd_system_db.brands "
								+ "where vehicle_id = "
								+ Integer.toString(id)
								+ " and vehicles.brand_id = brands.brand_id");
				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					this.id = res.getInt(1);
					this.VIN = res.getString(2);
					this.EIN = res.getString(3);
					this.color = res.getString(4);
					this.year = res.getDate(5);
					this.brand = res.getString(6);
				}

				System.out.println("...Row with string representation \n\t"
						+ this.toString() + "\nwas selected from base");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id = " + this.id + ", ");
		sb.append("VIN = " + this.VIN + ", ");
		sb.append("EIN = " + this.EIN + ", ");
		sb.append("color = " + this.color + ", ");
		sb.append("year = " + this.year + ", ");
		sb.append("brand = " + this.brand);
		return sb.toString();
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
