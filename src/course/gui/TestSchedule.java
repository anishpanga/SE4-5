package course.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import course.bean.Course;
import course.bean.DegreePlan;
import course.bean.Schedule;
import course.bean.Section;
import course.bean.Semester;
import course.bean.Student;
import course.main.CourseScheduler;

public class TestSchedule extends HomeFrame1 implements ActionListener{

	private JPanel panel;
	private JTextField t1,t2;
	private JComboBox jb;
	private JButton b1;
	private JLabel l1,l2,l3,l4;
	private Object[] schedules;
	public TestSchedule(){
		initComponents();
	}
	private void initComponents(){
		int num,i =0;
		num = CourseScheduler.scheduleTable.size();
		schedules = new String[num];
		Enumeration e = CourseScheduler.scheduleTable.keys();
		while(e.hasMoreElements()){
			schedules[i] = (String)e.nextElement();
		}
		l3 = new JLabel("Section Fill %");
		l4 = new JLabel("Section Overage %");
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		jb = new JComboBox(schedules);
		l1 = new JLabel("Select Semester");
		b1 = new JButton("Test Schedule");
		b1.addActionListener(this);
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(l3,gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		panel.add(t1,gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		panel.add(l4,gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;
		panel.add(t2,gbc);
		gbc.gridx = 1;
		gbc.gridy = 6;
		panel.add(l1,gbc);
		gbc.gridx = 2;
		gbc.gridy = 6;
		panel.add(jb,gbc);
		gbc.gridx = 2;
		gbc.gridy = 10;
		panel.add(b1,gbc);
		this.add(panel,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent ae){
		JLabel l1,l2,l3,l4,l5,l6;
		JPanel p;
		String desc;
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			p = new JPanel(new GridLayout(10,1,10,10));
			
			int csecfill=0,numsecabvcap=0,numstudents=0,numSRC =0;
			System.out.println("Test S");
			String semNumber = (String)jb.getSelectedItem();
			Schedule schedule = (Schedule)CourseScheduler.scheduleTable.get(semNumber);
			List sections = schedule.getSections();
			// finding number of students
			
			// finding number of sections
			System.out.println("Number of Sections --  "+sections.size());
			desc = "Number of Sections  "+sections.size();
			l1 = new JLabel(desc);
			// finding number of sections below section fill
			int sf = Integer.parseInt(t1.getText());
			int so = Integer.parseInt(t2.getText());
			for(int i=0;i<sections.size();i++){
				Section section = (Section)sections.get(i);
				int cc = section.getCourse().getCapacity();
				int sfn = Math.round(cc*sf/100f);
				int sc = section.getStudentsAssigned().size();
				numstudents +=sc;
				if (sc<sfn){
					csecfill++;
				}
				if (sc>cc){
					numsecabvcap++;
				}
				List students = section.getStudentsAssigned();
				numSRC = numSRC + findStudentswithRequiredCourses(section, students);
			}// end of for
			System.out.println("Number of Students"+numstudents);
			desc = "Number of Students "+numstudents;
			l4 = new JLabel(desc);
			System.out.println("Number of Students WithRequiredCourses"+numSRC);
			desc = "Number of Students WithRequiredCourses"+numSRC;
			l5 = new JLabel(desc);
			System.out.println("Number of sections below section fill"+csecfill);
			desc = "Number of sections below section fill "+csecfill;
			l2 = new JLabel(desc);
			System.out.println("Number of sections above sec capacity "+numsecabvcap);
			desc = "Number of sections above sec capacity "+numsecabvcap;
			l3 = new JLabel(desc);
			p.add(l4);p.add(l5);
			p.add(l1);p.add(l2);p.add(l3);
			JFrame ss = new ShowStatistics(p);
			this.dispose();
			ss.setVisible(true);
			//this.remove(panel);
			//this.add(hl,BorderLayout.NORTH);
			//this.add(p,BorderLayout.CENTER);
		}
	}
	
	public int findStudentswithRequiredCourses(Section section,List students){
		int numStudentswithRCourses =0;
		Semester sem = section.getSemester();
		Course course = section.getCourse();
		for(int i=0;i<students.size();i++){
			Student s = (Student)students.get(i);
			List scs = s.getCoursesPerSemester(sem);
			if (scs.contains(course))
				numStudentswithRCourses++;
		}//end of for
		return numStudentswithRCourses;
	}
}
