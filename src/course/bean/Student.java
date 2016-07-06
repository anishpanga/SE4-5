package course.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable{

	private String studentid;
	private DegreePlan degreeplan;
	private Semester semester;
	private List studentcoursegrades;
	/**
	 * 
	 */
	public Student() {
		super();
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public DegreePlan getDegreeplan() {
		return degreeplan;
	}
	public void setDegreeplan(DegreePlan degreeplan) {
		this.degreeplan = degreeplan;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public List getStudentcoursegrades() {
		return studentcoursegrades;
	}
	public void setStudentcoursestatus(List studentcoursegrades) {
		this.studentcoursegrades = studentcoursegrades;
	}
	//  this method gives the courses for student irrespective of semester
	public List getStudentCourses(){
		List sc=new ArrayList();
		for(int k=0;k<this.studentcoursegrades.size();k++){
			StudentCourseGrade scs = (StudentCourseGrade)studentcoursegrades.get(k);
			sc.add(scs.getCoursecode());
		}
		return sc;
	}
	
	public List getCoursesPerSemester(Semester semester){
		List sc = new ArrayList();
		String semesternumber = semester.getSemesterNumber();
		for(int k=0;k<getStudentcoursegrades().size();k++){
			StudentCourseGrade scs = (StudentCourseGrade)getStudentcoursegrades().get(k);
			if (semesternumber.equals(scs.getSemester())&& "CIP".equals(scs.getGrade())){
				sc.add(scs.getCoursecode());
			}
		}
		return sc;
	}
	
	public String toString(){
		return getStudentid();
	}
}
