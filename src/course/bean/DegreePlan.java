package course.bean;

import java.io.Serializable;
import java.util.List;

public class DegreePlan implements Serializable{
	
	private String name;
	private String dept;
	private String track;
	private String degreeCode;
	private int  semForecast;
	private List degreePlanRequirements;
/*	private List requiredCourses;
	private int numhrsReqCourses;
	private List firstElective;
	private int numhrsFirstElective;
	private List secondElective;
	private int numhrsSecondElective;*/
	/**
	 * 
	 */
	public DegreePlan() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDegreeCode() {
		return degreeCode;
	}
	public void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}
	public int getSemForecast() {
		return semForecast;
	}
	public void setSemForecast(int semForecast) {
		this.semForecast = semForecast;
	}
	
/*	public List getRequiredCourses() {
		return requiredCourses;
	}
	public void setRequiredCourses(List requiredCourses) {
		this.requiredCourses = requiredCourses;
	}
	public int getNumhrsReqCourses() {
		return numhrsReqCourses;
	}
	public void setNumhrsReqCourses(int numhrsReqCourses) {
		this.numhrsReqCourses = numhrsReqCourses;
	}
	public List getFirstElective() {
		return firstElective;
	}
	public void setFirstElective(List firstElective) {
		this.firstElective = firstElective;
	}
	public int getNumhrsFirstElective() {
		return numhrsFirstElective;
	}
	public void setNumhrsFirstElective(int numhrsFirstElective) {
		this.numhrsFirstElective = numhrsFirstElective;
	}
	public List getSecondElective() {
		return secondElective;
	}
	public void setSecondElective(List secondElective) {
		this.secondElective = secondElective;
	}
	public int getNumhrsSecondElective() {
		return numhrsSecondElective;
	}
	public void setNumhrsSecondElective(int numhrsSecondElective) {
		this.numhrsSecondElective = numhrsSecondElective;
	} */
	
	
	
	public String getTrack() {
		return track;
	}
	
	public void setTrack(String track) {
		this.track = track;
	}
	
	public List getDegreePlanRequirements() {
		return degreePlanRequirements;
	}
	public void setDegreePlanRequirements(List degreePlanRequirements) {
		this.degreePlanRequirements = degreePlanRequirements;
	}
	
	public String toString(){
		return getDegreeCode()+": "+getName();
	}
	
}
