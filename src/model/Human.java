package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
		this.id = human.id;
		this.name = human.name;
		this.passportNumber = human.passportNumber;
		this.address = human.address;
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
								"insert into gibdd_system_db.humans values (default, ?, ?, ?)",
								Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, this.name);
				stmt.setString(2, this.passportNumber);
				stmt.setString(3, this.address);
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
			Human tmp = new Human(this);
			tmp.select(this.id);
			String oldRepr = tmp.toString();

			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("update gibdd_system_db.humans set"
								+ " name=?," + " passport_number=?, "
								+ "address=? where human_id = "
								+ Integer.toString(this.id));
				stmt.setString(1, this.name);
				stmt.setString(2, this.passportNumber);
				stmt.setString(3, this.address);
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
						.prepareStatement("delete from gibdd_system_db.humans where human_id = "
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
						.prepareStatement("select human_id, name, passport_number, address"
								+ " from gibdd_system_db.humans where human_id = "
								+ Integer.toString(id));
				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					this.id = res.getInt(1);
					this.name = res.getString(2);
					this.passportNumber = res.getString(3);
					this.address = res.getString(4);
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
		StringBuilder ret = new StringBuilder();
		ret.append("id = " + Integer.toString(this.id) + ", ");
		ret.append("name = " + this.name + ", ");
		ret.append("passportNumber = " + this.passportNumber + ", ");
		ret.append("address = " + this.address);
		return ret.toString();
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
