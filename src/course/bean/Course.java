package course.bean;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable{
	
	private String courseCode;
	private String courseName;
	private String courseDesc;
	private int creditsEarned;
	private int capacity;
	private List prerequisites;
	private boolean offeredSummer;
	private boolean offeredSpring;
	private boolean offeredFall;
	
	/**
	 * 
	 */
	public Course() {
		super();
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	public int getCreditsEarned() {
		return creditsEarned;
	}
	public void setCreditsEarned(int creditsEarned) {
		this.creditsEarned = creditsEarned;
	}
	public List getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(List prerequisites) {
		this.prerequisites = prerequisites;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/*public int[] getSemestersOffered() {
		return semestersOffered;
	}
	public void setSemestersOffered(int[] semestersOffered) {
		this.semestersOffered = semestersOffered;
	}*/
	
	
	
	public String toString(){
		return getCourseCode()+": "+getCourseName();
	}
	public boolean isOfferedSummer() {
		return offeredSummer;
	}
	public void setOfferedSummer(boolean offeredSummer) {
		this.offeredSummer = offeredSummer;
	}
	public boolean isOfferedSpring() {
		return offeredSpring;
	}
	public void setOfferedSpring(boolean offeredSpring) {
		this.offeredSpring = offeredSpring;
	}
	public boolean isOfferedFall() {
		return offeredFall;
	}
	public void setOfferedFall(boolean offeredFall) {
		this.offeredFall = offeredFall;
	}
	public boolean equals(Course c){
		boolean b = false;
		if (this.getCourseCode().equals(c.getCourseCode()))
			b = true;
		return b;
	}
}
