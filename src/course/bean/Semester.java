package course.bean;

import java.io.Serializable;
import java.util.Date;

public class Semester implements Serializable{
	private Date startDate;
	private Date endDate;
	private String semesterNumber;
	private int year;
	private String semesterType;
	/**
	 * 
	 */
	public Semester() {
		super();
	}
	
	
	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getSemesterType() {
		return semesterType;
	}


	public void setSemesterType(String semesterType) {
		this.semesterType = semesterType;
	}


	public String getSemesterNumber() {
		return semesterNumber;
	}
	public void setSemesterNumber(String semesterNumber) {
		this.semesterNumber = semesterNumber;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString(){
		return getSemesterNumber();
	}
	public boolean equals(Semester semester){
		boolean b = false;
		if (getSemesterNumber().equals(semester.getSemesterNumber()))
			b = true;
		return b;
	}
}
