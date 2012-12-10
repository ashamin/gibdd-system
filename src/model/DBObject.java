package model;

/**
 * Класс реализующий операции сохранения, загрузки, модификации, удаления данных
 * из/в базу данных, а также представление объекта в формате строки.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public abstract class DBObject {

	/**
	 * 
	 */
	private static final int UNDEFINED_ID = 0;

	/**
	 * 
	 */
	protected int id;

	/**
	 * Создает объект класса реализующего операции сохранения, загрузки,
	 * модификации и удаления данных из/в базу данных, инициализирует id =
	 * UNDEFINED_ID.
	 */
	public DBObject() {
		this.id = UNDEFINED_ID;
	}

	/**
	 * Добавляет представление объекта в базу данных. При добавлении записи в
	 * базу данных присваивает id объекта, равному id новой записи в базе. В
	 * случае возникновения ошибки, связанной с реализацией базы данных,
	 * генерируется исключение DatabaseException.
	 */
	public abstract void insert();

	/**
	 * Модифицирует представление объекта из базы данных. В случае возникновения
	 * ошибки, связанной с реализацией базы данных, генерируется исключение
	 * DatabaseException. В случае попытки обновления несуществующей записи базы
	 * данных генерируется исключение типа IllegalIdException.
	 */
	public abstract void update();

	/**
	 * Удаляет объект из базы данных. В случае возникновения ошибки, связанной с
	 * реализацией базы данных, генерируется исключение DatabaseException. В
	 * случае попытки удаления несуществующей записи базы данных генерируется
	 * исключение типа IllegalIdException.
	 */
	public abstract void delete();

	/**
	 * Загружает представление данного объекта из базы данных по id. В случае
	 * возникновения ошибки, связанной с реализацией базы данных, генерируется
	 * исключение DatabaseException.
	 * 
	 * @param id
	 */
	public abstract void select(int id);

	/**
	 * Возвращает строковое представление объекта.
	 */
	public abstract String toString();

	/**
	 * Возвращает id. Если объекту уже присвоен id, то метод возвращает его. В
	 * противном случае, метод добавляет запись, соответствующую объекту в
	 * таблицу, тем самым вычисляет новый id для объекта и возвращает его. Метод
	 * используется для так называемого “ленивого вычисления” id по
	 * необходимости. В случае возникновения ошибки, связанной с реализацией
	 * базы данных, генерируется исключение DatabaseException.
	 * 
	 * @return
	 */
	public int getId() {
		if (this.id == UNDEFINED_ID) {
			this.insert();
		}
		return this.id;
	}

}
