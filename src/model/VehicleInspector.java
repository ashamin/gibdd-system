﻿package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

/**
 * VehicleInspector Класс описывает параметры инспектора, выдающего права.
 * Является наследником класса Inspector. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Так как инспектор оформляющий ТС, является объектом, хранящимся в базе
 * данных, в нашей системе, помимо основных свойств, присущих инспектору
 * оформляющий ТС, ему присвоен уникальный идентификатор или id. Этот id
 * является полем базового класса DBObect. Класс VehicleInspector наследуется от
 * класса Human. Таким образом объект инспектор, определяется в том числе и
 * полями класса Human: name, passportNumber, address. Также класс
 * VehicleInspector наследуется от класса Inspector. Таким образом объект
 * инспектор, определяется в том числе и полями класса Inspector: rank, post,
 * login, password <br/>
 * <br/>
 * Класс VehicleInspector характеризуется следующими полями: id, name,
 * passportNumber, address, rank, post, login, password <br/>
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
public class VehicleInspector extends Inspector {

	/**
	 * Конструктор по умолчанию для класса VehicleInspector. <br/>
	 * Создает экземпляр класса со стандартными значениями полей “ФИО”,
	 * “Серия/номер паспорта”, “Адрес”, “Звание”, “Должность”, “Логин”,
	 * “Пароль”.
	 */
	public VehicleInspector() {
		super();
	}

	/**
	 * Создает экземпляр класса VehicleInspector.
	 * 
	 * @param name
	 * @param passportNumber
	 * @param address
	 * @param rank
	 * @param post
	 * @param login
	 * @param password
	 */
	public VehicleInspector(String name, String passportNumber, String address,
			String rank, String post, String login, String password) {
		super(name, passportNumber, address, rank, post, login, password);
	}

	/**
	 * Конструктор копирования для класса VehicleInspector. <br/>
	 * Создает копию объекта VehicleInspector(объект с идентичными значениями
	 * параметров входного экземпляра класса VehicleInspector).
	 * 
	 * @param inspector
	 */
	public VehicleInspector(VehicleInspector inspector) {
		super((Inspector) inspector);
	}

	/**
	 * Заполняет объект типа свидетельство о регистрации транспортного средства. <br/>
	 * Метод создает объект класса VehicleRegistrationCertificate с заданными
	 * параметрами, затем записывает его базу данных (вызывает метод insert() у
	 * созданного объекта) и возвращает его.
	 * 
	 * @param vehicle
	 * @param human
	 * @param registrationNumber
	 * @param registrationDate
	 * @param leaveDate
	 * @return
	 */
	public VehicleRegistrationCertificate createVehicleRegistrationCertificate(
			Vehicle vehicle, Human human, String registrationNumber,
			Date registrationDate, Date leaveDate) {
		VehicleRegistrationCertificate vehicleRegistrationCertificate = new VehicleRegistrationCertificate(
				vehicle, human, registrationNumber, registrationDate,
				leaveDate, this);
		return vehicleRegistrationCertificate;
	}

	/**
	 * Изменяет объект типа свидетельство о регистрации транспортного средства. <br/>
	 * Метод изменяет значение полей объекта класса
	 * VehicleRegistrationCertificate на соответствующие значения заданные в
	 * параметрах, затем обновляет представление объекта в базе данных (вызывает
	 * метод update() для заданного объекта).
	 * 
	 * @param vehicleRegistrationCertificate
	 * @param vehicle
	 * @param human
	 * @param registrationNumber
	 * @param registrationDate
	 * @param leaveDate
	 */
	public void updateVehicleRegistrationCertificate(
			VehicleRegistrationCertificate vehicleRegistrationCertificate,
			Vehicle vehicle, Human human, String registrationNumber,
			Date registrationDate, Date leaveDate) {
		vehicleRegistrationCertificate.setHuman(human);
		vehicleRegistrationCertificate.setLeaveDate(leaveDate);
		vehicleRegistrationCertificate.setRegistrationDate(registrationDate);
		vehicleRegistrationCertificate
				.setRegistrationNumber(registrationNumber);
		vehicleRegistrationCertificate.setVehicle(vehicle);
		vehicleRegistrationCertificate.setVehicleInspector(this);
		vehicleRegistrationCertificate.update();
	}

	/**
	 * Удаляет объект типа свидетельство о регистрации транспортного средства из
	 * БД. <br/>
	 * Метод удаляет представление объекта класса VehicleRegistrationCertificate
	 * из базы данных (вызывает метод delete() для заданного объекта).
	 * 
	 * @param vehicleRegistrationCertificate
	 */
	public void deleteVehicleRegistrationCertificate(
			VehicleRegistrationCertificate vehicleRegistrationCertificate) {
		vehicleRegistrationCertificate.delete();
	}

	/**
	 * Переопределяются методы базового класса
	 */
	@Override
	public void insert() {
		super.insert();
		try {
			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement(
								"insert into gibdd_system_db.vehicle_inspectors (vehicle_inspector_id, inspector_id)"
										+ " values (default, ?)",
								Statement.RETURN_GENERATED_KEYS);
				stmt.setInt(1, this.id);

				stmt.executeUpdate();

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
		super.update();
	}

	@Override
	public void delete() {
		try {
			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("delete from gibdd_system_db.vehicle_inspectors where inspector_id = "
								+ Integer.toString(this.id));

				stmt.executeUpdate();

				super.delete();

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

	/**
	 * Возвращает значение первичного ключа для инспектора, из таблицы
	 * duty_inspectors
	 * 
	 * @return первичный ключ
	 */
	public int getBaseId() {
		int bid = 0;
		try {
			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("select vehicle_inspector_id "
								+ "from gibdd_system_db.vehicle_inspectors where inspector_id = "
								+ Integer.toString(this.id));
				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					bid = res.getInt(1);
				}

				/*
				 * System.out.println("...Row with string representation \n\t" +
				 * this.toString() + "\nwas selected from base");
				 */

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bid;
	}

	@Override
	public void select(int id) {
		super.select(id);
	}

	@Override
	public void select(String login, String password) {
		try {
			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("select humans.name, humans.passport_number, "
								+ "humans.address, "
								+ "inspectors.inspector_id, inspectors.login, inspectors.password, "
								+ "ranks.rank, posts.post "
								+ "from gibdd_system_db.humans, gibdd_system_db.inspectors, "
								+ "gibdd_system_db.ranks, gibdd_system_db.posts, gibdd_system_db.vehicle_inspectors "
								+ "where "
								+ "inspectors.login = ? and inspectors.password = ?"
								+ " and "
								+ "humans.human_id = inspectors.human_id and "
								+ "ranks.rank_id = inspectors.rank_id and "
								+ "posts.post_id = inspectors.post_id and vehicle_inspectors.inspector_id = inspectors.inspector_id");

				stmt.setString(1, login);
				stmt.setString(2, password);

				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					this.id = res.getInt(4);
					this.name = res.getString(1);
					this.passportNumber = res.getString(2);
					this.address = res.getString(3);
					this.login = res.getString(5);
					this.password = res.getString(6);
					this.rank = res.getString(7);
					this.post = res.getString(8);
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
		return super.toString();
	}

}
