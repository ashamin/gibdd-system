package model;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

/**
 * Класс наряд. <br/>
 * Содержит инспекторов в наряде, дату начала, дату конца и инспектора
 * составившего расписание наряда. Является наследником класса DBObject.
 * Реализует добавление, удаление и исправление указанных данных о нарядах, а
 * также представление объекта в виде строки и поиск объекта по id.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class DutyTour extends DBObject {

	/**
	 * 
	 */
	private Set<PatrolInspector> patrolInspectors;

	/**
	 * 
	 */
	private Set<AutomaticRecorder> automaticRecorders;

	/**
	 * 
	 */
	private DutyInspector dutyInspector;

	/**
	 * 
	 */
	private Date startDate;

	/**
	 * 
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
		this.startDate = new Date();
		this.finishDate = new Date();
	}

	/**
	 * Создает объект типа наряд. <br/>
	 * В параметрах передаются: список патрульных инспекторов, список
	 * автоматических регистраторов, инспектор, составивший наряд, дата начала
	 * наряда, дата его окончания, обозначающиеся соответственно: inspectors,
	 * recorders, inspector, startDate, finishDate.
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
		this.patrolInspectors = patrolInspectors;
		this.automaticRecorders = recorders;
		this.dutyInspector = dutyInspector;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}

	/**
	 * Конструктор копирования для класса DutyTour. <br/>
	 * Создает копию объекта DutyTour(объект с идентичными значениями параметров
	 * входного экземпляра класса DutyTour). Входным параметром является объект
	 * класса DutyTour.
	 * 
	 * @param dutyTour
	 */
	public DutyTour(DutyTour dutyTour) {
		this.patrolInspectors = dutyTour.patrolInspectors;
		this.automaticRecorders = dutyTour.automaticRecorders;
		this.dutyInspector = dutyTour.dutyInspector;
		this.startDate = dutyTour.startDate;
		this.finishDate = dutyTour.finishDate;
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
	 * Устанавливает инспектора составившего расписание наряда. <br/>
	 * Входящий параметр inspector обозначает поле “Дежурный инспектор”.
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
	 * Устанавливает дату начала наряда. <br/>
	 * Входящий параметр startDate обозначает поле “Дата начала наряда”.
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
	 * Устанавливает дату окончания наряда. <br/>
	 * Входящий параметр finishDate обозначает поле “Дата окончания наряда”.
	 * 
	 * @param finishDate
	 */
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

}
