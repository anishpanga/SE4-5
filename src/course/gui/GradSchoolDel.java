package course.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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

public class GradSchoolDel extends HomeFrame1{

	private JLabel l1,l2,l3;
	private JTextField t1,t2,t3;
	private JButton b1,b2;
	private JPanel panel;
	private JList jl;
	private GradSchool gradSchool;
	public GradSchoolDel(GradSchool gradSchool){
		this.gradSchool = gradSchool;
		initComponents();
	}
	private void initComponents(){
		l1 = new JLabel("GradSchool Name");
		l2 = new JLabel("Abbrevation");
		l3 = new JLabel("Degree Plans");
		t1 = new JTextField(20);
		t1.setText(gradSchool.getGradschoolname());
		t2 = new JTextField(20);
		t2.setText(gradSchool.getAbbr());
		List dpo = gradSchool.getDegreePlansOffered();
		DefaultListModel dpm = new DefaultListModel();
		for(int i=0;i<dpo.size();i++){
			dpm.addElement(dpo.get(i));
		}
		jl = new JList(dpm);
		b1 = new JButton("Delete");
		b2 = new JButton("Cancel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		
		
		panel = new JPanel(new GridLayout(5,2,10,10));
		panel.add(l1);panel.add(t1);
		panel.add(l2);panel.add(t2);
		panel.add(l3);panel.add(new JScrollPane(jl));
		panel.add(b1);panel.add(b2);
		
		
		this.add(panel,BorderLayout.CENTER);
	
}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			List gschools = CourseScheduler.university.getGradSchools();
			boolean b = gschools.remove(gradSchool);
			if (b)
				JOptionPane.showMessageDialog(null, "GradSchool Deleted");
			else
				JOptionPane.showMessageDialog(null, "GradSchool Not Deleted");
		}
		if (ae.getSource()==b2){
			JFrame ue = new universityE(CourseScheduler.university);
			this.dispose();
			ue.setVisible(true);
		}
	}
}