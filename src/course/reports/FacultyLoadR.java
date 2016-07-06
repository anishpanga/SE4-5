package course.reports;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import course.bean.Faculty;
import course.bean.Schedule;
import course.bean.Section;
import course.bean.Semester;
import course.gui.HomeFrame1;
import course.gui.ShowFacultyLoadR;
import course.main.CourseScheduler;

public class FacultyLoadR extends HomeFrame1 implements ActionListener{

	private JLabel l7;
	private JTable jt1;
	private JComboBox jb;
	private JButton b1;
	private JPanel panel,rpanel;
	private String[] colNames = {"Faculty Name","Courses/Section Assigned","Teaching Load"};
	private Vector colV,dataV,rowV;
	JScrollPane jp;
	public FacultyLoadR(){
		initComponents();
	}
	private void initComponents(){
		List sems = CourseScheduler.university.getSemesters();
		jb = new JComboBox(sems.toArray());
		b1 = new JButton("FacultyLoad");
		b1.addActionListener(this);
		panel = new JPanel();
		panel.add(jb);
		panel.add(b1);
		
		// sample data;
				
		l7 = new JLabel(" Faculty Report ");
		l7.setFont(new java.awt.Font("Tahoma", 1, 24));
		
		//setLayout(new BorderLayout());
		this.add(l7,BorderLayout.PAGE_START);
		this.add(panel,BorderLayout.CENTER);

}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			Semester sem = (Semester)jb.getSelectedItem();
			getFacultyReport(sem);
		}
	}
	
	public void getFacultyReport(Semester semester){
		rpanel = new JPanel();
		colV = new Vector(Arrays.asList(colNames));
		rowV = new Vector();
		Schedule schedule = (Schedule)CourseScheduler.scheduleTable.get(semester.getSemesterNumber());
		if (schedule==null){
			JOptionPane.showMessageDialog(null, "Schedule does not exits");
		}else{
		List sections = schedule.getSections();
		Enumeration e = CourseScheduler.facultyTable.elements();
		while (e.hasMoreElements()){
			List facultySections = new ArrayList();
			Faculty f = (Faculty)e.nextElement();
			for(int i=0;i<sections.size();i++){
				Section section = (Section)sections.get(i);
				Faculty sf =section.getFaculty();
				if (sf != null ){
					if (f.equals(sf))
						facultySections.add(section.getSectionNumber());
				}
			}
			dataV = new Vector();
			dataV.add(f);
			dataV.add(facultySections);
			if (facultySections.size()!=0){
				
				// calculating loa d of faculty
				int wd = findWorkingDays(semester, f);
				int load = wd * facultySections.size();
				dataV.add(new Integer(load));
			}
			else
				dataV.add(new Integer(0));
			rowV.add(dataV);
	}// end of while
		jt1 = new JTable(rowV,colV);
		jp = new JScrollPane(jt1);
		rpanel.add(jp);
		JFrame sfr = new ShowFacultyLoadR(rpanel);
		this.dispose();
		sfr.setVisible(true);
		}
			
	}

	public int findWorkingDays(Semester semester,Faculty f){
		int numDays=0,whichDay=0;
		Date start = semester.getStartDate();
		Date end = semester.getEndDate();
		Calendar startC = Calendar.getInstance();
		
		Calendar endC = Calendar.getInstance();
		
		
		String teachingDays = f.getDaystoTeach();
		System.out.println(teachingDays);
		for(int index=0;index<teachingDays.length();index++){
			int numWDays =0;
			char d = teachingDays.charAt(index);
			if (d=='M')
				whichDay = Calendar.MONDAY;
			if (d=='T')
				whichDay = Calendar.TUESDAY;
			if (d=='W')
				whichDay = Calendar.WEDNESDAY;
			if (d=='R')
				whichDay = Calendar.THURSDAY;
			if (d=='F')
				whichDay = Calendar.FRIDAY;
			startC.setTime(start);
			endC.setTime(end);
		while(startC.before(endC)){
			if (startC.get(Calendar.DAY_OF_WEEK) == whichDay){
				numWDays++;
				startC.add(Calendar.DATE,7);
			}else{
				startC.add(Calendar.DATE, 1);
			}
		}// end of while
		//System.out.println("number of  "+whichDay+" =  "+numWDays);
		numDays = numDays+numWDays;
		
	}//end of for
		System.out.println("Working load for one section  =  "+numDays);
		return numDays;
	}
}