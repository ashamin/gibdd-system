package model;

/**
 * Класс нарушение. <br/>
 * Содержит всю информацию о нарушении определенного типа. Является наследником
 * класса DBObject. Реализует добавление, удаление и исправление объектов типа
 * ''Нарушение'', а также представление объекта в виде строки и поиск объекта по
 * id.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class Violation extends DBObject {

	/**
	 * 
	 */
	private String title;

	/**
	 * 
	 */
	private String description;

	/**
	 * 
	 */
	private String punishment;

	/**
	 * Конструктор по умолчанию для класса Violation. <br/>
	 * Создает экземпляр класса со стандартными значениями полей класса
	 * ''Нарушение''.
	 */
	public Violation() {
		this.title = "";
		this.description = "";
		this.punishment = "";
	}

	/**
	 * Создает объект типа "Нарушение". <br/>
	 * В параметрах передаются: наименование нарушения, описание действий,
	 * которые относятся к нарушению и ответственность, которую несет
	 * нарушитель, обозначающиеся соответственно: title, description,
	 * punishment.
	 * 
	 * @param title
	 * @param description
	 * @param punishment
	 */
	public Violation(String title, String description, String punishment) {
		this.title = title;
		this.description = description;
		this.punishment = punishment;
	}

	/**
	 * Конструктор копирования для класса Violation. <br/>
	 * Создает копию объекта Violation(объект с идентичными значениями
	 * параметров входного экземпляра класса Violation). Входным параметром
	 * является объект класса Violation.
	 * 
	 * @param violation
	 */
	public Violation(Violation violation) {
		this.title = violation.title;
		this.description = violation.description;
		this.punishment = violation.punishment;
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
	 * Устанавливает наименование типа нарушения. <br/>
	 * Входящий параметр title обозначает поле “Наименование нарушения”.
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Возвращает наименование типа нарушения.
	 * 
	 * @return
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Устанавливает описание действий, которые относятся к нарушению данного
	 * типа. <br/>
	 * Входящий параметр description обозначает поле “Описание нарушения”.
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Возвращет описание действий, которые относятся к нарушению данного типа.
	 * 
	 * @return
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Устанавливает административную ответственность, которую несет
	 * правонарушитель. <br/>
	 * Входящий параметр punishment обозначает поле “Административная
	 * ответственность”.
	 * 
	 * @param punishment
	 */
	public void setPunishment(String punishment) {
		this.punishment = punishment;
	}

	/**
	 * Возвращает административную ответственность, которую несет нарушитель.
	 * 
	 * @return
	 */
	public String getPunishment() {
		return this.punishment;
	}

}
