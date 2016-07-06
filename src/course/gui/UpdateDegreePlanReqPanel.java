package course.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import course.bean.Course;
import course.bean.DegreePlanReq;
import course.main.CourseScheduler;

public class UpdateDegreePlanReqPanel extends JPanel implements ActionListener{

	private JLabel l1,l2,l3,l4;
	private JTextField t1,t2;
	private JButton b1,b2;
	private JComboBox jb;
	private JList jl;
	private JPanel bpanel;
	private String[] types = {"Required","Elective"};
	private DefaultListModel courses;
	private List degreePlanReqs;
	private int currentDPR=0;
	public UpdateDegreePlanReqPanel(List degreePlanReqs){
		this.degreePlanReqs = degreePlanReqs;
		initComponents();
	}
	private void initComponents(){
		int num,i=0;
				
		courses = new DefaultListModel();
		Enumeration e = CourseScheduler.coursesTable.elements();
		while(e.hasMoreElements()){
			courses.addElement(e.nextElement());
			
		}
		
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
		
		// calling method
		DegreePlanReq dpr = (DegreePlanReq)degreePlanReqs.get(currentDPR);
		System.out.println("Degree Code"+dpr.getDegreecode()+"  courses  "+dpr.getCourses());
		popuateDegreePlanReq(currentDPR);
		//
		b1 = new JButton("Next/Update");
		b1.addActionListener(this);
		b2 = new JButton("Remove");
		b2.addActionListener(this);
		bpanel = new JPanel();
		bpanel.add(b1);bpanel.add(b2);
		setLayout(new GridLayout(6,2,2,2));
		/*add(l3);add(l1);add(l2);add(l4);
		add(jb);add(t1);add(t2);add(new JScrollPane(jl));*/
		add(l3);add(jb);
		add(l1);add(t1);
		add(l2);add(t2);
		add(l4);add(new JScrollPane(jl));
		add(new JLabel());add(bpanel);
	}
	
	public List getDegreePlanReqs(){
		return this.degreePlanReqs;
	}
	public void popuateDegreePlanReq(int currentIndex){
		DegreePlanReq dpr = (DegreePlanReq)degreePlanReqs.get(currentIndex);
		
		t1.setText(dpr.getDescription());
		t2.setText(Integer.toString(dpr.getHours()));
		jb.setSelectedItem(dpr.getType());
		DefaultListModel model = (DefaultListModel)jl.getModel();
		List courses = dpr.getCourses();
		for(int k=0;k<courses.size();k++){
			Course c = (Course)courses.get(k);
			int index = findIndex(c);
			System.out.println("ind  "+index);
			jl.addSelectionInterval(index, index);
		}
		
	}

	public int findIndex(Course c){
		int index=-1,i=0;
		ListModel model = jl.getModel();
			do{
			Course c1 = (Course)model.getElementAt(i);
			//System.out.println("cname -- "+c1+"index - "+i);
			if (c.getCourseCode().equals(c1.getCourseCode()))
				index = i;
			i++;
		}while(i<model.getSize() && index==-1);
		return index;
	}
	
	public void clearForm(){
		jb.setSelectedIndex(0);
		t1.setText("");
		t2.setText("");
		jl.clearSelection();
	}
	public void actionPerformed(ActionEvent ae){
		if (ae.getSource()==b1){
			DegreePlanReq udpr = new DegreePlanReq();
			udpr.setDescription(t1.getText());
			udpr.setHours(Integer.parseInt(t2.getText()));
			udpr.setType((String)jb.getSelectedItem());
			Object[] courses = jl.getSelectedValues();
			udpr.setCourses(Arrays.asList(courses));
			// updating dpr
			degreePlanReqs.remove(currentDPR);
			degreePlanReqs.add(currentDPR, udpr);
			// clear and populate next dpr
			if (currentDPR<degreePlanReqs.size()){
				clearForm();
				popuateDegreePlanReq(++currentDPR);
			}else
				clearForm();
		}
		if (ae.getSource()==b2){
			DegreePlanReq udpr = new DegreePlanReq();
			udpr.setDescription(t1.getText());
			udpr.setHours(Integer.parseInt(t2.getText()));
			udpr.setType((String)jb.getSelectedItem());
			Object[] courses = jl.getSelectedValues();
			udpr.setCourses(Arrays.asList(courses));
			//Removing dpr from list
			this.degreePlanReqs.remove(udpr);
		}
	}
}
