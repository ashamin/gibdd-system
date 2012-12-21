package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Protocol Класс протокол. Содержит всю информацию о нарушении, человеке,
 * совершившем нарушение, инспекторе, оформившем протокол, автомобиле и дате
 * совершения нарушения. Является наследником класса DBObject. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Так как протокол, является объектом, хранящимся в базе данных, в нашей
 * системе, помимо основных свойств, присущих протоколу, ему присвоен уникальный
 * идентификатор или id. Этот id является полем базового класса DBObect.
 * Информация о человеке, совершившем нарушение, патрульном инспекторе,
 * нарушении и автомобиле содержится в классе, как ссылки на объекты
 * соответствующие человеку, совершившему нарушение, патрульному инспектору,
 * оформившему протокол, нарушению и автомобилю, на котором было совершено
 * нарушение. <br/>
 * <br/>
 * Класс Protocol характеризуется следующими полями: id, human, violation, date,
 * vehicle, patrolInspector. <br/>
 * <ul>
 * <li>A(id) = Уникальный идентификатор</li>
 * <li>A(human) = Ссылка на человека</li>
 * <li>A(violation) = Ссылка на нарушение</li>
 * <li>A(date) = Ссылка на дату составления</li>
 * <li>A(vehicle) = Ссылка на автомобиль</li>
 * <li>A(patrolInspector) = Ссылка на инспектора</li>
 * </ul>
 * <br/>
 * <br/>
 * Инвариант представления <br/>
 * <ul>
 * <li>id - неотрицательное целое число, уникальное в пределах таблицы БД</li>
 * <li>human - НЕ null</li>
 * <li>violation - НЕ null</li>
 * <li>date - НЕ null</li>
 * <li>vehicle - НЕ null</li>
 * <li>patrolInspector - НЕ null</li>
 * </ul>
 * <br/>
 * <br/>
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class Protocol extends DBObject {

	/**
	 * Человек
	 */
	private Human human;

	/**
	 * Нарушение
	 */
	private Violation violation;

	/**
	 * Дата оформления протокола
	 */
	private Date date;

	/**
	 * Автомобиль
	 */
	private Vehicle vehicle;

	/**
	 * Патрульный инспектор
	 */
	private PatrolInspector patrolInspector;

	/**
	 * Конструктор по умолчанию для класса Protocol. <br/>
	 * Создает экземпляр класса со стандартными значениями полей класса
	 * "Протокол".
	 */
	public Protocol() {
		this.human = new Human();
		this.violation = new Violation();
		this.date = Date.valueOf("1900-01-01");
		this.vehicle = new Vehicle();
		this.patrolInspector = new PatrolInspector();
	}

	/**
	 * Создает объект типа протокол.
	 * 
	 * @param human
	 * @param violation
	 * @param date
	 * @param vehicle
	 * @param patrolInspector
	 */
	public Protocol(Human human, Violation violation, Date date,
			Vehicle vehicle, PatrolInspector patrolInspector) {
		this.human = new Human(human);
		this.violation = new Violation(violation);
		this.date = new Date(date.getTime());
		this.vehicle = new Vehicle(vehicle);
		this.patrolInspector = new PatrolInspector(patrolInspector);
	}

	/**
	 * Конструктор копирования для класса Protocol. <br/>
	 * Создает копию объекта Protocol(объект с идентичными значениями параметров
	 * входного экземпляра класса Protocol).
	 * 
	 * @param protocol
	 */
	public Protocol(Protocol protocol) {
		this.id = protocol.id;
		this.human = new Human(protocol.human);
		this.violation = new Violation(protocol.violation);
		this.vehicle = new Vehicle(protocol.vehicle);
		this.date = new Date(protocol.date.getTime());
		this.patrolInspector = new PatrolInspector(protocol.patrolInspector);
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
								"insert into gibdd_system_db.protocols (protocol_id, date, "
										+ "violation_id, patrol_inspector_id, vehicle_id, human_id) "
										+ "values (default, ?, ?, ?, ?, ?)",
								Statement.RETURN_GENERATED_KEYS);
				stmt.setDate(1, this.date);
				stmt.setInt(2, this.violation.getId());
				stmt.setInt(3, this.patrolInspector.getBaseId());
				stmt.setInt(4, this.vehicle.getId());
				stmt.setInt(5, this.human.getId());

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
			Protocol tmp = new Protocol(this);
			tmp.select(this.id);
			String oldRepr = tmp.toString();

			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("update gibdd_system_db.protocols set "
								+ "date=?, "
								+ "violation_id=?, "
								+ "vehicle_id=?, "
								+ "patrol_inspector_id=?, "
								+ "human_id=? "
								+ "where protocol_id = "
								+ Integer.toString(this.id));
				stmt.setDate(1, this.date);
				stmt.setInt(2, this.violation.getId());
				stmt.setInt(3, this.vehicle.getId());
				stmt.setInt(4, this.patrolInspector.getBaseId());
				stmt.setInt(5, this.human.getId());

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
						.prepareStatement("delete from gibdd_system_db.protocols where protocol_id = "
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
						.prepareStatement("select protocol_id, date, "
								+ "violation_id, patrol_inspectors.inspector_id, vehicle_id, human_id "
								+ "from gibdd_system_db.protocols, gibdd_system_db.patrol_inspectors "
								+ "where protocol_id = "
								+ Integer.toString(id)
								+ " and "
								+ "patrol_inspectors.patrol_inspector_id = protocols.patrol_inspector_id");
				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					this.id = res.getInt(1);
					this.date = res.getDate(2);
					this.violation.select(res.getInt(3));
					this.patrolInspector.select(res.getInt(4));
					this.vehicle.select(res.getInt(5));
					this.human.select(res.getInt(6));
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
		sb.append("human = " + this.human.toString() + ", ");
		sb.append("date = " + this.date + ", ");
		sb.append("violation = " + this.violation.toString() + ", ");
		sb.append("patrol_inspector = " + this.patrolInspector.toString()
				+ ", ");
		sb.append("vehicle = " + this.vehicle);
		return sb.toString();
	}

	/**
	 * Устанавливает информацию об автомобиле.
	 * 
	 * @param vehicle
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * Возвращает информацию об автомобиле.
	 * 
	 * @return
	 */
	public Vehicle getVehicle() {
		return this.vehicle;
	}

	/**
	 * Устанавливает тип нарушения.
	 * 
	 * @param violation
	 */
	public void setViolation(Violation violation) {
		this.violation = violation;
	}

	/**
	 * Возвращает тип нарушения.
	 * 
	 * @return
	 */
	public Violation getViolation() {
		return this.violation;
	}

	/**
	 * Устанавливает информацию о нарушителе.
	 * 
	 * @param human
	 */
	public void setHuman(Human human) {
		this.human = human;
	}

	/**
	 * Возвращает информацию о нарушителе.
	 * 
	 * @return
	 */
	public Human getHuman() {
		return this.human;
	}

	/**
	 * Устанавливает информацию о патрульном инспекторе, заполнившем протокол.
	 * 
	 * @param patrolInspector
	 */
	public void setPatrolInspector(PatrolInspector patrolInspector) {
		this.patrolInspector = patrolInspector;
	}

	/**
	 * Возвращает информацию о патрульном инспекторе, заполнившем протокол.
	 * 
	 * @return
	 */
	public PatrolInspector getPatrolInspector() {
		return this.patrolInspector;
	}

	/**
	 * Возвращает дату составления протокола.
	 * 
	 * @return
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Устанавливает дату составления протокола.
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
