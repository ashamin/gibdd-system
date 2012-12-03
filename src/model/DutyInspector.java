package model;

import java.util.Date;
import java.util.Set;

/**
 * Класс описывает параметры дежурного инспектора. <br/>
 * Является наследником класса Inspector. Реализует добавление, удаление и
 * исправление указанных данных о дежурном инспекторе, а также представление
 * объекта в виде строки и поиск объекта по id.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class DutyInspector extends Inspector {

	/**
	 * Конструктор по умолчанию для класса DutyInspector. <br/>
	 * Создает экземпляр класса со стандартными значениями полей “ФИО”,
	 * “Серия/номер паспорта”, “Адрес”, “Звание”, “Должность”, “Логин”,
	 * “Пароль”.
	 */
	public DutyInspector() {
		super();
	}

	/**
	 * Создает экземпляр класса DutyInspector. <br/>
	 * Входными параметрами являются name, passportNumber, adress, rank, post,
	 * login, password, обозначающими соответственно для данного объекта “ФИО”,
	 * “Серия/номер паспорта”, “Адрес”, “Звание”, “Должность”, “Логин для входа
	 * в систему”, “Пароль”.
	 * 
	 * @param name
	 * @param passportNumber
	 * @param address
	 * @param rank
	 * @param post
	 * @param login
	 * @param password
	 */
	public DutyInspector(String name, String passportNumber, String address,
			String rank, String post, String login, String password) {
		super(name, passportNumber, address, rank, post, login, password);
	}

	/**
	 * Конструктор копирования для класса DutyInspector. <br/>
	 * Создает копию объекта DutyInspector(объект с идентичными значениями
	 * параметров входного экземпляра класса DutyInspector). Входным параметром
	 * является объект класса DutyInspector.
	 * 
	 * @param inspector
	 */
	public DutyInspector(DutyInspector inspector) {
		super((Inspector) inspector);
	}

	/**
	 * Запускает работу авторегистраторов и патрульных. <br/>
	 * В параметрах передается dutyTour, обозначающий объект типа наряд.
	 * 
	 * @param dutyTour
	 */
	public void startDutyTour(DutyTour dutyTour) {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	/**
	 * Останавливает работу авторегистраторов и патрульных. <br/>
	 * В параметрах передается dutyTour, обозначающий объект типа наряд.
	 * 
	 * @param dutyTour
	 */
	public void finishDutyTour(DutyTour dutyTour) {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	/**
	 * Создает объект типа наряд и записывает его в базу данных. <br/>
	 * В параметрах передаются patrolInspectors, automaticRecorders, startDate,
	 * finishDate, обозначающие соответственно список патрульных инспекторов,
	 * список автоматических регистраторов, дату начала наряда и дату окончания
	 * наряда.
	 * 
	 * @param inspectors
	 * @param recorders
	 * @param startDate
	 * @param finishDate
	 * @return
	 */
	public DutyTour createDutyTour(Set<PatrolInspector> inspectors,
			Set<AutomaticRecorder> recorders, Date startDate, Date finishDate) {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	/**
	 * Изменяет параметры объекта типа наряд и записывает его в базу данных. <br/>
	 * В параметрах передаются dutyTour, patrolInspectors, automaticRecorders,
	 * startDate, finishDate, обозначающие соответственно объект типа наряд,
	 * список патрульных инспекторов, список автоматических регистраторов, дату
	 * начала наряда и дату окончания наряда.
	 * 
	 * @param dutyTour
	 * @param inspectors
	 * @param recorders
	 * @param startDate
	 * @param finishDate
	 */
	public void updateDutyTour(DutyTour dutyTour,
			Set<PatrolInspector> inspectors, Set<AutomaticRecorder> recorders,
			Date startDate, Date finishDate) {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	/**
	 * Удаляет объект типа наряд. <br/>
	 * В параметрах передается объект dutyTour, обозначающий наряд.
	 * 
	 * @return
	 */
	public DutyTour deleteDutyTour() {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
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

}
