package course.bean;

import java.io.Serializable;
import java.util.List;

public class Faculty implements Serializable{

//	private String facultyid;
	private String firstName;
	private String lastName;
	//private int coursesPerSem;
	//private String availability;
	private String degree;
	private String title;
	private List coursesTaught;
	private int maxLoadSummmer;
	private int maxLoadSpring;
	private int maxLoadFall;
	private String daystoTeach;
	/**
	 * 
	 */
	public Faculty() {
		super();
	}
	
	/*public String getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(String facultyid) {
		this.facultyid = facultyid;
	}*/

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	/*public int getCoursesPerSem() {
		return coursesPerSem;
	}
	public void setCoursesPerSem(int coursesPerSem) {
		this.coursesPerSem = coursesPerSem;
	}*/
	
	/*public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}*/

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMaxLoadSummmer() {
		return maxLoadSummmer;
	}

	public void setMaxLoadSummmer(int maxLoadSummmer) {
		this.maxLoadSummmer = maxLoadSummmer;
	}

	public int getMaxLoadSpring() {
		return maxLoadSpring;
	}

	public void setMaxLoadSpring(int maxLoadSpring) {
		this.maxLoadSpring = maxLoadSpring;
	}

	public int getMaxLoadFall() {
		return maxLoadFall;
	}

	public void setMaxLoadFall(int maxLoadFall) {
		this.maxLoadFall = maxLoadFall;
	}

	public List getCoursesTaught() {
		return coursesTaught;
	}

	public void setCoursesTaught(List coursesTaught) {
		this.coursesTaught = coursesTaught;
	}

	public String getDaystoTeach() {
		return daystoTeach;
	}

	public void setDaystoTeach(String daystoTeach) {
		this.daystoTeach = daystoTeach;
	}
	
	public String toString(){
		return getLastName();
	}
	
	public boolean equals(Faculty f){
		boolean b = false;
		if (this.getLastName().equals(f.getLastName()))
			b = true;
		return b;
	}
	public void canTeachSection(Section section){
		boolean canTeach = false;
		Course c = section.getCourse();
		String semType = section.getSemester().getSemesterType();
		if (getCoursesTaught().contains(c)){
			canTeach = true;
		}
		System.out.println("Name  "+getLastName()+"canTeach   "+canTeach);
	}
}
