public class Course {

	private string number;
	private string name;
	private string description;
	private int creditHours;
	private int capacity;
	private StringArray preRequisiteCourses;
	private string semester;

	public string getNumber() {
		return this.number;
	}

	public string getName() {
		return this.name;
	}

	public string getDescription() {
		return this.description;
	}

	public int getCreditHours() {
		return this.creditHours;
	}

	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * 
	 * @param number
	 */
	public void setNumber(String number) {
		// TODO - implement Course.setNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		// TODO - implement Course.setName
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		// TODO - implement Course.setDescription
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param creditHours
	 */
	public void setCreditHours(Integer creditHours) {
		// TODO - implement Course.setCreditHours
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param capacity
	 */
	public void setCapacity(Integer capacity) {
		// TODO - implement Course.setCapacity
		throw new UnsupportedOperationException();
	}

	public StringArray getPreRequisiteCourses() {
		return this.preRequisiteCourses;
	}

	/**
	 * 
	 * @param preRequisiteCourses
	 */
	public void setPreRequisiteCourses(StringArray preRequisiteCourses) {
		this.preRequisiteCourses = preRequisiteCourses;
	}

	public string getSemester() {
		return this.semester;
	}

	/**
	 * 
	 * @param semester
	 */
	public void setSemester(string semester) {
		this.semester = semester;
	}

}