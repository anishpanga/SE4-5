package course.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import course.bean.Course;
import course.main.CourseScheduler;

public class AddCourseForm extends HomeFrame1 implements ActionListener{

	private JLabel label1,label2,label3,label4,label5,label6,label7,l6;
	private JTextField tf1,tf2,tf4,tf5,tf6;
	private JTextArea tf3;
	private JCheckBox c1,c2,c3;
	private JButton b1,b2,b3;
	private JPanel panel,cpanel,bpanel;

	private JList l4,l7;
	private JScrollPane js1;
	private Course course;
	public AddCourseForm(){
		initComponents();
	}
	private void initComponents(){
		int i =0,num;
		num = CourseScheduler.coursesTable.size();
		Object[] prereqC = new Object[num];
		Enumeration e = CourseScheduler.coursesTable.elements();
		while(e.hasMoreElements()){
			prereqC[i] = e.nextElement();
			i++;
		}
		label1 = new JLabel("Course Number");
		label2 = new JLabel("Course Name");
		label3 = new JLabel("Course Description");
		label4 = new JLabel("Pre-requisite");
		label5 = new JLabel("Capacity");
		label6 = new JLabel("Credits Earned");
		label7 = new JLabel("Semesters Offered");
		l6 = new JLabel("Add New Course Form");
		l6.setFont(new java.awt.Font("Tahoma", 1, 24));
		tf1 = new JTextField(20);
		tf2 =new JTextField(20);
		tf3 = new JTextArea(3,20);
		tf3.setWrapStyleWord(true);
		tf4 = new JTextField(20);
		tf5 = new JTextField(20);
		l4 = new JList(prereqC);
		l4.setCellRenderer(new CheckBoxListCellRenderer());
		l4.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		js1 = new JScrollPane(l4);
		tf6 = new JTextField(20);
		c1 = new JCheckBox("Summer");
		c2 = new JCheckBox("Spring");
		c3 = new JCheckBox("Fall");
		cpanel = new JPanel();
		cpanel.add(c1);cpanel.add(c2);cpanel.add(c3);

		b1 = new JButton("Save");
		b2 = new JButton("Clear");
		b3 = new JButton("Cancel");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		panel = new JPanel(new GridLayout(8,2,10,10));
		panel.add(label1);panel.add(tf1);
		
		panel.add(label2);panel.add(tf2);
		panel.add(label3);panel.add(tf3);
		panel.add(label4);panel.add(js1);
		panel.add(label5);panel.add(tf4);
		panel.add(label6);panel.add(tf5);
		panel.add(label7);
		panel.add(cpanel);
		
		bpanel = new JPanel();
		bpanel.add(b1); bpanel.add(b2);bpanel.add(b3);
		panel.add(bpanel);
		
		this.add(l6,BorderLayout.NORTH);
		this.add(panel,BorderLayout.CENTER);
		//this.setSize(800, 800);
		//pack();
		//setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae){
		// calling super class actionPerformed()
		super.actionPerformed(ae);
		//
		if (ae.getSource()==b1){
		course = new Course();
		String coursecode =tf1.getText();
		course.setCourseCode(coursecode);
		course.setCourseName(tf2.getText());
		course.setCourseDesc(tf3.getText());
		course.setCreditsEarned(Integer.parseInt(tf5.getText()));
		course.setCapacity(Integer.parseInt(tf4.getText()));
		Object[] pcourses = l4.getSelectedValues();
		course.setPrerequisites(Arrays.asList(pcourses));
		boolean sum = c1.isSelected();
		course.setOfferedSummer(sum);
		boolean spr = c2.isSelected();
		course.setOfferedSpring(spr);
		boolean fall = c3.isSelected();
		course.setOfferedFall(fall);
		boolean x = CourseScheduler.coursesTable.containsKey(coursecode);
		if (!x){
			CourseScheduler.coursesTable.put(coursecode, course);
			System.out.println("Course Added");
			JOptionPane.showMessageDialog(null, "Course Added");
			JFrame sh = new CourseM();
			this.dispose();
			sh.setVisible(true);
		}
		else{
			JOptionPane.showMessageDialog(null, "CourseCode already exists");
		}
		
		}
		if (ae.getSource()==b2){
		
			clearForm();
		}
		if (ae.getSource()==b3){
			JFrame sh = new CourseM();
			this.dispose();
			sh.setVisible(true);
		}
	}
	
	public void clearForm(){
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
		l4.clearSelection();
		tf6.setText("");
		c1.setSelected(false);
		c2.setSelected(false);
		c3.setSelected(false);
		//l7.clearSelection();
	}
}
