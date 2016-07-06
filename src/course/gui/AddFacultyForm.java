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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import course.bean.Faculty;
import course.main.CourseScheduler;

public class AddFacultyForm extends HomeFrame1 implements ActionListener{

	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,l6;
	private JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	private JButton b1,b2,b3;
	private JPanel panel,cpanel,bpanel;
	private JList jl1;
	
	private JCheckBox c1,c2,c3,c4,c5;
	private Object[] courses;
	public AddFacultyForm(){
		initComponents();
	}
	private void initComponents(){
		int i=0;
		int s = CourseScheduler.coursesTable.size();
		courses = new Object[s];
		Enumeration e = CourseScheduler.coursesTable.elements();
		while(e.hasMoreElements()){
			courses[i] = e.nextElement();
			i++;
		}
		
		label1 = new JLabel("First Name");
		label2 = new JLabel("Last Name");
		label3 = new JLabel("Title");
		label4 = new JLabel("Qualification Degree");
		label5 = new JLabel("Courses Taught");
		label6 = new JLabel("MaxLoadSummer");
		label7 = new JLabel("MaxLoadSpring");
		label8 = new JLabel("MaxLoadFall");
		label9 = new JLabel("Days to Teach");
		l6 = new JLabel("Add New Faculty Form");
		l6.setFont(new java.awt.Font("Tahoma", 1, 24));
		tf1 = new JTextField(20);
		tf2 =new JTextField(20);
		tf3 = new JTextField(20);
		tf4 = new JTextField(20);
		
		tf5 = new JTextField(20);
		tf5.setText("0");
		tf6 = new JTextField(20);
		tf6.setText("0");
		tf7 = new JTextField(20);
		tf7.setText("0");	
		jl1 = new JList(courses);
		jl1.setCellRenderer(new CheckBoxListCellRenderer());
		jl1.setLayoutOrientation(JList.VERTICAL);
		jl1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jl1.setVisibleRowCount(-1);
		
		c1 = new JCheckBox("MON");
		c2 = new JCheckBox("TUE");
		c3 = new JCheckBox("WED");
		c4 = new JCheckBox("THU");
		c5 = new JCheckBox("FRI");
		b1 = new JButton("Save");
		b2 = new JButton("Clear");
		b3 = new JButton("Cancel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		panel = new JPanel(new GridLayout(10,2,8,8));
		panel.add(label1);panel.add(tf1);
		panel.add(label2);
		panel.add(tf2);
		
		panel.add(label3);panel.add(tf3);
		panel.add(label4);panel.add(tf4);
		panel.add(label5);panel.add(new JScrollPane(jl1));
		panel.add(label6);panel.add(tf5);
		panel.add(label7);panel.add(tf6);
		panel.add(label8);panel.add(tf7);
		
		cpanel = new JPanel();
		cpanel.add(c1);cpanel.add(c2);cpanel.add(c3);cpanel.add(c4);cpanel.add(c5);
		panel.add(label9);panel.add(cpanel);
		bpanel = new JPanel();
		bpanel.add(b1); bpanel.add(b2);bpanel.add(b3);
		panel.add(bpanel);
		
		this.add(l6,BorderLayout.NORTH);
		this.add(panel,BorderLayout.CENTER);
		
		
	}
	public void actionPerformed(ActionEvent ae){
		// calling super class method
		super.actionPerformed(ae);
		//
		if (ae.getSource()==b1){
			String fid;
			Faculty f = new Faculty();
			String firstname = tf1.getText();
			f.setFirstName(firstname);
			String lastname = tf2.getText();
			f.setLastName(lastname);
			f.setTitle(tf3.getText());
			f.setDegree(tf4.getText());
			Object[] ct = jl1.getSelectedValues();
			f.setCoursesTaught(Arrays.asList(ct));
			f.setMaxLoadSummmer(Integer.parseInt(tf5.getText()));
			f.setMaxLoadSpring(Integer.parseInt(tf6.getText()));
			f.setMaxLoadFall(Integer.parseInt(tf7.getText()));
			StringBuilder dt = new StringBuilder();
			if (c1.isSelected())
				dt.append("M");
			if (c2.isSelected())
				dt.append("T");
			if (c3.isSelected())
				dt.append("W");
			if (c4.isSelected())
				dt.append("R");
			if (c5.isSelected())
				dt.append("F");
			System.out.println("Days to Teach "+dt);
			f.setDaystoTeach(dt.toString());
			// saving faculty data
			fid = lastname;
			CourseScheduler.facultyTable.put(fid, f);
			JOptionPane.showMessageDialog(null, "New Faculty Added");
			
			JFrame fm = new FacultyM();
			this.dispose();
			fm.setVisible(true);
		}
		if (ae.getSource()==b2){
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			jl1.clearSelection();
			tf5.setText("0");
			tf6.setText("0");
			tf7.setText("0");
			c1.setSelected(false);
			c2.setSelected(false);
			c3.setSelected(false);
			c4.setSelected(false);
			c5.setSelected(false);
						
		}
		if (ae.getSource()==b3){
			JFrame fm = new FacultyM();
			this.dispose();
			fm.setVisible(true);
		}
	}
	
}
