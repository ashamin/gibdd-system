package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * VehicleRegistrationSertificate Класс свидетельство о регистрации. Содержит
 * всю информацию о транспортном средстве, его владельце, а также даты
 * постановки транспортного средства на регистрационный учет и его снятия.
 * Является наследником класса DBObject. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Так как свидетельство о регистрации ТС, является объектом, хранящимся в базе
 * данных, в нашей системе, помимо основных свойств, присущих свидетельству о
 * регистрации, ему присвоен уникальный идентификатор или id. Этот id является
 * полем базового класса DBObect. Информация о транспортном средстве и его
 * владельце содержится в классе, как ссылки на объекты соответствующие
 * транспортному средству и владельцу данного транспортного средства. <br/>
 * <br/>
 * Класс VehicleRegistrationSertificate характеризуется следующими полями: id,
 * vehicle, human, registrationDate, leaveDate, vehicleInspector <br/>
 * <ul>
 * <li>A(id) = Уникальный идентификатор</li>
 * <li>A(vehicle) = Ссылка на транспортное средство</li>
 * <li>A(human) = Ссылка на человека</li>
 * <li>A(registrationDate) = Дата регистрации</li>
 * <li>A(leaveDate) = Дата снятия с учета</li>
 * <li>A(vehicleInspector) = Ссылка на инспектора</li>
 * </ul>
 * <br/>
 * <br/>
 * Инвариант представления <br/>
 * <ul>
 * <li>id - неотрицательное целое число, уникальное в пределах таблицы БД</li>
 * <li>vehicle - НЕ null</li>
 * <li>human - НЕ null</li>
 * <li>registrationDate - НЕ null</li>
 * <li>leaveDate - НЕ null</li>
 * <li>vehicleInspector - НЕ null</li>
 * </ul>
 * <br/>
 * <br/>
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class VehicleRegistrationCertificate extends DBObject {

	/**
	 * Транспортное средство
	 */
	private Vehicle vehicle;

	/**
	 * Человек
	 */
	private Human human;

	/**
	 * Регистрационный номер
	 */
	private String registrationNumber;

	/**
	 * Дата регистрации
	 */
	private Date registrationDate;

	/**
	 * Дата снятия с учета
	 */
	private Date leaveDate;

	/**
	 * Инспектор
	 */
	private VehicleInspector vehicleInspector;

	/**
	 * Конструктор по умолчанию для класса VehicleRegistrationSertificate. <br/>
	 * Создает экземпляр класса со стандартными значениями полей класса
	 * 'Свидетельство о регистрации ТС'.
	 */
	public VehicleRegistrationCertificate() {
		this.vehicle = new Vehicle();
		this.human = new Human();
		this.registrationNumber = "";
		this.registrationDate = Date.valueOf("1900-01-01");
		this.leaveDate = Date.valueOf("1900-01-01");
		this.vehicleInspector = new VehicleInspector();
	}

	/**
	 * Создает объект типа "Свидетельство о регистрации ТС".
	 * 
	 * @param vehicle
	 * @param human
	 * @param registrationNumber
	 * @param registrationDate
	 * @param leaveDate
	 * @param vehicleInspector
	 */
	public VehicleRegistrationCertificate(Vehicle vehicle, Human human,
			String registrationNumber, Date registrationDate, Date leaveDate,
			VehicleInspector vehicleInspector) {
		this.vehicle = new Vehicle(vehicle);
		this.human = new Human(human);
		this.registrationNumber = registrationNumber;
		this.registrationDate = new Date(registrationDate.getTime());
		this.leaveDate = new Date(leaveDate.getTime());
		this.vehicleInspector = new VehicleInspector(vehicleInspector);
	}

	/**
	 * Конструктор копирования для класса VehicleRegistrationSertificate. <br/>
	 * Создает копию объекта VehicleRegistrationSertificate(объект с идентичными
	 * значениями параметров входного экземпляра класса
	 * VehicleRegistrationSertificate).
	 * 
	 * @param vehicleRegistrationCertificate
	 */
	public VehicleRegistrationCertificate(
			VehicleRegistrationCertificate vehicleRegistrationCertificate) {
		this.id = vehicleRegistrationCertificate.id;
		this.vehicle = new Vehicle(vehicleRegistrationCertificate.vehicle);
		this.human = new Human(vehicleRegistrationCertificate.human);
		this.registrationNumber = vehicleRegistrationCertificate.registrationNumber;
		this.registrationDate = new Date(
				vehicleRegistrationCertificate.registrationDate.getTime());
		this.leaveDate = new Date(
				vehicleRegistrationCertificate.leaveDate.getTime());
		this.vehicleInspector = new VehicleInspector(
				vehicleRegistrationCertificate.vehicleInspector);
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
								"insert into gibdd_system_db.vehicle_registration_certificates "
										+ "(vehicle_registration_certificate_id, registration_date, "
										+ "leave_date, registration_number, vehicle_inspector_id, "
										+ "vehicle_id, human_id)"
										+ "values (default, ?, ?, ?, ?, ?, ?)",
								Statement.RETURN_GENERATED_KEYS);
				stmt.setDate(1, this.registrationDate);
				stmt.setDate(2, this.leaveDate);
				stmt.setString(3, this.registrationNumber);
				stmt.setInt(4, this.vehicleInspector.getBaseId());
				stmt.setInt(5, this.vehicle.getId());
				stmt.setInt(6, this.human.getId());

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
			VehicleRegistrationCertificate tmp = new VehicleRegistrationCertificate(
					this);
			tmp.select(this.id);
			String oldRepr = tmp.toString();

			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("update gibdd_system_db.vehicle_registration_certificates set "
								+ "registration_date=?, "
								+ "leave_date=?, "
								+ "registration_number=?, vehicle_inspector_id=?, "
								+ "vehicle_id=?, human_id=? "
								+ "where vehicle_registration_certificate_id = "
								+ Integer.toString(this.id));
				stmt.setDate(1, this.registrationDate);
				stmt.setDate(2, this.leaveDate);
				stmt.setString(3, this.registrationNumber);
				stmt.setInt(4, this.vehicleInspector.getBaseId());
				stmt.setInt(5, this.vehicle.getId());
				stmt.setInt(6, this.human.getId());

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
						.prepareStatement("delete from gibdd_system_db.vehicle_registration_certificates "
								+ "where vehicle_registration_certificate_id = "
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
						.prepareStatement("select vehicle_registration_certificate_id, "
								+ "registration_date, leave_date, registration_number, "
								+ "vehicle_inspectors.inspector_id, vehicle_id, human_id "
								+ "from gibdd_system_db.vehicle_registration_certificates, "
								+ "gibdd_system_db.vehicle_inspectors "
								+ "where vehicle_registration_certificate_id = "
								+ Integer.toString(id)
								+ " and "
								+ "vehicle_inspectors.vehicle_inspector_id = vehicle_registration_certificates.vehicle_inspector_id");
				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					this.id = res.getInt(1);
					this.registrationDate = res.getDate(2);
					this.leaveDate = res.getDate(3);
					this.registrationNumber = res.getString(4);
					this.vehicleInspector.select(res.getInt(5));
					this.vehicle.select(res.getInt(6));
					this.vehicle.select(res.getInt(7));
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
		sb.append("human = " + this.human + ", ");
		sb.append("registration_number = " + this.registrationNumber + ", ");
		sb.append("registration_date = " + this.registrationDate + ", ");
		sb.append("leave_date = " + this.leaveDate + ", ");
		sb.append("vehicle_inspector = " + this.vehicleInspector.toString()
				+ ", ");
		sb.append("vehicle = " + this.vehicle);
		return sb.toString();
	}

	/**
	 * Устанавливает регистрационный номер.
	 * 
	 * @param registrationNumber
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * Возвращает регистрационный номер.
	 * 
	 * @return
	 */
	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	/**
	 * Устанавливает объект автомобиль.
	 * 
	 * @param vehicle
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * Возвращает объект автомобиль.
	 * 
	 * @return
	 */
	public Vehicle getVehicle() {
		return this.vehicle;
	}

	/**
	 * Устанавливает владельца транспортного средства.
	 * 
	 * @param human
	 */
	public void setHuman(Human human) {
		this.human = human;
	}

	/**
	 * Возвращает владельца транспортного средства.
	 * 
	 * @return
	 */
	public Human getHuman() {
		return this.human;
	}

	/**
	 * Устанавливает инспектора оформившего транспортное средство.
	 * 
	 * @param vehicleInspector
	 */
	public void setVehicleInspector(VehicleInspector vehicleInspector) {
		this.vehicleInspector = vehicleInspector;
	}

	/**
	 * Возвращает инспектора, оформившего транспортное средство.
	 * 
	 * @return
	 */
	public VehicleInspector getVehicleInspector() {
		return this.vehicleInspector;
	}

	/**
	 * Возвращает дату постановки на учет.
	 * 
	 * @return
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * Устанавливает дату регистрации ТС.
	 * 
	 * @param registrationDate
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * Возвращает дату снятия с учета.
	 * 
	 * @return
	 */
	public Date getLeaveDate() {
		return leaveDate;
	}

	/**
	 * Устанавливает дату снятия с учета.
	 * 
	 * @param leaveDate
	 */
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

}
