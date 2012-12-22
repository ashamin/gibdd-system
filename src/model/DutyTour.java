package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

/**
 * Класс наряд. Класс наряд. Содержит инспекторов и автоматические регистраторы
 * состоящие в наряде, дату начала, дату конца и инспектора составившего
 * расписание наряда. Является наследником класса DBObject. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Так как наряд, является объектом, хранящимся в базе данных, в нашей системе,
 * помимо основных свойств, присущих наряду, ему присвоен уникальный
 * идентификатор или id. Этот id является полем базового класса DBObect.
 * Информация о дежурном инспекторе, составившем наряд содержится в классе, как
 * ссылка на объект соответствующий дежурному инспектору. Патрульные и
 * автоматические регистраторы, заступившие в наряд должны быть представлены
 * множествами (Set). <br/>
 * <br/>
 * Класс DutyTour характеризуется следующими полями: id, patrolInspectors,
 * automaticRecorders, dutyInspector, startDate, finishDate <br/>
 * <ul>
 * <li>A(id) = Уникальный идентификатор</li>
 * <li>A(patrolInspectors) = Ссылка на множество патрульных инспекторов</li>
 * <li>A(automaticRecorders) = Ссылка на множество автоматических регистраторов</li>
 * <li>A(dutyInspector) = Ссылка на дежурного инспектора</li>
 * <li>A(startDate) = Начало наряда</li>
 * <li>A(finishDate) = Завершение наряда</li>
 * </ul>
 * <br/>
 * <br/>
 * Инвариант представления <br/>
 * <ul>
 * <li>id - неотрицательное целое число, уникальное в пределах таблицы БД</li>
 * <li>patrolInspectors - НЕ null и не пустое множество</li>
 * <li>AutomaticRecorders - НЕ null и не пустое множество</li>
 * <li>dutyInspector - НЕ null</li>
 * <li>startDate - НЕ null</li>
 * <li>finishDate - НЕ null</li>
 * </ul>
 * <br/>
 * <br/>
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class DutyTour extends DBObject {

	/**
	 * Множество патрульных инспекторов
	 */
	private Set<PatrolInspector> patrolInspectors;

	/**
	 * Множество автоматических регистраторов
	 */
	private Set<AutomaticRecorder> automaticRecorders;

	/**
	 * Дежурный инспектор
	 */
	private DutyInspector dutyInspector;

	/**
	 * Начало наряда
	 */
	private Date startDate;

	/**
	 * Завершение наряда
	 */
	private Date finishDate;

	/**
	 * Конструктор по умолчанию для класса DutyTour. <br/>
	 * Создает экземпляр класса со стандартными значениями полей список
	 * патрульных инспекторов, список автоматических регистраторов, инспектор,
	 * составивший наряд, дата начала наряда, дата его окончания.
	 */
	public DutyTour() {
		this.patrolInspectors = new HashSet<PatrolInspector>();
		this.automaticRecorders = new HashSet<AutomaticRecorder>();
		this.dutyInspector = new DutyInspector();
		this.startDate = Date.valueOf("1900-01-01");
		this.finishDate = Date.valueOf("1900-01-01");
	}

	/**
	 * Создает объект типа наряд.
	 * 
	 * @param patrolInspectors
	 * @param recorders
	 * @param dutyInspector
	 * @param startDate
	 * @param finishDate
	 */
	public DutyTour(Set<PatrolInspector> patrolInspectors,
			Set<AutomaticRecorder> recorders, DutyInspector dutyInspector,
			Date startDate, Date finishDate) {

		DBObject tmp;
		this.patrolInspectors = new HashSet<PatrolInspector>();
		this.automaticRecorders = new HashSet<AutomaticRecorder>();

		Iterator<PatrolInspector> itp = patrolInspectors.iterator();
		while (itp.hasNext()) {
			tmp = itp.next();
			this.patrolInspectors
					.add(new PatrolInspector((PatrolInspector) tmp));
		}

		Iterator<AutomaticRecorder> ita = automaticRecorders.iterator();
		while (ita.hasNext()) {
			tmp = ita.next();
			this.automaticRecorders.add(new AutomaticRecorder(
					(AutomaticRecorder) tmp));
		}

		this.dutyInspector = new DutyInspector(dutyInspector);
		this.startDate = new Date(startDate.getTime());
		this.finishDate = new Date(finishDate.getTime());
	}

	/**
	 * Конструктор копирования для класса DutyTour. <br/>
	 * Создает копию объекта DutyTour(объект с идентичными значениями параметров
	 * входногоI экземпляра класса DutyTour).
	 * 
	 * @param dutyTour
	 */
	public DutyTour(DutyTour dutyTour) {
		this.id = dutyTour.id;

		DBObject tmp;
		this.patrolInspectors = new HashSet<PatrolInspector>();
		this.automaticRecorders = new HashSet<AutomaticRecorder>();

		Iterator<PatrolInspector> itp = dutyTour.patrolInspectors.iterator();
		while (itp.hasNext()) {
			tmp = itp.next();
			this.patrolInspectors
					.add(new PatrolInspector((PatrolInspector) tmp));
		}

		Iterator<AutomaticRecorder> ita = dutyTour.automaticRecorders
				.iterator();
		while (ita.hasNext()) {
			tmp = ita.next();
			this.automaticRecorders.add(new AutomaticRecorder(
					(AutomaticRecorder) tmp));
		}

		this.dutyInspector = new DutyInspector(dutyTour.dutyInspector);
		this.startDate = new Date(dutyTour.startDate.getTime());
		this.finishDate = new Date(dutyTour.finishDate.getTime());
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
								"insert into gibdd_system_db.duty_tours (duty_tour_id, start_date, finish_date, "
										+ "duty_inspector_id) "
										+ "values (default, ?, ?, ?)",
								Statement.RETURN_GENERATED_KEYS);
				stmt.setDate(1, this.startDate);
				stmt.setDate(2, this.finishDate);
				stmt.setInt(3, this.dutyInspector.getBaseId());
				stmt.executeUpdate();

				ResultSet key = stmt.getGeneratedKeys();
				key.next();
				this.id = key.getInt(1);

				stmt = conn
						.prepareStatement("insert into gibdd_system_db.duties (duty_id, duty_tour_id, patrol_inspector_id) "
								+ "values (default, ?, ?)");

				Iterator<PatrolInspector> it = this.patrolInspectors.iterator();
				PatrolInspector tmp;
				while (it.hasNext()) {
					tmp = it.next();
					stmt.setInt(1, this.id);
					stmt.setInt(2, tmp.getBaseId());
					stmt.executeUpdate();
				}

				/*
				 * System.out.println("...Row with string representation \n\t" +
				 * this.toString() + "\nwas added");
				 */
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
			DutyTour tmp = new DutyTour(this);
			tmp.select(this.id);
			String oldRepr = tmp.toString();

			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("update gibdd_system_db.duty_tours set "
								+ "start_date=?, "
								+ "finish_date=?, "
								+ "duty_inspector_id=? "
								+ "where duty_tour_id = "
								+ Integer.toString(this.id));
				stmt.setDate(1, this.startDate);
				stmt.setDate(2, this.finishDate);
				stmt.setInt(3, this.dutyInspector.getBaseId());

				stmt.executeUpdate();

				/*
				 * удаляем все из расшивочной таблицы
				 */
				stmt = conn
						.prepareStatement("delete from gibdd_system_db.duties where duty_tour_id = "
								+ Integer.toString(this.id));
				stmt.executeUpdate();

				/*
				 * снова вставляем все в расшивочную таблицу
				 */
				stmt = conn
						.prepareStatement("insert into gibdd_system_db.duties (duty_id, duty_tour_id, patrol_inspector_id) "
								+ "values (default, ?, ?)");

				Iterator<PatrolInspector> it = this.patrolInspectors.iterator();
				PatrolInspector tmpPatrolInspector;
				while (it.hasNext()) {
					tmpPatrolInspector = it.next();
					stmt.setInt(1, this.id);
					stmt.setInt(2, tmpPatrolInspector.getBaseId());
					stmt.executeUpdate();
				}

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
						.prepareStatement("delete from gibdd_system_db.duty_tours where duty_tour_id = "
								+ Integer.toString(this.id));
				stmt.executeUpdate();

				stmt = conn
						.prepareStatement("delete from gibdd_system_db.duties where duty_tour_id = "
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
						.prepareStatement("select duty_tour_id, start_date, finish_date, duty_inspectors.inspector_id "
								+ "from gibdd_system_db.duty_tours, gibdd_system_db.duty_inspectors "
								+ "where duty_tour_id = "
								+ Integer.toString(id)
								+ " and "
								+ "duty_inspectors.duty_inspector_id = duty_tours.duty_inspector_id");
				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					this.id = res.getInt(1);
					this.startDate = res.getDate(2);
					this.finishDate = res.getDate(3);
					this.dutyInspector.select(res.getInt(4));
				}

				stmt = conn
						.prepareStatement("select patrol_inspectors.inspector_id "
								+ "from gibdd_system_db.patrol_inspectors, gibdd_system_db.duties "
								+ "where duties.patrol_inspector_id = patrol_inspectors.patrol_inspector_id "
								+ "and duties.duty_tour_id = " 
								+ Integer.toString(this.id));

				res = stmt.executeQuery();

				this.patrolInspectors.clear();
				PatrolInspector tmp = new PatrolInspector();
				while (res.next()) {
					tmp.select(res.getInt(1));
					this.patrolInspectors.add(new PatrolInspector(tmp));
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
		sb.append("duty_inspector = " + this.dutyInspector.toString() + ", ");
		sb.append("start_date = " + this.startDate.toString() + ", ");
		sb.append("finish_date = " + this.finishDate.toString() + ", ");
		sb.append(" [ ");
		Iterator<PatrolInspector> it = this.patrolInspectors.iterator();
		PatrolInspector tmp;
		while (it.hasNext()) {
			tmp = it.next();
			sb.append(tmp.toString() + ", ");
		}
		return sb.toString();
	}

	/**
	 * Возвращает список патрульных инспекторов в наряде.
	 * 
	 * @return
	 */
	public Set<PatrolInspector> getPatrolInspectors() {
		if (this.patrolInspectors == null) {
			this.patrolInspectors = new HashSet<PatrolInspector>();
		}
		return this.patrolInspectors;
	}

	/**
	 * Возвращает список автоматических регистраторов.
	 * 
	 * @return
	 */
	public Set<AutomaticRecorder> getAutomaticRecorders() {
		if (this.automaticRecorders == null) {
			this.automaticRecorders = new HashSet<AutomaticRecorder>();
		}
		return this.automaticRecorders;
	}

	/**
	 * Устанавливает инспектора составившего расписание наряда.
	 * 
	 * @param dutyInspector
	 */
	public void setDutyInspector(DutyInspector dutyInspector) {
		this.dutyInspector = dutyInspector;
	}

	/**
	 * Возвращает инспектора составившего расписание наряда.
	 * 
	 * @return
	 */
	public DutyInspector getDutyInspector() {
		return this.dutyInspector;
	}

	/**
	 * Возвращает дату начала наряда.
	 * 
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Устанавливает дату начала наряда.
	 * 
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Возвращает дату окончания наряда.
	 * 
	 * @return
	 */
	public Date getFinishDate() {
		return finishDate;
	}

	/**
	 * Устанавливает дату окончания наряда.
	 * 
	 * @param finishDate
	 */
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

}
