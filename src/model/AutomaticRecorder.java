package model;

/**
 * Класс автоматического регистратора правонарушений. <br/>
 * Содержит координаты регистратора. Объект класса генерирует нарушения, создает
 * на них протоколы и привязывает их к ближайшему патрульному. Является
 * наследником класса DBObject. Реализует добавление, удаление и исправление
 * указанных данных об автоматических регистраторах, а также представление
 * объекта в виде строки и поиск объекта по id.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class AutomaticRecorder extends DBObject implements Runnable {

	/**
	 * 
	 */
	private String UID;

	/**
	 * 
	 */
	private EarthCoordinates coordinates;

	/**
	 * 
	 */
	private DutyTour dutyTour;

	/**
	 * 
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
	 * Создает объект типа автоматический регистратор. <br/>
	 * В параметрах передаются: координаты авторегистратора и экземпляр класса
	 * ''Наряд'', обозначающиеся соответственно: coordinates, dutyTour.
	 *
	 * @param UID
	 * @param coordinates
	 * @param dutyTour
	 * @param running
	 */
	public AutomaticRecorder(String UID, EarthCoordinates coordinates,
			DutyTour dutyTour, boolean running) {
		this.UID = UID;
		this.coordinates = coordinates;
		this.dutyTour = dutyTour;
		this.running = running;
	}

	/**
	 * Конструктор копирования для класса AutomaticRecorder. <br/>
	 * Создает копию объекта AutomaticRecorder(объект с идентичными значениями
	 * параметров входного экземпляра класса AutomaticRecorder). Входным
	 * параметром является объект класса AutomaticRecorder.
	 * 
	 * @param recorder
	 */
	public AutomaticRecorder(AutomaticRecorder recorder) {
		this.UID = recorder.UID;
		this.coordinates = recorder.coordinates;
		this.dutyTour = recorder.dutyTour;
		this.running = recorder.running;
	}

	@Override
	public void run() {
		// TODO implement generation of new protocols
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
	 * 
	 * @return
	 */
	public String getUID() {
		return UID;
	}
	
	/**
	 * 
	 * @param uID
	 */
	public void setUID(String uID) {
		UID = uID;
	}

	/**
	 * Устанавливает координаты авторегистратора в параметрах. <br/>
	 * Входящий параметр coordinates обозначает поле “Координаты
	 * авторегистратора”.
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
	 * Устанавливает наряд к которому привязан авторегистратор. <br/>
	 * Входящий параметр dutyTour обозначает экземпляр класса “Наряд”.
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
