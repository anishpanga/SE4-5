package course.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import course.bean.Schedule;
import course.bean.Semester;
import course.main.CourseScheduler;

public class EditScheduleF extends HomeFrame1 implements ActionListener{
	
	private JPanel panel;
	private JComboBox jb;
	private Object[] skeys;
	private JButton b1;
	
	public EditScheduleF(){
		initComponents();
	}
	private void initComponents(){
		int num,i=0;
		num = CourseScheduler.scheduleTable.size();
		skeys = new Object[num];
		Enumeration e = CourseScheduler.scheduleTable.keys();
		while(e.hasMoreElements()){
			skeys[i] = e.nextElement();
			i++;
		}
		jb = new JComboBox(skeys);
		b1 = new JButton("EditSchedule");
		b1.addActionListener(this);
		panel = new JPanel();
		panel.add(jb);panel.add(b1);
		this.add(panel,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			String semesterNumber = (String)jb.getSelectedItem();
			Schedule schedule = (Schedule)CourseScheduler.scheduleTable.get(semesterNumber);
			JFrame es = new EditSchedule(schedule);
			this.setVisible(false);
			es.setVisible(true);
		}
	}
}
