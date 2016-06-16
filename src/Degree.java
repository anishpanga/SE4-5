public class Degree {

	private string name;
	private string department;
	private string track;
	private int code;
	private StringArray courseNumber;
	private IntegerArray hours;
	private boolean required;

	public string getName() {
		return this.name;
	}

	public string getDepartment() {
		return this.department;
	}

	public string getTrack() {
		return this.track;
	}

	public string getCode() {
		// TODO - implement Degree.getCode
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(string name) {
		this.name = name;
	}

	/**
	 * 
	 * @param department
	 */
	public void setDepartment(string department) {
		this.department = department;
	}

	/**
	 * 
	 * @param track
	 */
	public void setTrack(string track) {
		this.track = track;
	}

	/**
	 * 
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	public StringArray getCourseNumber() {
		return this.courseNumber;
	}

	/**
	 * 
	 * @param courseNumber
	 */
	public void setCourseNumber(StringArray courseNumber) {
		this.courseNumber = courseNumber;
	}

	public IntegerArray getHours() {
		return this.hours;
	}

	/**
	 * 
	 * @param hours
	 */
	public void setHours(IntegerArray hours) {
		this.hours = hours;
	}

	public boolean getRequired() {
		return this.required;
	}

	/**
	 * 
	 * @param required
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}

	public void getAttribute() {
		// TODO - implement Degree.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		// TODO - implement Degree.setAttribute
		throw new UnsupportedOperationException();
	}

}