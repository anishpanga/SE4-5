package course.bean;

import java.io.Serializable;
import java.util.List;

public class Schedule implements Serializable{
	
	private Semester semester;
	private List sections;
	private String status;
	
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public List getSections() {
		return sections;
	}
	public void setSections(List sections) {
		this.sections = sections;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
