package model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * DBObject Характеризует объект, который может быть записан в базу данных.
 * Определяет операции добавления его в базу, изменения, удаления а также
 * загрузки объекта из базы в память. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Типичный класс целью которого является представление совокупности данных
 * относящихся к объекту данного класса в базе данных, имеет в своем составе
 * уникальный идентификатор или ID, по которому однозначно определяются поля БД
 * относящиеся к данному объекту. <br/>
 * <br/>
 * Таким образом, класс DBObject характеризуется следующими полями: id <br/>
 * <ul>
 * <li>A(id) = Уникальный идентификатор</li>
 * </ul>
 * <br/>
 * <br/>
 * Инвариант представления <br/>
 * <ul>
 * <li>id - неотрицательное целое число, уникальное в пределах таблицы БД</li>
 * </ul>
 * <br/>
 * <br/>
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public abstract class DBObject {

	/**
	 * Константа, определяющая значение неопределенного идентификатора
	 */
	public static final int UNDEFINED_ID = 0;

	/**
	 * Уникальный идентификатор
	 */
	protected int id;

	/**
	 * Конструктор по умолчанию
	 */
	public DBObject() {
		this.id = UNDEFINED_ID;
	}

	/**
	 * Добавляет представление объекта в базу данных, получает уникальный
	 * идентификатор из базы данных, и записывает его в поле id.
	 */
	public abstract void insert();

	/**
	 * Модифицирует представление объекта из базы данных.
	 */
	public abstract void update();

	/**
	 * Удаляет объект из базы данных.
	 */
	public abstract void delete();

	/**
	 * Загружает представление данного объекта из базы данных по id.
	 * 
	 * @param id
	 *            уникальный идентификатор
	 */
	public abstract void select(int id);

	/**
	 * Возвращает строковое представление объекта.
	 */
	public abstract String toString();

	/**
	 * Возвращает уникальный идентификатор объекта.<br/>
	 * <br/>
	 * Если текущее значение идентификатора объекта равно UNDEFINED_ID (т.е. еще
	 * не определено), то данный метод вызывает метод insert() и возвращает
	 * уникальный идентификатор, в противном случае метод просто возвращает
	 * уникальный идентификатор.
	 * 
	 * @return уникальный идентификатор
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Возвращает соединение к базе данных через пул.
	 * 
	 * @return соединение
	 * 
	 * @throws NamingException
	 * @throws SQLException
	 */
	protected Connection getConnection() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource dataSource = (DataSource) context
				.lookup("java:comp/env/gibdd-system");
		return dataSource.getConnection();
	}

}
