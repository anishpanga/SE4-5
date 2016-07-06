package course.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import course.bean.DegreePlan;
import course.bean.DegreePlanReq;
import course.main.CourseScheduler;

public class AddDegreePlan1 extends HomeFrame1 implements ActionListener{

	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	private JTextField t1,t2,t3,t4,t5,t6,t7;
	private JComboBox jb;
	private JList jl1,jl2,jl3;
	private JPanel hpanel,panel1,bpanel;
	private JTabbedPane jtp;
	private JButton b1,b2,b3,b0;
	private String depts[] = {"MSE","MSCE"};
	private String[] courseIDS;
	private DegreePlanReqPanel panel2;
	public AddDegreePlan1(){
		super();
		initComponents();
	}
	
	private void initComponents(){
		int i=0;
		int s = CourseScheduler.coursesTable.size();
		if (s!=0){
			courseIDS = new String[s];
		Enumeration e  = CourseScheduler.coursesTable.keys();
		while(e.hasMoreElements()){
			courseIDS[i] = (String)e.nextElement();
			i++;
		}
		}else{
			courseIDS[0] = "";
		}
		l1 = new JLabel("Degree Name");
		l2 = new JLabel("Department");
		l3 = new JLabel("Track");
		l4 = new JLabel("Degree Code");
		l5 = new JLabel("Forecast");
		t1 = new JTextField(20);
		jb = new JComboBox(depts);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
		b0 = new JButton("Next");
		b0.addActionListener(this);
		hpanel = new JPanel(new BorderLayout());
		panel1 = new JPanel(new GridLayout(6,2,10,10));
		panel1.add(l1);panel1.add(t1);
		panel1.add(l2);panel1.add(jb);
		panel1.add(l3);panel1.add(t2);
		panel1.add(l4);panel1.add(t3);
		panel1.add(l5);panel1.add(t4);
		panel1.add(new JLabel());panel1.add(b0);
		jtp = new JTabbedPane();
		jtp.addTab("DegreePlan Details", panel1);
		panel2 = new DegreePlanReqPanel();
		
	/*	 panel2 = new JPanel(new GridLayout(7,2,8,8));
		l6 = new JLabel("Required Courses");
		l7 = new JLabel("No. Of Hours ");
		l8 = new JLabel("Elective Group 1");
		l9 = new JLabel("No. Of Hours ");
		l10 = new JLabel("Elective Group 2");
		l11 = new JLabel("No. Of Hours ");
		jl1 = new JList(courseIDS);
		jl2 = new JList(courseIDS);
		jl3 = new JList(courseIDS);
		t5 = new JTextField(20);
		
		t6 = new JTextField(20);
		
		t7 = new JTextField(20);
					
		panel2.add(l6);panel2.add(l7);
		panel2.add(new JScrollPane(jl1));panel2.add(t5);
		panel2.add(l8);panel2.add(l9);
		
		panel2.add(new JScrollPane(jl2));panel2.add(t6);
		panel2.add(l10);panel2.add(l11);
		
		panel2.add(new JScrollPane(jl3));panel2.add(t7);*/
		
		b1 = new JButton("Save");
		b2 = new JButton("Clear");
		b3 = new JButton("Cancel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		bpanel = new JPanel();
		bpanel.add(b1);bpanel.add(b2);bpanel.add(b3);
		panel2.add(bpanel);
		jtp.addTab("Course Requirements", panel2);
		//this.setLayout(new BorderLayout());
		hpanel.add(jtp,BorderLayout.CENTER);
		this.add(hpanel,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae){
		DegreePlan degreeplan=null;
		String degreeCode="";
		degreeplan = new DegreePlan();
		super.actionPerformed(ae);
		if (ae.getSource()==b0){
			//Add new Course Requirement Panel
			degreeCode = t3.getText();
			System.out.println("DECODe "+degreeCode);
		/*	degreeplan.setName(t1.getText());
			degreeplan.setDept((String)jb.getSelectedItem());
			degreeplan.setTrack(t2.getText());
			degreeplan.setDegreeCode(degreeCode);
			degreeplan.setSemForecast(Integer.parseInt(t4.getText()));*/
			panel2.setDegreeCode(degreeCode);
			jtp.setSelectedIndex(1);
		}
		if (ae.getSource()==b1){
			// getting DegreePlanRequirements
			degreeplan.setName(t1.getText());
			degreeplan.setDept((String)jb.getSelectedItem());
			degreeplan.setTrack(t2.getText());
			degreeplan.setDegreeCode(t3.getText());
			degreeplan.setSemForecast(Integer.parseInt(t4.getText()));
			List dprl = panel2.getDegreePlanReqs();
			System.out.println("dpr size "+dprl.size());
			degreeplan.setDegreePlanRequirements(dprl);
			/*Object[] requiredCourses = jl1.getSelectedValues();
			degreeplan.setRequiredCourses(Arrays.asList(requiredCourses));
			degreeplan.setNumhrsReqCourses(Integer.parseInt(t5.getText()));
			Object[] elective1 = jl2.getSelectedValues();
			degreeplan.setFirstElective(Arrays.asList(elective1));
			degreeplan.setNumhrsFirstElective(Integer.parseInt(t6.getText()));
			Object[] elective2 = jl3.getSelectedValues();
			degreeplan.setSecondElective(Arrays.asList(elective2));
			degreeplan.setNumhrsSecondElective(Integer.parseInt(t7.getText()));*/
			
			//saving DegreePlan
			
			CourseScheduler.degreePlans.put(degreeCode, degreeplan);
			JOptionPane.showMessageDialog(null, "DegreePlan Saved");
			JFrame dh = new DegreeM();
			this.dispose();
			dh.setVisible(true);
		}
		if (ae.getSource()==b2){
			t1.setText("");
			jb.setSelectedIndex(0);
			t2.setText("");
			t3.setText("");
			t4.setText("");
			jl1.clearSelection();
			t5.setText("");
			jl2.clearSelection();
			t6.setText("");
			jl3.clearSelection();
			t7.setText("");
			
		}
		if (ae.getSource()==b3){
			JFrame dh = new DegreeM();
			this.dispose();
			dh.setVisible(true);
		}
	}
}
