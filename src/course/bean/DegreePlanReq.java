package course.bean;

import java.io.Serializable;
import java.util.List;

public class DegreePlanReq implements Serializable{
	private String degreecode;
	private String type;
	private String Description;
	private int numCourses;
	private int hours;
	private List courses;
	
	
	public String getDegreecode() {
		return degreecode;
	}
	public void setDegreecode(String degreecode) {
		this.degreecode = degreecode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getNumCourses() {
		return numCourses;
	}
	public void setNumCourses(int numCourses) {
		this.numCourses = numCourses;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public List getCourses() {
		return courses;
	}
	public void setCourses(List courses) {
		this.courses = courses;
	}
	
	

}
