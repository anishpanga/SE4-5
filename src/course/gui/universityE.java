package course.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import course.bean.GradSchool;
import course.bean.Semester;
import course.bean.University;

public class universityE extends HomeFrame1 implements ActionListener,ListSelectionListener{

	private JLabel l1,l2,l3,l4,l5;
	private JTextField t1,t2;
	private JList jl1,jl2;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8;
	private JPanel homepanel,panel1,panel2,panel3;
	private University university;
	public universityE(University u){
		super();
		this.university = u;
		initComponents();
	}
	private void initComponents(){
		homepanel = new JPanel();
		l1 = new JLabel("University Edit");
		l1.setFont(new Font("Tohama",1,18));
		l2 = new JLabel("Name");
		l3 = new JLabel("Abbrevation");
		l4 = new JLabel("Grad School");
		l5 = new JLabel("Semester");
		 t1 = new JTextField(20);
		 t1.setText(university.getName());
		 t2 = new JTextField(20);
		 t2.setText(university.getAbbrevation());
		 List gs= university.getGradSchools();
		 if (gs != null)
			 jl1 = new JList(gs.toArray());
		 else
			jl1 = new JList();
		 //jl1.setVisibleRowCount(5);
		 List sems = university.getSemesters();
		 if (sems != null)
		 jl2 = new JList(sems.toArray());
		 else
			 jl2 = new JList();
		 //jl2.setVisibleRowCount(5);
		  b1 = new JButton("Add");
		  b1.addActionListener(this);
		 b2 = new JButton("Update");
		 b2.setEnabled(false);
		 b2.addActionListener(this);
		 b3 = new JButton("Delete");
		 b3.setEnabled(false);
		 b3.addActionListener(this);
		 b4 = new JButton("Add");
		 b4.addActionListener(this);
		 b5 = new JButton("Update");
		 b5.setEnabled(false);
		 b5.addActionListener(this);
		 b6 = new JButton("Delete");
		 b6.setEnabled(false);
		 b6.addActionListener(this);
		 b7 = new JButton("Save");
		 b7.addActionListener(this);
		 b8 = new JButton("Cancel");
		 b8.addActionListener(this);
		 homepanel.setLayout(new GridBagLayout());
		 GridBagConstraints gbc = new GridBagConstraints();
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.gridx =4;
		 gbc.gridy = 0;
		 
		 homepanel.add(l1,gbc);
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.gridx = 2;
		 gbc.gridy = 1;
		 homepanel.add(l2,gbc);
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.gridx = 4;
		 gbc.gridy = 1;
		 gbc.gridwidth = 2;
		 homepanel.add(t1,gbc);
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.gridx = 2;
		 gbc.gridy = 2;
		 homepanel.add(l3,gbc);
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.gridx = 4;
		 gbc.gridy = 2;
		 homepanel.add(t2,gbc);
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.gridx = 0;
		 gbc.gridy = 4;
		 homepanel.add(l4,gbc);
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.gridx = 4;
		 gbc.gridy = 4;
		 homepanel.add(l5,gbc);
		 gbc.fill = GridBagConstraints.VERTICAL;
		 gbc.gridx = 0;
		 gbc.gridy = 5;
		 gbc.gridwidth = 4;
		 gbc.gridheight = 5;
		 jl1.addListSelectionListener(this);
		 homepanel.add(new JScrollPane(jl1),gbc);
		 
		 gbc.fill = GridBagConstraints.VERTICAL;
		 gbc.gridx = 4;
		 gbc.gridy = 5;
		 gbc.gridwidth = 4;
		 gbc.gridheight = 5;
		 homepanel.add(new JScrollPane(jl2),gbc);
		 jl2.addListSelectionListener(this);
		 //adding buttons
		 panel1 = new JPanel();
		 panel1.add(b1);
		 panel1.add(b2);
		 panel1.add(b3);
		 gbc.gridx =0;
		 gbc.gridy = 10;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 homepanel.add(panel1,gbc);
		 panel2 = new JPanel();
		 panel2.add(b4);
		 panel2.add(b5);
		 panel2.add(b6);
		 gbc.gridx = 4;
		 gbc.gridy = 10;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 homepanel.add(panel2,gbc);
		 panel3 = new JPanel();
		 panel3.add(b7);
		 panel3.add(b8);
		 gbc.gridx = 2;
		 gbc.gridy = 18;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 homepanel.add(panel3,gbc);
		
		 this.add(homepanel,BorderLayout.CENTER);
		 
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			JFrame ags = new AddGradSchool();
			this.dispose();
			ags.setVisible(true);
		}
		if (ae.getSource()==b2){
			GradSchool gs = (GradSchool)jl1.getSelectedValue();
			JFrame ge = new GradSchoolEdit(gs);
			this.dispose();
			ge.setVisible(true);
		}
		if (ae.getSource()==b3){
			GradSchool gs = (GradSchool)jl1.getSelectedValue();
			JFrame gd = new GradSchoolDel(gs);
			this.dispose();
			gd.setVisible(true);
		}
		if (ae.getSource()==b4){
			// creating Semester
			JFrame sf = new AddSemesterForm();
			this.dispose();
			sf.setVisible(true);
		}
		if (ae.getSource()==b5){
			Semester sem = (Semester)jl2.getSelectedValue();
			JFrame semu = new UpdateSemester(sem);
			this.dispose();
			semu.setVisible(true);
		}
		if (ae.getSource()==b6){
			Semester sem = (Semester)jl2.getSelectedValue();
			System.out.println("sel sem"+sem.getSemesterNumber());
		//	JFrame semd = new DeleteSemester(sem);
			List sems = university.getSemesters();
			System.out.println(" semester size "+sems.size());
			sems.remove(sem);
			System.out.println(" semester size "+sems.size());
			university.setSemesters(sems);
			JOptionPane.showMessageDialog(null, "Semester Deleted");
			this.repaint();
			//semd.setVisible(true);
		}
		if (ae.getSource()==b7){
			// saving university
			university.setName(t1.getText());
			university.setAbbrevation(t2.getText());
			
			ListModel gsmodel = jl1.getModel();
			List gsc = new ArrayList();
			for(int i=0;i<gsmodel.getSize();i++){
			gsc.add(gsmodel.getElementAt(i));
			}
			university.setGradSchools(gsc);
			// retrieving Sems
			ListModel usem = jl2.getModel();
			List sems = new ArrayList();
			for(int i=0;i<usem.getSize();i++){
				sems.add(usem.getElementAt(i));
			}
			university.setSemesters(sems);
			
			JOptionPane.showMessageDialog(null, "University Updated");
		}
		if (ae.getSource()==b8){
			JFrame sh = new showHome();
			this.dispose();
			sh.setVisible(true);
		}
	}
	public void valueChanged(ListSelectionEvent le){
		if (le.getSource()==jl1){
			b1.setEnabled(false);
			b2.setEnabled(true);
			b3.setEnabled(true);
		}
		if (le.getSource()==jl2){
			b4.setEnabled(false);
			b5.setEnabled(true);
			b6.setEnabled(true);
		}
	}
}
