package course.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import course.bean.Course;
import course.bean.Faculty;
import course.bean.Schedule;
import course.bean.Section;
import course.bean.Semester;
import course.bean.Student;
import course.main.CourseScheduler;

public class GenerateSchedule extends HomeFrame1 implements ActionListener
{
	private JPanel panel,bpanel;
	private JTextField t1,t2;
	private JLabel l1,l2,l3,l4;
	private JComboBox jb;
	private JButton b1,b2;
	private Schedule schedule;
	public GenerateSchedule(){
		initComponents();
	}
	private void initComponents(){
		List semesters;
		semesters = CourseScheduler.university.getSemesters();
		jb = new JComboBox(semesters.toArray());
		panel = new JPanel(new GridLayout(4,2,10,10));
		l1 = new JLabel("Section Fill %");
		l2 = new JLabel("Section Overage %");
		l3 = new JLabel("Semester");
		l4 = new JLabel("Generate Schedule Form");
		l4.setFont(new Font("Tahoma",1,18));
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		b1 = new JButton("Generate Schedule");
		b1.addActionListener(this);
		b2 = new JButton("Cancel");
		b2.addActionListener(this);
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		panel.add(l1);panel.add(t1);
		panel.add(l2);panel.add(t2);
		panel.add(l3);
		panel.add(jb);
		bpanel = new JPanel();
		bpanel.add(b1);bpanel.add(b2);
		panel.add(bpanel);
		this.add(l4,BorderLayout.NORTH);
		this.add(panel,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			int sectionfill,sectionOverage;
			System.out.println("button clicked");
			Semester sem = (Semester)jb.getSelectedItem();
			sectionfill = Integer.parseInt(t1.getText());
			sectionOverage = Integer.parseInt(t2.getText());
			genSchedule(sem,sectionfill,sectionOverage);
		}
		if (ae.getSource()==b2){
			JFrame sh = new showHome();
			this.dispose();
			sh.setVisible(true);
		}
	}
	
	public void genSchedule(Semester sem,int sectionfill,int sectionOverage){
		int num;
		List studentList;
		Hashtable coursestudents = new Hashtable();
		Enumeration e = CourseScheduler.coursesTable.elements();
		while(e.hasMoreElements()){
			Course c = (Course)e.nextElement();
			num=0;studentList = new ArrayList();
			Enumeration e1 = CourseScheduler.students.elements();
			while(e1.hasMoreElements()){
				Student s = (Student)e1.nextElement();
		
				List courses = s.getCoursesPerSemester(sem);
				System.out.println("Studentid --  "+s.getStudentid()+"Courses -- "+courses);
				if (courses.contains(c.getCourseCode())){
					num++;
					studentList.add(s);
				}
			}// end of while
			//coursestudents.put(c, new Integer(num));
			coursestudents.put(c, studentList);
		}// end of outer while
		//printing hashtable daat
		Enumeration e2 = coursestudents.keys();
		while(e2.hasMoreElements()){
			Course c = (Course)e2.nextElement();
			//int ns = ((Integer)coursestudents.get(c)).intValue();
			System.out.println("Course Code --"+c.getCourseCode());
		}
		// Creating Sections based on hash table
		List sections = new ArrayList();
		int numSections=0;
		Enumeration e3 = coursestudents.keys();
		while(e3.hasMoreElements()){
			Course c = (Course)e3.nextElement();
			//int ns = ((Integer)coursestudents.get(c)).intValue();
			List stList = (List)coursestudents.get(c);
			int ns = stList.size();
			if (ns!=0){
				//create section
				//findSectionCapacity(ns, c.getCapacity(), sectionfill, sectionOverage);
				int cp = c.getCapacity();
				numSections = ns/cp;
				int m = ns%cp;
				if (m!=0)
					numSections++;
				List sl = createSections(c,sem,numSections,sectionfill,sectionOverage,stList);
				sections.addAll(sl);
			}
		}// end of while
		// assigning faculty
		
		
		assignFaculty(sections);
		
		
		// creating schedule with sections
		this.schedule = new Schedule();
		schedule.setSections(sections);
		schedule.setSemester(sem);
		// saving Schedule in hash table
		
		if (CourseScheduler.scheduleTable.containsKey(sem.getSemesterNumber()))
			CourseScheduler.scheduleTable.remove(sem.getSemesterNumber());
		CourseScheduler.scheduleTable.put(sem.getSemesterNumber(), this.schedule);
		JOptionPane.showMessageDialog(null, "Schedule Generated");
		JFrame ss = new ShowSchedule(this.schedule);
		this.dispose();
		ss.setVisible(true);
		// Displaying the sections
		//displaySections(sections);
	}
	public List createSections(Course c,Semester semester,int n,int sectionfill,int sectionOverage,List stList){
		int sectionfillN,sectionOverageN,available,k;
		Student st = null;
		sectionfillN = Math.round(c.getCapacity()*sectionfill/100f);
		sectionOverageN = Math.round(c.getCapacity()*sectionOverage/100f);
		
		List sections = new ArrayList();
		for(int i =1;i<=n;i++){
			List slist = new ArrayList();
			Section s = new Section();
			s.setSemester(semester);
			s.setCourse(c);
			s.setFaculty(null);
			// assign faculty
			assignFaculty(s);
			String sectionNumber = c.getCourseCode()+"-"+i;
			s.setSectionNumber(sectionNumber);
			s.setCapacity(sectionOverageN);
			s.setAvailable(c.getCapacity());
			available = s.getAvailable();
			k =0;
			do{
				st = (Student)stList.get(k);
				slist.add(st);
				stList.remove(st);
				k++;
			}while(k<stList.size() && k<available && st != null);
			
			s.setStudentsAssigned(slist);
			s.setNumStudents(slist.size());
			sections.add(s);
		}
		return sections;
	}
	public void displaySections(List sections){
		for(int i=0;i<sections.size();i++){
			Section s =(Section)sections.get(i);
			System.out.println("Course--"+s.getCourse()+"  Section--"+s.getSectionNumber());
			System.out.println(s.getStudentsAssigned());
			System.out.println("Faculty "+s.getFaculty());
		}
	}
	
	public void assignFaculty(List sections){
		List asFaculty = new ArrayList();
		for(int i=0;i<sections.size();i++){
			Faculty assignedF = null;
			Section s = (Section)sections.get(i);
			Course c = s.getCourse();
			Semester sem = s.getSemester();
			System.out.println("sem type -- "+sem.getSemesterType());
			Enumeration e = CourseScheduler.facultyTable.elements();
			do{
				Faculty f = (Faculty)e.nextElement();
				List coursesTaught = f.getCoursesTaught();
				//System.out.println("FacultyName  "+f.getLastName()+"  Courses --"+coursesTaught);
				if (coursesTaught.contains(c) && !asFaculty.contains(f)){
					String semType = sem.getSemesterType();
					if (semType.equals("Summer") && f.getMaxLoadSummmer()!=0)
						assignedF = f;
					if (semType.equals("Spring") && f.getMaxLoadSpring()!=0)
						assignedF = f;
					if (semType.equals("Fall") && f.getMaxLoadFall()!=0)
						assignedF = f;
					
				} //end of if
			}while(assignedF==null && e.hasMoreElements());
			s.setFaculty(assignedF);
			asFaculty.add(assignedF);
		}// end of for
	}
	
	public void assignFaculty(Section s){
		Enumeration e = CourseScheduler.facultyTable.elements();
		do{
			Faculty f = (Faculty)e.nextElement();
			f.canTeachSection(s);
		}while(e.hasMoreElements());
	}
	
}
