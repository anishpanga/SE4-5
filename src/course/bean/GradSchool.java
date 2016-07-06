package course.bean;

import java.io.Serializable;
import java.util.List;

public class GradSchool implements Serializable{

	private String gradschoolname;
	private String abbr;
	private List degreePlansOffered;
	/**
	 * 
	 */
	public GradSchool() {
		super();
	}
	public String getGradschoolname() {
		return gradschoolname;
	}
	public void setGradschoolname(String gradschoolname) {
		this.gradschoolname = gradschoolname;
	}
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	
	public List getDegreePlansOffered() {
		return degreePlansOffered;
	}
	public void setDegreePlansOffered(List degreePlansOffered) {
		this.degreePlansOffered = degreePlansOffered;
	}
	public String toString(){
		return getAbbr()+":"+getGradschoolname();
	}
	
}
