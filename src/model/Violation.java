package model;

/**
 * Класс нарушение. Класс нарушение. Содержит наименование нарушения, описание
 * действий относящихся к нарушению и ответственность, которую несет человек
 * совершивший данное нарушение. Является наследником класса DBObject. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Так как нарушение, является объектом, хранящимся в базе данных, в нашей
 * системе, помимо основных свойств, присущих нарушению, ему присвоен уникальный
 * идентификатор или id. Этот id является полем базового класса DBObect. <br/>
 * <br/>
 * Класс Violation характеризуется следующими полями: id, title, description,
 * punishment <br/>
 * <ul>
 * <li>A(id) = Уникальный идентификатор</li>
 * <li>A(title) = Наименование нарушения</li>
 * <li>A(description) = Описание действий, относящихся к нарушению</li>
 * <li>A(punishment) = Ответственность, которую несет нарушитель</li>
 * </ul>
 * <br/>
 * <br/>
 * Инвариант представления <br/>
 * <ul>
 * <li>id - неотрицательное целое число, уникальное в пределах таблицы БД</li>
 * <li>title - НЕ null и не пустая строка</li>
 * <li>description - НЕ null и не пустая строка</li>
 * <li>punishment - НЕ null и не пустая строка</li>
 * </ul>
 * <br/>
 * <br/>
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class Violation extends DBObject {

	/**
	 * Наименование нарушения
	 */
	private String title;

	/**
	 * Описание действий, относящихся к нарушению
	 */
	private String description;

	/**
	 * Ответственность, которую несет нарушитель
	 */
	private String punishment;

	/**
	 * Конструктор по умолчанию для класса Violation. <br/>
	 * Создает экземпляр класса со стандартными значениями полей класса
	 * 'Нарушение'.
	 */
	public Violation() {
		this.title = "";
		this.description = "";
		this.punishment = "";
	}

	/**
	 * Создает объект типа "Нарушение".
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
	 * параметров входного экземпляра класса Violation).
	 * 
	 * @param violation
	 */
	public Violation(Violation violation) {
		this.title = violation.title;
		this.description = violation.description;
		this.punishment = violation.punishment;
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
	 * Устанавливает наименование типа нарушения.
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
	 * Устанавливает описание действий.
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Возвращет описание действий.
	 * 
	 * @return
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Устанавливает административную ответственность.
	 * 
	 * @param punishment
	 */
	public void setPunishment(String punishment) {
		this.punishment = punishment;
	}

	/**
	 * Возвращает административную ответственность.
	 * 
	 * @return
	 */
	public String getPunishment() {
		return this.punishment;
	}

}
