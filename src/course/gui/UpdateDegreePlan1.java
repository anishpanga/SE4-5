package course.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import course.bean.DegreePlan;
import course.main.CourseScheduler;
public class UpdateDegreePlan1 extends HomeFrame1 implements ActionListener{
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	private JTextField t1,t2,t3,t4,t5,t6;
	private JComboBox jb,jb1;
	private JList jl1,jl2,jl3;
	private JButton b1,b2,b3,b0;
	private JPanel panel,hpanel,bpanel;
	private JTabbedPane jtpane;
	String[] depts = {"MSCS","MSE"};
	String[] degreeCodes;
	private DefaultListModel courses;
	private DegreePlan degreePlan;
	private UpdateDegreePlanReqPanel panel1;
	public UpdateDegreePlan1(DegreePlan degreePlan){
		this.degreePlan = degreePlan;
		initComponents();
	}
	private void initComponents(){
		int i=0;
		List rc,fec,sec;
		
		l1 = new JLabel("Degree Code");
		l2 = new JLabel("Degree Name");
		l3 = new JLabel("Department");
		l4 = new JLabel("Track");
		l5 = new JLabel("Forecast");
		b0 = new JButton("Next");
		b0.addActionListener(this);
	/*	l6 = new JLabel("Required Courses");
		l12 = new JLabel("Num Of Hours");
		l7 = new JLabel("First Elective Courses");
		l10 = new JLabel("FirstElective NumHours");
		l8 = new JLabel("Second Elective Courses");
		l11 = new JLabel("SecondElective NumHours");*/
		courses = new DefaultListModel();
		Enumeration ec = CourseScheduler.coursesTable.elements();
		while(ec.hasMoreElements()){
			courses.addElement(ec.nextElement());
		}
		/*int s = CourseScheduler.degreePlans.size();
		degreeCodes = new String[s+1];
		degreeCodes[0] ="Select DegreePlan";
		Enumeration ck = CourseScheduler.degreePlans.keys();
		while(ck.hasMoreElements()){
			i++;
			degreeCodes[i] = (String)ck.nextElement();
			
		}*/
		t1 = new JTextField(20);
		t1.setText(degreePlan.getDegreeCode());
		//jb1 = new JComboBox(degreeCodes);
		//jb1.addItemListener(this);
		jb = new JComboBox(depts);
		jb.setSelectedItem(degreePlan.getDept());
		t2 = new JTextField(20);
		t2.setText(degreePlan.getName());
		t3 = new JTextField(20);
		t3.setText(degreePlan.getTrack());
		t4 = new JTextField(20);
		t4.setText(Integer.toString(degreePlan.getSemForecast()));
		/*t5 = new JTextField(20);
		t6 = new JTextField(20);
		jl1 = new JList();
		jl1.setModel(courses);
		jl1.setVisibleRowCount(2);
		jl1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jl2 = new JList();
		jl2.setModel(courses);
		jl2.setVisibleRowCount(2);
		jl2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jl3 = new JList();
		jl3.setModel(courses);
		jl3.setVisibleRowCount(2);
		jl3.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		*/
		b1 = new JButton("Update");
		b2 = new JButton("Delete");
		b3 = new JButton("Cancel");
		
		l9 = new JLabel("Update DegreePlan ");
		l9.setFont(new java.awt.Font("Tahoma", 1, 24));
		jtpane = new JTabbedPane();
		panel = new JPanel(new GridLayout(6,2,10,10));
	//	panel1 = new JPanel(new GridLayout(7,2,10,10));
		panel1 = new UpdateDegreePlanReqPanel(degreePlan.getDegreePlanRequirements());
		panel.add(l1);
		panel.add(t1);
		
		panel.add(l2);panel.add(t2);
		panel.add(l3);panel.add(jb);
		panel.add(l4);panel.add(t3);
		panel.add(l5);panel.add(t4);
		panel.add(new JLabel());panel.add(b0);
	/*	panel1.add(l6);panel1.add(l12);
		panel1.add(new JScrollPane(jl1));
		panel1.add(t4);
		panel1.add(l7);panel1.add(l10);
		panel1.add(new JScrollPane(jl2));
		panel1.add(t5);
		panel1.add(l8);panel1.add(l11);
		panel1.add(new JScrollPane(jl3));
		panel1.add(t6);*/
		bpanel = new JPanel();
		bpanel.add(b1); bpanel.add(b2);bpanel.add(b3);
		panel1.add(bpanel);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		jtpane.addTab("DegreePlan Info", panel);
		jtpane.addTab("Course Requirements", panel1);
		hpanel = new JPanel(new BorderLayout());

		hpanel.add(l9,BorderLayout.NORTH);
		hpanel.add(jtpane,BorderLayout.CENTER);
		this.add(hpanel,BorderLayout.CENTER);
	}
	
		
	public void actionPerformed(ActionEvent ae){
		// calling supers method
		super.actionPerformed(ae);
		if (ae.getSource()==b0){
			String degreeC = t1.getText();
			List degreePlanReqList = degreePlan.getDegreePlanRequirements();
			jtpane.setSelectedIndex(1);
		}
			if (ae.getSource()==b1){
				String degreeC = t1.getText();
				DegreePlan dp = new DegreePlan();
				dp.setName(t2.getText());
				dp.setTrack(t3.getText());
				dp.setDegreeCode(degreeC);
				dp.setDept((String)jb.getSelectedItem());
				dp.setSemForecast(Integer.parseInt(t4.getText()));
				List dprl = panel1.getDegreePlanReqs();
				dp.setDegreePlanRequirements(dprl);
			
				CourseScheduler.degreePlans.remove(degreeC);
				CourseScheduler.degreePlans.put(degreeC, dp);
				JOptionPane.showMessageDialog(null, "DegreePlan Updated");
				JFrame dh = new DegreeM();
				this.dispose();
				dh.setVisible(true);
			}
			if (ae.getSource()==b2){
				//clearForm();
				String degreeC = t1.getText();
				CourseScheduler.degreePlans.remove(degreeC);
				JOptionPane.showMessageDialog(null, "DegreePlan Deleted");
				JFrame dh = new DegreeM();
				this.dispose();
				dh.setVisible(true);
			}
			if (ae.getSource()==b3){
				JFrame dh = new DegreeM();
				this.dispose();
				dh.setVisible(true);
			}
	}
	public void clearForm(){
		
		
		t1.setText("");
		t2.setText("");
		jb.setSelectedIndex(-1);
		t3.setText("");
		jl1.clearSelection();
		t4.setText("");
		jl2.clearSelection();
		t5.setText("");
		jl3.clearSelection();
		t6.setText("");
	}
}

