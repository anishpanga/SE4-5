package course.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import course.bean.DegreePlanReq;
import course.main.CourseScheduler;

public class DegreePlanReqPanel extends JPanel implements ActionListener{

	private JLabel l1,l2,l3,l4;
	private JTextField t1,t2;
	private JButton b1;
	private JComboBox jb;
	private JList jl;
	private String[] types = {"Required","Elective"};
	private Object courses[];
	private List degreePlanReqs;
	private String degreecode;
	public DegreePlanReqPanel(){
		initComponents();
	}
	private void initComponents(){
		int num,i=0;
		degreePlanReqs = new ArrayList();
		num = CourseScheduler.coursesTable.size();
		courses = new Object[num];
		Enumeration e = CourseScheduler.coursesTable.elements();
		while(e.hasMoreElements()){
			courses[i] = e.nextElement();
			i++;
		}
		System.out.println("Degree Code"+this.degreecode);
		l1 = new JLabel("Description");
		l2 = new JLabel("Hours");
		l3 = new JLabel("Type");
		l4 = new JLabel("Courses");
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		jb = new JComboBox(types);
		jl = new JList(courses);
		jl.setCellRenderer(new CheckBoxListCellRenderer());
		jl.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		b1 = new JButton("Next");
		b1.addActionListener(this);
		
		setLayout(new GridLayout(6,2,2,2));
		/*add(l3);add(l1);add(l2);add(l4);
		add(jb);add(t1);add(t2);add(new JScrollPane(jl));*/
		add(l3);add(jb);
		add(l1);add(t1);
		add(l2);add(t2);
		add(l4);add(new JScrollPane(jl));
		add(new JLabel());add(b1);
	}
	public void setDegreeCode(String degreecode){
		this.degreecode = degreecode;
	}
	public List getDegreePlanReqs(){
		return this.degreePlanReqs;
	}
	public void actionPerformed(ActionEvent ae){
		
		if (ae.getSource()==b1){
			System.out.println("Degree Code"+this.degreecode);
			DegreePlanReq dpr = new DegreePlanReq();
			dpr.setType((String)jb.getSelectedItem());
			dpr.setDegreecode(this.degreecode);
			dpr.setDescription(t1.getText());
			dpr.setHours(Integer.parseInt(t2.getText()));
			Object[] courses = jl.getSelectedValues();
			dpr.setCourses(Arrays.asList(courses));
			System.out.println(courses);
			degreePlanReqs.add(dpr);
		// clear the panel
			clearForm();
		}
	}
	public void clearForm(){
		jb.setSelectedIndex(0);
		t1.setText("");
		t2.setText("");
		jl.clearSelection();
	}
}
