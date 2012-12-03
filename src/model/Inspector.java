package model;

/**
 * Класс, включающий основные свойства инспектора ГИБДД. <br/>
 * Содержит информацию о звании, должности инспектора, а также логин и пароль,
 * необходимые инспектору, для входа в систему. Является наследником класса
 * Human. Реализует добавление, удаление и исправление указанных данных об
 * инспекторе, а также представление объекта в виде строки и поиск объекта по
 * id.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class Inspector extends Human {

	/**
	 * 
	 */
	protected String rank;

	/**
	 * 
	 */
	protected String post;

	/**
	 * 
	 */
	protected String login;

	/**
	 * 
	 */
	protected String password;

	/**
	 * Конструктор по умолчанию для класса Inspector. <br/>
	 * Создает экземпляр класса со стандартными значениями полей “ФИО”,
	 * “Серия/номер паспорта”, “Адрес”, “Звание”, “Должность”, “Логин”,
	 * “Пароль”.
	 */
	public Inspector() {
		super();
		this.rank = "";
		this.post = "";
		this.login = "";
		this.password = "";
	}

	/**
	 * Создает экземпляр класса Inspector. <br/>
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
	public Inspector(String name, String passportNumber, String address,
			String rank, String post, String login, String password) {
		super(name, passportNumber, address);
		this.rank = rank;
		this.post = post;
		this.login = login;
		this.password = password;
	}

	/**
	 * Конструктор копирования для класса Inspector. <br/>
	 * Создает копию объекта Inspector(объект с идентичными значениями
	 * параметров входного экземпляра класса Inspector). Входным параметром
	 * является объект класса Inspector.
	 * 
	 * @param inspector
	 */
	public Inspector(Inspector inspector) {
		super((Human) inspector);
		this.rank = inspector.rank;
		this.post = inspector.post;
		this.login = inspector.login;
		this.password = inspector.password;
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
	 * Возвращает значение поля “Звание” для данного объекта.
	 * 
	 * @return
	 */
	public String getRank() {
		return this.rank;
	}

	/**
	 * Устанавливает значение поля “Звание” для данного объекта. <br/>
	 * Входящий параметр rank обозначает поле “Звание”.
	 * 
	 * @param rank
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * Возвращает значение поля “Должность” для данного объекта.
	 * 
	 * @return
	 */
	public String getPost() {
		return this.post;
	}

	/**
	 * Устанавливает значение поля “Должность” для данного объекта. <br/>
	 * Входящий параметр post обозначает поле “Должность”.
	 * 
	 * @param post
	 */
	public void setPost(String post) {
		this.post = post;
	}

	/**
	 * Возвращает значение поля “Логин” для данного объекта.
	 * 
	 * @return
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Устанавливает значение поля “Логин” для данного объекта. <br/>
	 * Входящий параметр login обозначает поле “Логин”.
	 * 
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Возвращает значение поля “Пароль” для данного объекта.
	 * 
	 * @return
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Устанавливает значение поля “Пароль” для данного объекта. <br/>
	 * Входящий параметр password обозначает поле “Пароль”.
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
