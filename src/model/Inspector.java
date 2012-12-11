package model;

/**
 * Inspector Класс, включающий основные свойства инспектора ГИБДД. Содержит
 * информацию о звании, должности инспектора, а также логин и пароль,
 * необходимые инспектору, для входа в систему. Является наследником класса
 * Human. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Так как инспектор, является объектом, хранящимся в базе данных, в нашей
 * системе, помимо основных свойств, присущих инспектору, ему присвоен
 * уникальный идентификатор или id. Этот id является полем базового класса
 * DBObect. Также класс Inspector наследуется от класса Human. Таким образом
 * объект инспектор, определяется в том числе и полями класса Human: name,
 * passportNumber, address. <br/>
 * <br/>
 * Класс Inspector характеризуется следующими полями: id, name, passportNumber,
 * address, rank, post, login, password <br/>
 * <ul>
 * <li>A(id) = Уникальный идентификатор</li>
 * <li>A(name) = ФИО</li>
 * <li>A(passportNumber) = Номер паспорта</li>
 * <li>A(address) = Адрес</li>
 * <li>A(rank) = Звание</li>
 * <li>A(post) = Должность</li>
 * <li>A(login) = Логин</li>
 * <li>A(password) = Пароль</li>
 * </ul>
 * <br/>
 * <br/>
 * Инвариант представления <br/>
 * <ul>
 * <li>id - неотрицательное целое число, уникальное в пределах таблицы БД</li>
 * <li>name - НЕ null и не пустая строка</li>
 * <li>passportNumber - НЕ null и не пустая строка</li>
 * <li>Address - НЕ null</li>
 * <li>rank - НЕ null и не пустая строка</li>
 * <li>post - НЕ null и не пустая строка</li>
 * <li>login - НЕ null и не пустая строка</li>
 * <li>password - НЕ null и не пустая строка</li>
 * </ul>
 * <br/>
 * <br/>
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class Inspector extends Human {

	/**
	 * Звание
	 */
	protected String rank;

	/**
	 * Должность
	 */
	protected String post;

	/**
	 * Логин
	 */
	protected String login;

	/**
	 * Пароль
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
	 * Создает экземпляр класса Inspector.
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
	 * параметров входного экземпляра класса Inspector).
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
	 * Возвращает значение поля “Звание” для данного объекта.
	 * 
	 * @return
	 */
	public String getRank() {
		return this.rank;
	}

	/**
	 * Устанавливает значение поля “Звание” для данного объекта.
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
	 * Устанавливает значение поля “Должность” для данного объекта.
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
	 * Устанавливает значение поля “Логин” для данного объекта.
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
	 * Устанавливает значение поля “Пароль” для данного объекта.
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
