package course.bean;

import java.io.Serializable;
import java.util.List;

public class University implements Serializable{
	
	private String name;
	private String abbrevation;
	private List gradSchools;
	private List semesters;
	
	public University(){
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbrevation() {
		return abbrevation;
	}
	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}
	public List getGradSchools() {
		return gradSchools;
	}
	public void setGradSchools(List gradSchools) {
		this.gradSchools = gradSchools;
	}
	public List getSemesters() {
		return semesters;
	}
	public void setSemesters(List semesters) {
		this.semesters = semesters;
	}
	
	

}
