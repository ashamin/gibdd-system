package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * PatrolInspector Класс описывает параметры патрульного инспектора. Помимо
 * параметров присущих любому инспектору, патрульный инспектор имеет координаты
 * его текущего местоположения и протоколы, которые ожидают заполнения. Является
 * наследником класса Inspector. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Так как патрульный инспектор, является объектом, хранящимся в базе данных, в
 * нашей системе, помимо основных свойств, присущих патрульному инспектору, ему
 * присвоен уникальный идентификатор или id. Этот id является полем базового
 * класса DBObect. Класс PatrolInspector наследуется от класса Human. Таким
 * образом объект инспектор, определяется в том числе и полями класса Human:
 * name, passportNumber, address. Также класс PatrolInspector наследуется от
 * класса Inspector. Таким образом объект инспектор, определяется в том числе и
 * полями класса Inspector: rank, post, login, password Протоколы, ожидающие
 * заполнения инспектором в реализации должны содержаться в очереди (Queue). <br/>
 * <br/>
 * Класс PatrolInspector характеризуется следующими полями: id, name,
 * passportNumber, address, rank, post, login, password, dutyTour, coordinates,
 * queue <br/>
 * <ul>
 * <li>A(id) = Уникальный идентификатор</li>
 * <li>A(name) = ФИО</li>
 * <li>A(passportNumber) = Номер паспорта</li>
 * <li>A(address) = Адрес</li>
 * <li>A(rank) = Звание</li>
 * <li>A(post) = Должность</li>
 * <li>A(login) = Логин</li>
 * <li>A(password) = Пароль</li>
 * <li>A(dutyTour) = Ссылка на наряд</li>
 * <li>A(coordinates) = Координаты</li>
 * <li>A(queue) = Очередь протоколов</li>
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
 * <li>dutyTour - НЕ null</li>
 * <li>coordinates - НЕ null</li>
 * <li>queue - НЕ null</li>
 * </ul>
 * <br/>
 * <br/>
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class PatrolInspector extends Inspector implements Runnable {

	/**
	 * Наряд
	 */
	private DutyTour dutyTour;

	/**
	 * Координаты
	 */
	private EarthCoordinates coordinates;

	/**
	 * Очередь протоколов
	 */
	private Queue<Protocol> queue;

	/**
	 * Работает ли патрульный инспектор?
	 */
	private boolean running;

	/**
	 * Конструктор по умолчанию для класса PatrolInspector. <br/>
	 * Создает экземпляр класса со стандартными значениями полей “ФИО”,
	 * “Серия/номер паспорта”, “Адрес”, “Звание”, “Должность”, “Логин”,
	 * “Пароль”, “Координаты инспектора”.
	 */
	public PatrolInspector() {
		super();
		this.queue = new LinkedList<Protocol>();
		this.coordinates = new EarthCoordinates();
		this.running = false;
	}

	/**
	 * Создает экземпляр класса PatrolInspector. <br/>
	 * 
	 * @param name
	 * @param passportNumber
	 * @param address
	 * @param rank
	 * @param post
	 * @param login
	 * @param password
	 * @param coordinates
	 */
	public PatrolInspector(String name, String passportNumber, String address,
			String rank, String post, String login, String password,
			EarthCoordinates coordinates, boolean running) {
		super(name, passportNumber, address, rank, post, login, password);
		this.queue = new LinkedList<Protocol>();
		this.coordinates = new EarthCoordinates(coordinates);
		this.running = running;
	}

	/**
	 * Конструктор копирования для класса PatrolInspector. <br/>
	 * Создает копию объекта PatrolInspector(объект с идентичными значениями
	 * параметров входного экземпляра класса PatrolInspector).
	 * 
	 * @param inspector
	 */
	public PatrolInspector(PatrolInspector inspector) {
		super((Inspector) inspector);
		
		this.queue = new LinkedList<Protocol>();
		Protocol tmp;
		Iterator<Protocol> it = inspector.queue.iterator();
		while(it.hasNext()){
			tmp = it.next();
			this.queue.add(new Protocol(tmp));
		}
				
		this.coordinates = new EarthCoordinates(inspector.coordinates);
		this.running = inspector.running;
	}

	/**
	 * Создает объект типа протокол. <br/>
	 * Метод создает объект класса класса Protocol с заданными параметрами,
	 * затем записывает его базу данных (вызывает метод insert() у созданного
	 * объекта) и возвращает его.
	 * 
	 * @param human
	 * @param violation
	 * @param date
	 * @param registrationNumber
	 * @return
	 */
	public Protocol createProtocol(Human human, Violation violation, Date date,
			Vehicle vehicle, String registrationNumber) {
		Protocol protocol = new Protocol(human, violation, date, vehicle, this);
		protocol.insert();
		return protocol;
	}

	/**
	 * Обновляет данные во входящем протоколе. <br/>
	 * Метод изменяет значение полей объекта класса Protocol на соответствующие
	 * значения заданные в параметрах, затем обновляет представление объекта в
	 * базе данных (вызывает метод update() для заданного объекта).
	 * 
	 * @param protocol
	 * @param human
	 * @param violation
	 * @param date
	 * @param registrationNumber
	 */
	public void updateProtocol(Protocol protocol, Human human,
			Violation violation, Date date, Vehicle vehicle,
			String registrationNumber) {
		protocol.setHuman(human);
		protocol.setDate(date);
		protocol.setViolation(violation);
		protocol.setVehicle(vehicle);
		protocol.setPatrolInspector(this);
		protocol.update();
	}

	/**
	 * Удаляет объект типа протокол. <br/>
	 * Метод удаляет представление объекта класса Protocol из базы данных
	 * (вызывает метод delete() для заданного объекта).
	 * 
	 * @param protocol
	 */
	public void deleteProtocol(Protocol protocol) {
		protocol.delete();
	}

	/**
	 * Обновляет очередь незаполненных протоколов данного инспектора.<br/>
	 * Данный метод вызывается, когда стартует Thread содержащий данный объект,
	 * выполняется пока значение поля running равно true, и завершает свою
	 * работу, когда значение поля running равно false.<br/>
	 * Метод в определенные промежутки времени загружает из базы данных
	 * протоколы (Prolocol), которые должен заполнить данный инспектор и
	 * добавляет их в очередь (queue), если в очереди их не было.
	 */
	@Override
	public void run() {
		// TODO implement getting protocols from automatic recorder
		throw new UnsupportedOperationException("not implemented");
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
								"insert into gibdd_system_db.patrol_inspectors (patrol_inspector_id, inspector_id)"
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
						.prepareStatement("delete from gibdd_system_db.patrol_inspectors where inspector_id = "
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
						.prepareStatement("select patrol_inspector_id "
								+ "from gibdd_system_db.patrol_inspectors where inspector_id = "
								+ Integer.toString(this.id));
				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					bid = res.getInt(1);
				}

				/*System.out.println("...Row with string representation \n\t"
						+ this.toString() + "\nwas selected from base");*/

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
								+ "gibdd_system_db.ranks, gibdd_system_db.posts, gibdd_system_db.patrol_inspectors "
								+ "where "
								+ "inspectors.login = ? and inspectors.password = ?"
								+ " and "
								+ "humans.human_id = inspectors.human_id and "
								+ "ranks.rank_id = inspectors.rank_id and "
								+ "posts.post_id = inspectors.post_id and patrol_inspectors.inspector_id = inspectors.inspector_id");

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

	/**
	 * Устанавливает значение поля “Наряд” для данного объекта.
	 * 
	 * @param dutyTour
	 */
	public void setDutyTour(DutyTour dutyTour) {
		this.dutyTour = dutyTour;
	}

	/**
	 * Возвращает значение поля “Наряд” для данного объекта.
	 * 
	 * @return
	 */
	public DutyTour getDutyTour() {
		return this.dutyTour;
	}

	/**
	 * Устанавливает значение поля “Координаты патрульного инспектора” для
	 * данного объекта.
	 * 
	 * @param coordinates
	 */
	public void setCoordinates(EarthCoordinates coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * Возвращает значение поля “Координаты патрульного инспектора” для данного
	 * объекта.
	 * 
	 * @return
	 */
	public EarthCoordinates getCoordinates() {
		return this.coordinates;
	}

	/**
	 * Возвращает значение поля running, показывающее работает ли данный
	 * патрульный инспектор.
	 * 
	 * @return
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Устанавливает значение поля running, показывающее работает ли данный
	 * патрульный инспектор.
	 * 
	 * @param running
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

}
