package course.bean;

import java.io.Serializable;

public class StudentCourseGrade implements Serializable{
	
	//private Student student;
	private String coursecode;
	private String cname;
	private String semester;
	private String grade;
	
	
	/**
	 * @param coursecode
	 * @param cname
	 * @param semester
	 * @param grade
	 */
	public StudentCourseGrade(String coursecode, String cname, String semester,
			String grade) {
		super();
		this.coursecode = coursecode;
		this.cname = cname;
		this.semester = semester;
		this.grade = grade;
	}
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
		

}
