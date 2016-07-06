package course.bean;

public class Forecast {
	
	private DegreePlan degreeplan;
	private Semester semester;
	private int forecast;
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
	public int getForecast() {
		return forecast;
	}
	public void setForecast(int forecast) {
		this.forecast = forecast;
	}
	
	

}
