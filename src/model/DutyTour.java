package model;

import java.sql.Date;
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
		this.startDate = new Date(0, 0, 0);
		this.finishDate = new Date(0, 0, 0);
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
		this.patrolInspectors = patrolInspectors;
		this.automaticRecorders = recorders;
		this.dutyInspector = dutyInspector;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}

	/**
	 * Конструктор копирования для класса DutyTour. <br/>
	 * Создает копию объекта DutyTour(объект с идентичными значениями параметров
	 * входногоI экземпляра класса DutyTour).
	 * 
	 * @param dutyTour
	 */
	public DutyTour(DutyTour dutyTour) {
		DBObject tmp;
		this.patrolInspectors = new HashSet<PatrolInspector>();
		this.automaticRecorders = new HashSet<AutomaticRecorder>();
		
		Iterator<PatrolInspector> itp = dutyTour.patrolInspectors.iterator();
		while(itp.hasNext()){
			tmp = itp.next();
			this.patrolInspectors.add(new PatrolInspector((PatrolInspector)tmp));
		}
		
		Iterator<AutomaticRecorder> ita = dutyTour.automaticRecorders.iterator();
		while(ita.hasNext()){
			tmp = ita.next();
			this.automaticRecorders.add(new AutomaticRecorder((AutomaticRecorder)tmp));
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
