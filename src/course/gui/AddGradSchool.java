package course.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import course.bean.GradSchool;
import course.main.CourseScheduler;
import course.bean.*;

public class AddGradSchool extends HomeFrame1 implements ActionListener{
	
	private JLabel l1,l2,l3,l4;
	private JTextField t1,t2;
	private JButton b1,b2,b3;
	private JList jl;
	private JPanel panel;
	private Object dplans[];
	public AddGradSchool(){
		initComponents();
	}
	private void initComponents(){
		int num,i=0;
		num = CourseScheduler.degreePlans.size();
		Enumeration e = CourseScheduler.degreePlans.elements();
		dplans= new Object[num];
		while(e.hasMoreElements()){
			dplans[i] = e.nextElement();
			System.out.println(dplans[i]);
			i++;
		}
		panel = new JPanel(new GridLayout(5,3,10,10));
		l1 = new JLabel("Grad School Name");
		l2 = new JLabel("Abbrevation");
		l3 = new JLabel("DegreePlans");
		l4 = new JLabel("Add New GradSchool");
		l4.setFont(new Font("Tahoma",1,18));
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		jl = new JList(dplans);
		b1 = new JButton("Save");
		b3 = new JButton("Clear");
		b2 = new JButton("Cancel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		panel.add(l1);panel.add(t1);panel.add(new JLabel());
		panel.add(l2);panel.add(t2);panel.add(new JLabel());
		panel.add(l3);panel.add(jl);panel.add(new JLabel());
		panel.add(b1);panel.add(b3);panel.add(b2);
		this.add(l4,BorderLayout.PAGE_START);
		this.add(panel,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			GradSchool gschool = new GradSchool();
			gschool.setGradschoolname(t1.getText());
			gschool.setAbbr(t2.getText());
		/*	DefaultListModel dp = (DefaultListModel)jl.getModel();
			if (dp!=null){
			Object[] dplans = dp.toArray();
			gschool.setDegreePlansOffered(Arrays.asList(dplans));
			}else{
				gschool.setDegreePlansOffered(new ArrayList());
			}*/
			Object[] dp = jl.getSelectedValues();
			if (dp!=null)
				gschool.setDegreePlansOffered(Arrays.asList(dp));
			else
				gschool.setDegreePlansOffered(new ArrayList());
			List gradSchools = CourseScheduler.university.getGradSchools();
			gradSchools.add(gschool);
			JOptionPane.showMessageDialog(null, "GradSchool Added");
			JFrame uef = new universityE(CourseScheduler.university);
			this.dispose();
			uef.setVisible(true);
		}
		if (ae.getSource()==b3){
			t1.setText("");
			t2.setText("");
			jl.clearSelection();
		}
		if (ae.getSource()==b2){
			JFrame uef = new universityE(CourseScheduler.university);
			this.dispose();
			uef.setVisible(true);
		}
	}
}
