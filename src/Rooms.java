public class Rooms {

	private string building;
	private string roomNumber;
	private int capacity;

	public string getBuilding() {
		return this.building;
	}

	public string getRoomNumber() {
		return this.roomNumber;
	}

	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * 
	 * @param building
	 */
	public void setBuilding(string building) {
		this.building = building;
	}

	/**
	 * 
	 * @param roomNumber
	 */
	public void setRoomNumber(string roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * 
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}