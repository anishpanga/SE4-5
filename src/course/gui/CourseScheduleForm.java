package course.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CourseScheduleForm extends JPanel implements ActionListener{

	private JLabel label1,label2,label3,label4,label5,label6,l6;
	private JTextField tf1,tf2,tf3,tf4,tf5;
	private JButton b1,b2;
	private JPanel panel;
	private JComboBox jb1,jb2;
	private String[] co = {"ENGR 5003","MATH 5513","CENG 5033"};
	private String[] op = {"Ken Bell","Jeff Bigelow","David Cassel"};
	public CourseScheduleForm(){
		initComponents();
	}
	private void initComponents(){
		label1 = new JLabel("Faculty ");
		label2 = new JLabel("Course ");
		//label3 = new JLabel("Course Description");
		//label4 = new JLabel("Pre-requisite");
		//label5 = new JLabel("Course Type");
		//label6 = new JLabel("Credits Earned");
		l6 = new JLabel("Course Schedule Form");
		l6.setFont(new java.awt.Font("Tahoma", 1, 24));
		//tf1 = new JTextField(20);
		//tf2 =new JTextField(20);
		//tf3 = new JTextField(20);
		//tf4 = new JTextField(20);
		//tf5 = new JTextField(20);
		jb1 = new JComboBox(op);
		jb2 = new JComboBox(co);
		b1 = new JButton("Save");
		b2 = new JButton("Clear");
		
		panel = new JPanel(new GridLayout(6,2,10,10));
		panel.add(label1);panel.add(jb1);
		panel.add(label2);panel.add(jb2);
	/*	panel.add(label3);panel.add(tf3);
		panel.add(label4);panel.add(tf4);
		panel.add(label5);panel.add(jb);
		panel.add(label6);panel.add(tf5);*/
		panel.add(b1); panel.add(b2);
		this.setLayout(new BorderLayout());
		this.add(l6,BorderLayout.NORTH);
		this.add(panel,BorderLayout.CENTER);
		//this.setSize(800, 800);
		//pack();
		//setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae){
		
	}
}
