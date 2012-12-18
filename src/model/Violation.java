package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
		this.id = violation.id;
		this.title = violation.title;
		this.description = violation.description;
		this.punishment = violation.punishment;
	}

	/**
	 * Переопределяются методы базового класса
	 */
	@Override
	public void insert() {
		try {
			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement(
								"insert into gibdd_system_db.violations (violation_id, title, "
										+ "description, punishment) values (default, ?, ?, ?)",
								Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, this.title);
				stmt.setString(2, this.description);
				stmt.setString(3, this.punishment);
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
			Violation tmp = new Violation(this);
			tmp.select(this.id);
			String oldRepr = tmp.toString();

			Connection conn = this.getConnection();
			try {
				PreparedStatement stmt = conn
						.prepareStatement("update gibdd_system_db.violations set"
								+ " title=?," + " description=?, "
								+ "punishment=? where violation_id = "
								+ Integer.toString(this.id));
				stmt.setString(1, this.title);
				stmt.setString(2, this.description);
				stmt.setString(3, this.punishment);

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
						.prepareStatement("delete from gibdd_system_db.violations where violation_id = "
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
						.prepareStatement("select violation_id, title, description, punishment"
								+ " from gibdd_system_db.violations where violation_id = "
								+ Integer.toString(id));
				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					this.id = res.getInt(1);
					this.title = res.getString(2);
					this.description = res.getString(3);
					this.punishment = res.getString(4);
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
		sb.append("id = " + this.id + ", ");
		sb.append("title = " + this.title + ", ");
		sb.append("description = " + this.description + ", ");
		sb.append("punishment = " + this.punishment);
		return sb.toString();
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
