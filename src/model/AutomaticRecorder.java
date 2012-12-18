package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Класс автоматического регистратора правонарушений. Содержит координаты
 * регистратора. Объект класса генерирует нарушения, создает на них протоколы и
 * привязывает их к ближайшему патрульному. Является наследником класса
 * DBObject. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Так как автоматический регистратор, является объектом, хранящимся в базе
 * данных, в нашей системе, помимо основных свойств, присущих автоматическому
 * регистратору, ему присвоен уникальный идентификатор или id. Этот id является
 * полем базового класса DBObect. Инспектора, находящиеся в наряде, представлены
 * множеством (Set) из объекта текущего наряда, информацию о котором хранит
 * автоматический регистратор. Ближайший патрульный инспектор вычисляется в
 * соответствии с координатами всех патрульных, которые могут быть получены как
 * поле класса PatrolInspector (patrolInspector.coordinates) <br/>
 * <br/>
 * Класс AutomaticRecorder характеризуется следующими полями: id, coordinates,
 * dutyTour <br/>
 * <ul>
 * <li>A(id) = Уникальный идентификатор</li>
 * <li>A(coordinates) = Ссылка на координаты</li>
 * <li>A(dutyTour.patrolInspectors<PatrolInspector>) = Ссылка на моножество
 * инспекторов, находящихся в наряде dutyTour</li>
 * </ul>
 * <br/>
 * <br/>
 * Инвариант представления <br/>
 * <ul>
 * <li>id - неотрицательное целое число, уникальное в пределах таблицы БД</li>
 * <li>coordinates - НЕ null</li>
 * <li>dutyTour.patrolInspectors<PatrolInspector> - НЕ null</li>
 * <li>для всех patrolInspector из dutyTour.patrolInspectors<PatrolInspector>
 * patrolInspector.coordinates - НЕ null</li>
 * </ul>
 * <br/>
 * <br/>
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class AutomaticRecorder extends DBObject implements Runnable {

	/**
	 * Номер регистратора
	 */
	private String UID;

	/**
	 * Координаты
	 */
	private EarthCoordinates coordinates;

	/**
	 * Наряд
	 */
	private DutyTour dutyTour;

	/**
	 * Включен ли автоматический регистратор?
	 */
	private boolean running;

	/**
	 * Конструктор по умолчанию для класса AutomaticRecorder. <br/>
	 * Создает экземпляр класса со стандартными значениями полей класса
	 * "Авторегистратор".
	 */
	public AutomaticRecorder() {
		this.UID = "";
		this.coordinates = new EarthCoordinates();
		this.dutyTour = new DutyTour();
		this.running = false;
	}

	/**
	 * Создает объект типа автоматический регистратор.
	 * 
	 * @param UID
	 * @param coordinates
	 * @param dutyTour
	 * @param running
	 */
	public AutomaticRecorder(String UID, EarthCoordinates coordinates,
			DutyTour dutyTour, boolean running) {
		this.UID = UID;
		this.coordinates = new EarthCoordinates(coordinates);
		this.dutyTour = new DutyTour(dutyTour);
		this.running = running;
	}

	/**
	 * Конструктор копирования для класса AutomaticRecorder. <br/>
	 * Создает копию объекта AutomaticRecorder(объект с идентичными значениями
	 * параметров входного экземпляра класса AutomaticRecorder).
	 * 
	 * @param recorder
	 */
	public AutomaticRecorder(AutomaticRecorder recorder) {
		this.id = recorder.id;
		this.UID = recorder.UID;
		this.coordinates = new EarthCoordinates(recorder.coordinates);
		this.dutyTour = new DutyTour(recorder.dutyTour);
		this.running = recorder.running;
	}

	/**
	 * Эмулирует регистрацию дорожно-транспортных нарушений. Метод в случайный
	 * момент времени создает протокол.<br/>
	 * <br/>
	 * Данный метод вызывается, когда стартует Thread содержащий данный объект,
	 * выполняется пока значение поля running равно true, и завершает свою
	 * работу, когда значение поля running равно false.<br/>
	 * <br/>
	 * В случайный момент времени данный метод создает новый объект класса
	 * Protocol, у которого задает поле registrationNumber (случайным образом),
	 * поле date текущей датой, поле patrolInspector ближайшим патрульным
	 * инспектором, который находится в наряде (dutyTour) в данный момент. Затем
	 * протокол (Protocol) записывается в базу данных.
	 */
	@Override
	public void run() {
		// TODO implement generation of new protocols
		throw new UnsupportedOperationException("not implemented");
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
								"insert into gibdd_system_db.automatic_recorders values (default, ?)",
								Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, this.UID);
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
			AutomaticRecorder tmp = new AutomaticRecorder(this);
			tmp.select(this.id);
			String oldRepr = tmp.toString();

			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("update gibdd_system_db.automatic_recorders set "
								+ "UID=? "
								+ "where automatic_recorder_id = "
								+ Integer.toString(this.id));
				stmt.setString(1, this.UID);

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
						.prepareStatement("delete from gibdd_system_db.automatic_recorders where automatic_recorder_id = "
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
						.prepareStatement("select automatic_recorder_id, UID "
								+ "from gibdd_system_db.automatic_recorders where automatic_recorder_id = "
								+ Integer.toString(id));
				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					this.id = res.getInt(1);
					this.UID = res.getString(2);
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
		sb.append("UID = " + this.UID);
		return sb.toString();
	}

	/**
	 * Возвращает номер регистратора.
	 * 
	 * @return
	 */
	public String getUID() {
		return UID;
	}

	/**
	 * Устанавливает номер регистратора.
	 * 
	 * @param UID
	 */
	public void setUID(String UID) {
		this.UID = UID;
	}

	/**
	 * Устанавливает координаты авторегистратора в параметрах.
	 * 
	 * @param coordinates
	 */
	public void setCoordinates(EarthCoordinates coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * Возвращает координаты авторегистратора.
	 * 
	 * @return
	 */
	public EarthCoordinates getCoordinates() {
		return this.coordinates;
	}

	/**
	 * Устанавливает наряд к которому привязан авторегистратор.
	 * 
	 * @param dutyTour
	 */
	public void setDutyTour(DutyTour dutyTour) {
		this.dutyTour = dutyTour;
	}

	/**
	 * Возвращает наряд к которому привязан авторегистратор.
	 * 
	 * @return
	 */
	public DutyTour getDutyTour() {
		return this.dutyTour;
	}

	/**
	 * Возвращает признак, включен ли регистратор.
	 * 
	 * @return
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Возвращает признак, включен ли регистратор.
	 * 
	 * @param running
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

}
