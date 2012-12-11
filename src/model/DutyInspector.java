package model;

import java.util.Date;
import java.util.Set;

/**
 * DutyInspector Класс описывает параметры дежурного инспектора. Является
 * наследником класса Inspector. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Так как дежурный инспектор, является объектом, хранящимся в базе данных, в
 * нашей системе, помимо основных свойств, присущих деружному инспектору, ему
 * присвоен уникальный идентификатор или id. Этот id является полем базового
 * класса DBObect. Класс DutyInspector наследуется от класса Human. Таким
 * образом объект инспектор, определяется в том числе и полями класса Human:
 * name, passportNumber, address. Также класс DutyInspector наследуется от
 * класса Inspector. Таким образом объект инспектор, определяется в том числе и
 * полями класса Inspector: rank, post, login, password <br/>
 * <br/>
 * Класс DutyInspector характеризуется следующими полями: id, name,
 * passportNumber, address, rank, post, login, password
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
public class DutyInspector extends Inspector {

	/**
	 * Конструктор по умолчанию для класса DutyInspector. <br/>
	 * Создает экземпляр класса со стандартными значениями полей “ФИО”,
	 * “Серия/номер паспорта”, “Адрес”, “Звание”, “Должность”, “Логин”,
	 * “Пароль”.
	 */
	public DutyInspector() {
		super();
	}

	/**
	 * Создает экземпляр класса DutyInspector.
	 * 
	 * @param name
	 * @param passportNumber
	 * @param address
	 * @param rank
	 * @param post
	 * @param login
	 * @param password
	 */
	public DutyInspector(String name, String passportNumber, String address,
			String rank, String post, String login, String password) {
		super(name, passportNumber, address, rank, post, login, password);
	}

	/**
	 * Конструктор копирования для класса DutyInspector. <br/>
	 * Создает копию объекта DutyInspector(объект с идентичными значениями
	 * параметров входного экземпляра класса DutyInspector).
	 * 
	 * @param inspector
	 */
	public DutyInspector(DutyInspector inspector) {
		super((Inspector) inspector);
	}

	/**
	 * Запускает работу авторегистраторов и патрульных.<br/>
	 * Метод получает из переданного в параметрах наряда (dutyTour) список
	 * патрульных инспекторов и автоматических регистраторов. Для каждого
	 * автоматического регистратора (AutomaticRecorder) и патрульного инспектора
	 * (PatrolInspector), из полученных списков, метод устанавливает значение
	 * поля running равным true, а так же создает и запускает соответствующие
	 * потоки (Threads). В каждом созданном потоке выполняется метод run,
	 * соответствующий автоматическому регистратору или патрульному инспектору.
	 * 
	 * @param dutyTour
	 */
	public void startDutyTour(DutyTour dutyTour) {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	/**
	 * Останавливает работу авторегистраторов и патрульных.<br/>
	 * Метод получает из переданного в параметрах наряда список патрульных
	 * инспекторов и автоматических регистраторов. Для каждого автоматического
	 * регистратора (AutomaticRecorder) и патрульного инспектора
	 * (PatrolInspector), из полученных списков, устанавливает значение поля
	 * running равным false, тем самым прекращая работу соответствующих потоков
	 * (Threads).
	 * 
	 * @param dutyTour
	 */
	public void finishDutyTour(DutyTour dutyTour) {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	/**
	 * Создает объект типа наряд и записывает его в базу данных. <br/>
	 * Метод создает объект класса DutyTour с заданными параметрами, затем
	 * записывает его базу данных (вызывает метод insert() созданного объекта) и
	 * возвращает его.
	 * 
	 * @param inspectors
	 * @param recorders
	 * @param startDate
	 * @param finishDate
	 * @return
	 */
	public DutyTour createDutyTour(Set<PatrolInspector> inspectors,
			Set<AutomaticRecorder> recorders, Date startDate, Date finishDate) {
		DutyTour dutyTour = new DutyTour(inspectors, recorders, this,
				startDate, finishDate);
		dutyTour.insert();
		return dutyTour;
	}

	/**
	 * Изменяет параметры объекта типа наряд и записывает его в базу данных. <br/>
	 * Метод изменяет значение полей объекта класса dutyTour на соответствующие
	 * значения заданные в параметрах, затем обновляет представление объекта в
	 * базе данных (вызывает метод update() для заданного объекта).
	 * 
	 * @param dutyTour
	 * @param startDate
	 * @param finishDate
	 */
	public void updateDutyTour(DutyTour dutyTour, Date startDate,
			Date finishDate) {
		dutyTour.setDutyInspector(this);
		dutyTour.setFinishDate(finishDate);
		dutyTour.setStartDate(startDate);
		dutyTour.update();
	}

	/**
	 * Удаляет объект типа наряд. <br/>
	 * Метод удаляет представление объекта класса DutyTour из базы данных
	 * (вызывает метод delete() для заданного объекта).
	 * 
	 * @param dutyTour
	 */
	public void deleteDutyTour(DutyTour dutyTour) {
		dutyTour.delete();
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

}
