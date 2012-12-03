package model;

import java.util.Date;
import java.util.Set;

/**
 * Класс протокол. <br/>
 * Содержит нарушения и дату их регистрации. Является наследником класса
 * DBObject. Реализует добавление, удаление и исправление указанных данных о
 * протоколе, а также представление объекта в виде строки и поиск объекта по id.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class Protocol extends DBObject {

	/**
	 * 
	 */
	private Human human;

	/**
	 * 
	 */
	private Violation violation;

	/**
	 * 
	 */
	private Date date;

	/**
	 * 
	 */
	private Vehicle velicle;

	/**
	 * 
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
		this.date = new Date();
		this.velicle = new Vehicle();
		this.patrolInspector = new PatrolInspector();
	}

	/**
	 * Создает объект типа протокол. <br/>
	 * В параметрах передаются: человек, совершивший нарушение, основное
	 * нарушение, дата нарушения, регистрационный номер автомобиля, список
	 * побочных нарушений, патрульный инспектор, обозначающиеся соответственно:
	 * human, violation, date, registrationNumber, violations, patrolInspector.
	 * 
	 * @param human
	 * @param violation
	 * @param date
	 * @param vehicle
	 * @param violations
	 * @param patrolInspector
	 */
	public Protocol(Human human, Violation violation, Date date,
			Vehicle vehicle, Set<Violation> violations,
			PatrolInspector patrolInspector) {
		this.human = human;
		this.violation = violation;
		this.date = date;
		this.velicle = vehicle;
		this.patrolInspector = patrolInspector;
	}

	/**
	 * Конструктор копирования для класса Protocol. <br/>
	 * Создает копию объекта Protocol(объект с идентичными значениями параметров
	 * входного экземпляра класса Protocol). Входным параметром является объект
	 * класса Protocol.
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
	 * Устанавливает информацию о регистрационном номере автомобиля. <br/>
	 * Входящий параметр registrationNumber обозначает поле “Регистрационный
	 * номер ТС”.
	 * 
	 * @param vehicle
	 */
	public void setVehicle(Vehicle vehicle) {
		this.velicle = vehicle;
	}

	/**
	 * Возвращает информацию о регистрационном номере автомобиля.
	 * 
	 * @return
	 */
	public Vehicle getVehicle() {
		return this.velicle;
	}

	/**
	 * Устанавливает тип нарушения, на основании которого составлен протокол. <br/>
	 * Входящий параметр violation обозначает поле “Тип нарушение”.
	 * 
	 * @param violation
	 */
	public void setViolation(Violation violation) {
		this.violation = violation;
	}

	/**
	 * Возвращает тип нарушения, на основании которого составлен протокол.
	 * 
	 * @return
	 */
	public Violation getViolation() {
		return this.violation;
	}

	/**
	 * Устанавливает информацию о нарушителе. <br/>
	 * Входящий параметр human обозначает поле “Нарушитель”.
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
	 * Устанавливает информацию о патрульном инспекторе, заполнившем протокол. <br/>
	 * Входящий параметр patrolInspector обозначает поле “Патрульный инспектор”.
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
	 * Возвращает время и дату составления протокола.
	 * 
	 * @return
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Устанавливает дату составления протокола. <br/>
	 * Входящий параметр date обозначает поле “Дата нарушения”.
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
