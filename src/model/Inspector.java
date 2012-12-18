package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
		this.id = inspector.id;
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
		try {
			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn.prepareStatement(
						"insert into gibdd_system_db.inspectors (inspector_id, login, password, "
								+ "human_id, rank_id, post_id)"
								+ " values (default, ?, ?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, this.login);
				stmt.setString(2, this.password);

				Human tmp = new Human((Human) this);
				tmp.insert();
				stmt.setInt(3, tmp.id);

				PreparedStatement stmtSlct = conn
						.prepareStatement("select rank_id from gibdd_system_db.ranks where "
								+ "rank=?");
				stmtSlct.setString(1, this.rank);
				ResultSet res = stmtSlct.executeQuery();
				while (res.next())
					stmt.setInt(4, res.getInt(1));

				stmtSlct = conn
						.prepareStatement("select post_id from gibdd_system_db.posts"
								+ " where post=?");
				stmtSlct.setString(1, this.post);
				res = stmtSlct.executeQuery();
				while (res.next())
					stmt.setInt(5, res.getInt(1));

				stmt.executeUpdate();

				ResultSet key = stmt.getGeneratedKeys();
				key.next();
				this.id = key.getInt(1);

				System.out.println("...Row with string representation \n\t"
						+ this.toString() + "\nwas added");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		try {
			Inspector tmp = new Inspector(this);
			tmp.select(this.id);
			String oldRepr = tmp.toString();

			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("update gibdd_system_db.humans, gibdd_system_db.inspectors set"
								+ " humans.name=?,"
								+ " humans.passport_number=?, "
								+ "humans.address=?, inspectors.login=?, inspectors.password=?, "
								+ "inspectors.rank_id=?, inspectors.post_id=? "
								+ "where inspectors.inspector_id = "
								+ Integer.toString(this.id)
								+ " and "
								+ "humans.human_id = inspectors.human_id");
				stmt.setString(1, this.name);
				stmt.setString(2, this.passportNumber);
				stmt.setString(3, this.address);
				stmt.setString(4, this.login);
				stmt.setString(5, this.password);

				PreparedStatement stmtSlct = conn
						.prepareStatement("select rank_id from gibdd_system_db.ranks where "
								+ "rank=?");
				stmtSlct.setString(1, this.rank);
				ResultSet res = stmtSlct.executeQuery();
				while (res.next())
					stmt.setInt(6, res.getInt(1));

				stmtSlct = conn
						.prepareStatement("select post_id from gibdd_system_db.posts"
								+ " where post=?");
				stmtSlct.setString(1, this.post);
				res = stmtSlct.executeQuery();
				while (res.next())
					stmt.setInt(7, res.getInt(1));

				stmt.executeUpdate();

				System.out
						.println("...Row in base with string representation \n\t"
								+ oldRepr
								+ "\nwas updated to\n\t"
								+ this.toString());

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete() {
		try {
			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("delete from gibdd_system_db.inspectors where inspector_id = "
								+ Integer.toString(this.id));
				stmt.executeUpdate();

				System.out.println("...Row with string representation \n\t"
						+ this.toString() + "\nwas deleted from base");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void select(int id) {
		try {
			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("select humans.name, humans.passport_number, "
								+ "humans.address, "
								+ "inspectors.inspector_id, inspectors.login, inspectors.password, "
								+ "ranks.rank, posts.post "
								+ "from gibdd_system_db.humans, gibdd_system_db.inspectors, "
								+ "gibdd_system_db.ranks, gibdd_system_db.posts "
								+ "where "
								+ "inspectors.inspector_id = "
								+ Integer.toString(id)
								+ " and "
								+ "humans.human_id = inspectors.human_id and "
								+ "ranks.rank_id = inspectors.rank_id and "
								+ "posts.post_id = inspectors.post_id");
				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					this.id = res.getInt(4);
					this.name = res.getString(1);
					this.passportNumber = res.getString(2);
					this.address = res.getString(3);
					this.login = res.getString(5);
					this.password = res.getString(6);
					this.rank = res.getString(7);
					this.post = res.getString(8);
				}

				System.out.println("...Row with string representation \n\t"
						+ this.toString() + "\nwas selected from base");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Загружает представление данного объекта из базы данных по имени
	 * пользователя и паролю
	 * 
	 * @param login
	 *            имя пользователя
	 * @param password
	 *            пароль
	 */
	public void select(String login, String password) {
		try {
			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("select humans.name, humans.passport_number, "
								+ "humans.address, "
								+ "inspectors.inspector_id, inspectors.login, inspectors.password, "
								+ "ranks.rank, posts.post "
								+ "from gibdd_system_db.humans, gibdd_system_db.inspectors, "
								+ "gibdd_system_db.ranks, gibdd_system_db.posts "
								+ "where "
								+ "inspectors.login = ? and inspectors.password = ?"
								+ " and "
								+ "humans.human_id = inspectors.human_id and "
								+ "ranks.rank_id = inspectors.rank_id and "
								+ "posts.post_id = inspectors.post_id");

				stmt.setString(1, login);
				stmt.setString(2, password);

				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					this.id = res.getInt(4);
					this.name = res.getString(1);
					this.passportNumber = res.getString(2);
					this.address = res.getString(3);
					this.login = res.getString(5);
					this.password = res.getString(6);
					this.rank = res.getString(7);
					this.post = res.getString(8);
				}

				System.out.println("...Row with string representation \n\t"
						+ this.toString() + "\nwas selected from base");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", rank = " + this.rank + ", ");
		sb.append("post = " + this.post + ", ");
		sb.append("login = " + this.login + ", ");
		sb.append("password = " + this.password);
		return sb.toString();
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
