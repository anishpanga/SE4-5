package course.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import course.bean.Student;
import course.bean.StudentCourseGrade;
import course.main.CourseScheduler;

public class ShowStudents extends HomeFrame1 implements ActionListener{
	private JButton b1,b2;
	private JPanel panel,tpanel;
	private JTable jt;
	private DefaultTableModel tablemodel;
	public ShowStudents(){
		initComponents();
	}
	private void initComponents(){
		int num,i=0;
		Object[] labels={"Student ID","Degree Plan","Semester","Courses"};
		Object[][] rows;
		num = CourseScheduler.students.size();
		rows = new Object[num][4];
		tablemodel = new DefaultTableModel();
		Enumeration e = CourseScheduler.students.elements();
		while(e.hasMoreElements()){
			Student s =(Student)e.nextElement();
			rows[i][0] = s.getStudentid();
			rows[i][1] = s.getDegreeplan();
			rows[i][2] = s.getSemester();
			List sc = s.getStudentCourses();
			rows[i][3] = sc;
			i++;
		}
		tablemodel = new DefaultTableModel(rows,labels);
		jt = new JTable(tablemodel);
		tpanel = new JPanel();
		tpanel.add(new JScrollPane(jt));
		b1 = new JButton("Update");
		b2 = new JButton("Cancel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		panel = new JPanel(new GridBagLayout());
		panel.add(b1);panel.add(b2);
		this.add(panel,BorderLayout.NORTH);
		this.add(tpanel,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		
		if (ae.getSource()==b2){
			JFrame sh = new showHome();
			this.dispose();
			sh.setVisible(true);
		}
	}
}
