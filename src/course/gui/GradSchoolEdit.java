package course.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import course.bean.GradSchool;
import course.main.CourseScheduler;

public class GradSchoolEdit extends HomeFrame1 implements ActionListener{

	private JLabel l1,l2,l3;
	private JTextField t1,t2,t3;
	private JButton b1,b2;
	private JPanel panel;
	private JList jl;
	private GradSchool gradSchool;
	private DefaultListModel dplans;
	public GradSchoolEdit(GradSchool gradSchool){
		this.gradSchool = gradSchool;
		initComponents();
	}
	private void initComponents(){
		// initializing degree plans
		int num;
		num = CourseScheduler.degreePlans.size();
		dplans = new DefaultListModel();
		Enumeration e = CourseScheduler.degreePlans.elements();
		while(e.hasMoreElements()){
			dplans.addElement(e.nextElement());
		}
		l1 = new JLabel("GradSchool Name");
		l2 = new JLabel("Abbrevation");
		l3 = new JLabel("Degree Plans");
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		jl = new JList(dplans);
		List dpl = gradSchool.getDegreePlansOffered();
		for(int i=0;i<dpl.size();i++){
			jl.setSelectedValue(dpl.get(i), true);
			
		}
		b1 = new JButton("Update");
		b2 = new JButton("Cancel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		panel = new JPanel(new GridLayout(5,2,10,10));
		panel.add(l1);panel.add(t1);
		panel.add(l2);panel.add(t2);
		panel.add(l3);panel.add(new JScrollPane(jl));
		panel.add(b1);panel.add(b2);
		t1.setText(gradSchool.getGradschoolname());
		t2.setText(gradSchool.getAbbr());
		this.add(panel,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			gradSchool.setGradschoolname(t1.getText());
			gradSchool.setAbbr(t2.getText());
			ListModel dp = jl.getModel();
			List gdp = new ArrayList();
			for(int i=0;i<dp.getSize();i++){
				gdp.add(dp.getElementAt(i));
			}
			gradSchool.setDegreePlansOffered(gdp);
			
			JOptionPane.showMessageDialog(null, "GradSchool Updated");
			// saving gradschool and showing UE form
			JFrame ue = new universityE(CourseScheduler.university);
			this.dispose();
			ue.setVisible(true);
		}
		if (ae.getSource()==b2){
			JFrame sh = new showHome();
			this.dispose();
			sh.setVisible(true);
		}
	}
}
