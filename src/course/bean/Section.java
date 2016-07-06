package course.bean;

import java.io.Serializable;
import java.util.List;

public class Section implements Serializable{
	
	private String sectionNumber;
	private Course course;
	private Faculty faculty;
	private Semester semester;
	private int numStudents;
	private int available;
	private int capacity;
	private List studentsAssigned;
	
	public String getSectionNumber() {
		return sectionNumber;
	}
	public void setSectionNumber(String sectionNumber) {
		this.sectionNumber = sectionNumber;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public int getNumStudents() {
		return numStudents;
	}
	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public List getStudentsAssigned() {
		return studentsAssigned;
	}
	public void setStudentsAssigned(List studentsAssigned) {
		this.studentsAssigned = studentsAssigned;
	}
	
	public boolean equals(Section s){
		boolean b = false;
		if (getSemester().equals(s.getSemester()) && getSectionNumber().equals(s.getSectionNumber()))
			b = true;
		return b;
	}
	
}
