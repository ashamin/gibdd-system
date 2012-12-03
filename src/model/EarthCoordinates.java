package model;

/**
 * Класс координаты. <br/>
 * Содержит информацию о координатах объекта. Также реализует строковое
 * представление объекта.
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 * 
 */
public class EarthCoordinates {

	/**
	 * 
	 */
	private double latitude;

	/**
	 * 
	 */
	private double longitude;

	/**
	 * Конструктор по умолчанию для класса EarthCoordinates. <br/>
	 * Создает экземпляр класса со стандартными значениями полей класса
	 * ''Координаты''.
	 */
	public EarthCoordinates() {
		this.latitude = 0.0;
		this.longitude = 0.0;
	}

	/**
	 * Создает объект соответствующий местоположению объекта. <br/>
	 * В параметрах передаются широта и долгота, обозначающиеся соответственно:
	 * latitude и longitude.
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
	 * параметров входного экземпляра класса EarthCoordinates). Входным
	 * параметром является объект класса EarthCoordinates.
	 * 
	 * @param coordinates
	 */
	public EarthCoordinates(EarthCoordinates coordinates) {
		this.latitude = coordinates.latitude;
		this.longitude = coordinates.longitude;
	}

	/**
	 * Возвращает расстояние от данной точки до точки, заданной в параметрах. <br/>
	 * Входящий параметр coordinates обозначает поле “Координаты объекта”.
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
	 * Устанавливает широту объекта равную значению, указанному в параметрах. <br/>
	 * Входящий параметр latitude обозначает поле “Широта”.
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
	 * Устанавливает координаты объекта равными значениям указанным в
	 * параметрах. <br/>
	 * Входящий параметр longitude обозначает поле “Долгота”.
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
