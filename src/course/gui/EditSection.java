package course.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import course.bean.Faculty;
import course.bean.Schedule;
import course.bean.Section;
import course.bean.Semester;
import course.main.CourseScheduler;

public class EditSection extends HomeFrame1{

	private Section section;
	private Schedule schedule;
	private JPanel panel,bpanel;
	private JLabel l1,l2,l3,l4,l5,l6,l7;
	private JTextField t1;
	private JComboBox jb;
	private JButton b1,b2,b3;
	private List sections;
	public EditSection(Schedule schedule,Section section){
		this.schedule = schedule;
		this.section = section;
		initComponents();
	}
	private void initComponents(){
		int num,i=0;
		Object[] faculty;
		num = CourseScheduler.facultyTable.size();
		faculty = new Object[num];
		Enumeration e = CourseScheduler.facultyTable.elements();
		while(e.hasMoreElements()){
			faculty[i] = e.nextElement();
			i++;
		}
		sections = schedule.getSections();
		sections.remove(section);
		panel = new JPanel(new GridLayout(5,2,10,10));
		l1 = new JLabel("Section Number");
		l5 = new JLabel(section.getSectionNumber());
		l2 = new JLabel("Semester");
		l6 = new JLabel(section.getSemester().getSemesterNumber());
		l3 = new JLabel("Number of Students");
		t1 = new JTextField(20);
		t1.setText(Integer.toString(section.getNumStudents()));
		l4 = new JLabel("Faculty");
		jb = new JComboBox(faculty);
		jb.setSelectedItem(section.getFaculty());
		l7 = new JLabel("Edit Section");
		l7.setFont(new Font("Tahoma",1,24));
		b1 = new JButton("Edit Section");
		b3 = new JButton("Delete Section");
		b2 = new JButton("Cancel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		panel.add(l1);panel.add(l5);
		panel.add(l2);panel.add(l6);
		panel.add(l3);panel.add(t1);
		panel.add(l4);panel.add(jb);
		bpanel = new JPanel();
		bpanel.add(b1);bpanel.add(b3);bpanel.add(b2);
		panel.add(bpanel);
		this.add(l7,BorderLayout.NORTH);
		this.add(panel,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			int ns = Integer.parseInt(t1.getText());
			Faculty f = (Faculty)jb.getSelectedItem();
			this.section.setNumStudents(ns);
			this.section.setFaculty(f);
			sections.add(section);
			this.schedule.setSections(sections);
			Semester sem = this.schedule.getSemester();
			// updating in the hashtable
			CourseScheduler.scheduleTable.remove(sem.getSemesterNumber());
			CourseScheduler.scheduleTable.put(sem.getSemesterNumber(), this.schedule);
			JOptionPane.showMessageDialog(null, "Section Updated");
			JFrame es = new EditSchedule(this.schedule);
			this.dispose();
			es.setVisible(true);
		}
		if (ae.getSource()==b3){
			int indexS = sections.indexOf(this.section);
			System.out.println("indesof deleted sec  "+indexS);
			sections.remove(this.section);
			this.schedule.setSections(sections);
			Semester sem = this.schedule.getSemester();
			// updating in the hashtable
			CourseScheduler.scheduleTable.remove(sem.getSemesterNumber());
			CourseScheduler.scheduleTable.put(sem.getSemesterNumber(), this.schedule);
			JOptionPane.showMessageDialog(null, "Section Removed");
			JFrame es = new EditSchedule(this.schedule);
			this.dispose();
			es.setVisible(true);
		}
		if (ae.getSource()==b2){
			JFrame es = new EditSchedule(this.schedule);
			this.dispose();
			es.setVisible(true);
		}
	}
}
