package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Класс описывает параметры патрульного инспектора. <br/>
 * Является наследником класса Inspector. Реализует добавление, удаление и
 * исправление указанных данных о патрульном инспекторе, а также представление
 * объекта в виде строки и поиск объекта по id.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class PatrolInspector extends Inspector implements Runnable {

	/**
	 * 
	 */
	private DutyTour dutyTour;

	/**
	 * 
	 */
	private EarthCoordinates coordinates;

	/**
	 * 
	 */
	private Queue<Protocol> queue;
	
	/**
	 * 
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
	 * Входными параметрами являются name, passportNumber, adress, rank, post,
	 * login, password, coordinates, обозначающими соответственно для данного
	 * объекта “ФИО”, “Серия/номер паспорта”, “Адрес”, “Звание”, “Должность”,
	 * “Логин для входа в систему”, “Пароль”, “Координаты инспектора”.
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
		this.coordinates = coordinates;
		this.running = running;
	}

	/**
	 * Конструктор копирования для класса PatrolInspector. <br/>
	 * Создает копию объекта PatrolInspector(объект с идентичными значениями
	 * параметров входного экземпляра класса PatrolInspector). Входным
	 * параметром является объект класса PatrolInspector.
	 * 
	 * @param inspector
	 */
	public PatrolInspector(PatrolInspector inspector) {
		super((Inspector) inspector);
		this.queue = new LinkedList<Protocol>(inspector.queue);
		this.coordinates = inspector.coordinates;
		this.running = inspector.running;
	}

	/**
	 * Создает объект типа протокол в соответствии с входными параметрами. <br/>
	 * Входными параметрами являются human, violation, violations, vehicle,
	 * date, обозначающими соответственно для данного объекта данные о человеке,
	 * основное нарушение, список сопутствующих нарушений, данные об автомобиле,
	 * дата составления протокола.
	 * 
	 * @param human
	 * @param violation
	 * @param date
	 * @param registrationNumber
	 * @param violations
	 * @return
	 */
	public Protocol createProtocol(Human human, Violation violation, Date date,
			String registrationNumber, Set<Violation> violations) {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	/**
	 * Обновляет данные во входящем протоколе в соответствии с входными
	 * параметрами. <br/>
	 * Входными параметрами являются protocol, human, violation, violations,
	 * vehicle, date, обозначающими соответственно для данного объекта протокол,
	 * который необходимо изменить, данные о человеке, основное нарушение,
	 * список сопутствующих нарушений, данные об автомобиле, дата составления
	 * протокола.
	 * 
	 * @param protocol
	 * @param human
	 * @param violation
	 * @param date
	 * @param registrationNumber
	 * @param violations
	 */
	public void updateProtocol(Protocol protocol, Human human,
			Violation violation, Date date, String registrationNumber,
			Set<Violation> violations) {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	/**
	 * Удаляет объект типа протокол. <br/>
	 * Входным параметром является protocol, обозначающим протокол, который
	 * необходимо удалить.
	 * 
	 * @param protocol
	 */
	public void deleteProtocol(Protocol protocol) {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public void run() {
		// TODO implement getting protocols from automatic recorder
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

	/**
	 * Устанавливает значение поля “Наряд” для данного объекта. Входящий
	 * параметр dutyTour обозначает поле “Наряд”.
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
	 * данного объекта. <br/>
	 * Входящий параметр coordinates обозначает поле “Координаты патрульного
	 * инспектора”.
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
	 * 
	 * @return
	 */
	public boolean isRunning() {
		return running;
	}
	
	/**
	 * 
	 * @param running
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

}
