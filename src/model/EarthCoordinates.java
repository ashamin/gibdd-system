package model;

/**
 * Класс координаты. Объект координаты. Содержит широту и долготу. <br/>
 * <br/>
 * Функция абстракции <br/>
 * <br/>
 * Класс EarthCoordinates характеризуется следующими полями: latitude, longitude <br/>
 * <ul>
 * <li>A(latitude) = Широта</li>
 * <li>A(longitude) = Долгота</li>
 * </ul>
 * <br/>
 * <br/>
 * Инвариант представления <br/>
 * <ul>
 * <li>latitude - принадлежит интервалу [-180, 180]</li>
 * <li>longitude - принадлежит интервалу [-90, 90]</li>
 * </ul>
 * <br/>
 * <br/>
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class EarthCoordinates {

	/**
	 * Широта
	 */
	private double latitude;

	/**
	 * Долгота
	 */
	private double longitude;

	/**
	 * Конструктор по умолчанию для класса EarthCoordinates. <br/>
	 * Создает экземпляр класса со стандартными значениями полей класса
	 * 'Координаты'.
	 */
	public EarthCoordinates() {
		this.latitude = 0.0;
		this.longitude = 0.0;
	}

	/**
	 * Создает объект соответствующий местоположению объекта.
	 * 
	 * @param latitude
	 * @param longitude
	 */
	public EarthCoordinates(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Конструктор копирования для класса EarthCoordinates. <br/>
	 * Создает копию объекта EarthCoordinates(объект с идентичными значениями
	 * параметров входного экземпляра класса EarthCoordinates).
	 * 
	 * @param coordinates
	 */
	public EarthCoordinates(EarthCoordinates coordinates) {
		this.latitude = coordinates.latitude;
		this.longitude = coordinates.longitude;
	}

	/**
	 * Возвращает расстояние от данной точки до точки в декартовой системе
	 * координат.
	 * 
	 * @param coordinates
	 * @return
	 */
	public double distance(EarthCoordinates coordinates) {
		// TODO implement distance between two points
		throw new UnsupportedOperationException("not implemented");
	}

	/**
	 * Возвращает строковое представление объекта.
	 */
	public String toString() {
		// TODO implement string representation of the object
		throw new UnsupportedOperationException("not implemented");
	}

	/**
	 * Устанавливает широту объекта.
	 * 
	 * @param latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Возвращает широту.
	 * 
	 * @return
	 */
	public double getLatitude() {
		return this.latitude;
	}

	/**
	 * Устанавливает долготу объекта.
	 * 
	 * @param longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Возвращает долготу.
	 * 
	 * @return
	 */
	public double getLongitude() {
		return this.longitude;
	}

}
