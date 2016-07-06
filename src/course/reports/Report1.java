package course.reports;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import course.bean.Schedule;
import course.bean.Semester;
import course.gui.HomeFrame1;
import course.gui.ShowSchedule;
import course.main.CourseScheduler;

public class Report1 extends HomeFrame1 implements ActionListener{

	private JLabel l7;
	private JTable jt1;
	private JPanel panel;
	private JComboBox jb;
	private JButton b1;
	private String[] colNames = {"Section Number","Course/Section","Faculty Assigned"};
	private Vector colV,dataV,rowV;
	JScrollPane jp;
	public Report1(){
		initComponents();
	}
	private void initComponents(){
		
		List sems = CourseScheduler.university.getSemesters();
		jb = new JComboBox(sems.toArray());
		b1 = new JButton("Schedule Report");
		b1.addActionListener(this);
		panel = new JPanel();
		panel.add(jb);
		panel.add(b1);
		
		// sample data;
				
		l7 = new JLabel(" Schedule Report ");
		l7.setFont(new java.awt.Font("Tahoma", 1, 24));
		
		//setLayout(new BorderLayout());
		this.add(l7,BorderLayout.PAGE_START);
		this.add(panel,BorderLayout.CENTER);

	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
		Semester sem = (Semester)jb.getSelectedItem();
		Schedule schedule = (Schedule)CourseScheduler.scheduleTable.get(sem.getSemesterNumber());
		if (schedule!=null){
			JFrame sr = new ShowSchedule(schedule);
			this.dispose();
			sr.setVisible(true);
		}else
			JOptionPane.showMessageDialog(null, "Schedule Does not Exist for sem");
		}
	}
}
