package model;

import java.sql.Date;

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
	private Vehicle velicle;

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
		this.date = new Date(0, 0, 0);
		this.velicle = new Vehicle();
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
		this.human = human;
		this.violation = violation;
		this.date = date;
		this.velicle = vehicle;
		this.patrolInspector = patrolInspector;
	}

	/**
	 * Конструктор копирования для класса Protocol. <br/>
	 * Создает копию объекта Protocol(объект с идентичными значениями параметров
	 * входного экземпляра класса Protocol).
	 * 
	 * @param protocol
	 */
	public Protocol(Protocol protocol) {
		this.human = protocol.human;
		this.violation = protocol.violation;
		this.velicle = protocol.velicle;
		this.date = protocol.date;
		this.patrolInspector = protocol.patrolInspector;
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
	 * Устанавливает информацию об автомобиле.
	 * 
	 * @param vehicle
	 */
	public void setVehicle(Vehicle vehicle) {
		this.velicle = vehicle;
	}

	/**
	 * Возвращает информацию об автомобиле.
	 * 
	 * @return
	 */
	public Vehicle getVehicle() {
		return this.velicle;
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
