package course.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import course.bean.Course;
import course.main.CourseScheduler;

public class UpdateCourseForm extends HomeFrame1 implements ActionListener{

	private JLabel label1,label2,label3,label4,label5,label6,label7,l6;
	private JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	private JList l4;
	private JButton b1,b2,b3,b4;
	private JPanel panel,cpanel,bpanel;
	private JScrollPane jsp,jsp1;
	private JCheckBox c1,c2,c3;
	private String[] semesters = {"Summer","Spring","Fall"};
	private DefaultListModel courses;
	private Course course;
	
	public UpdateCourseForm(Course course){
		this.course = course;
		initComponents();
	}
	private void initComponents(){
		int i =0,num=0;
		
		
		label1 = new JLabel("Course Code");
		label2 = new JLabel("Course Name");
		label3 = new JLabel("Course Description");
		label4 = new JLabel("Pre-requisite");
		label5 = new JLabel("Capacity");
		label6 = new JLabel("Credits Earned");
		label7 = new JLabel("Semesters Offered");
		l6 = new JLabel("Update Course Form");
		l6.setFont(new java.awt.Font("Tahoma", 1, 24));
		tf1 = new JTextField(20);
		tf1.setText(course.getCourseCode());
		tf2 =new JTextField(20);
		tf2.setText(course.getCourseName());
		tf3 = new JTextField(20);
		tf3.setText(course.getCourseDesc());
		//tf4 = new JTextField(20);
		tf5 = new JTextField(20);
		tf5.setText(new Integer(course.getCapacity()).toString());
		tf6 = new JTextField(20);
		tf6.setText(new Integer(course.getCreditsEarned()).toString());
		c1 = new JCheckBox("Summer");
		c1.setSelected(course.isOfferedSummer());
		c2 = new JCheckBox("Spring");
		c2.setSelected(course.isOfferedSpring());
		c3 = new JCheckBox("Fall");
		c3.setSelected(course.isOfferedFall());
		cpanel = new JPanel();
		cpanel.add(c1);cpanel.add(c2);cpanel.add(c3);
		
		num = CourseScheduler.coursesTable.size();
		courses = new DefaultListModel();
				
		Enumeration ck = CourseScheduler.coursesTable.elements();
		while(ck.hasMoreElements()){
			courses.addElement(ck.nextElement());
			
		}
	
		l4 = new JList(courses);
		l4.setCellRenderer(new CheckBoxListCellRenderer());
		l4.setVisibleRowCount(2);
		l4.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jsp1 = new JScrollPane(l4);
		DefaultListModel model = (DefaultListModel)l4.getModel();
		List pc = course.getPrerequisites();
		for(int j=0;j<pc.size();j++){
			Course c = (Course)pc.get(j);
			int index = findIndex(c);
			System.out.println(c+"--index--"+index);
			l4.setSelectionInterval(index, index);
		}
		
		b1 = new JButton("Update");
		b2 = new JButton("Delete");
		b3 = new JButton("Clear");
		b4 = new JButton("Cancel");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		panel = new JPanel(new GridLayout(8,2,10,10));
		panel.add(label1);
		panel.add(tf1);
		//panel.add(jb);
		panel.add(label2);panel.add(tf2);
		panel.add(label3);panel.add(tf3);
		panel.add(label4);panel.add(jsp1);
		//panel.add(tf4);
		panel.add(label5);panel.add(tf5);
		panel.add(label6);panel.add(tf6);
		panel.add(label7);panel.add(cpanel);
		//panel.add(jsp);
		bpanel = new JPanel();
		bpanel.add(b1); bpanel.add(b2);
		//bpanel.add(b3);
		bpanel.add(b4);
		panel.add(bpanel);
		//this.setLayout(new BorderLayout());
		this.add(l6,BorderLayout.NORTH);
		this.add(panel,BorderLayout.CENTER);
		
		
	}
	public int findIndex(Course c){
		int index=-1,i=0;
		ListModel model = l4.getModel();
			do{
			Course c1 = (Course)model.getElementAt(i);
			System.out.println("cname -- "+c1+"index - "+i);
			if (c.getCourseCode().equals(c1.getCourseCode()))
				index = i;
			i++;
		}while(i<model.getSize() && index==-1);
		return index;
	}
	public void actionPerformed(ActionEvent ae){
		// calling superclass
		super.actionPerformed(ae);
		//
		if (ae.getSource()==b1){
		course = new Course();
		String coursecode = tf1.getText();
		course.setCourseCode(coursecode);
		course.setCourseName(tf2.getText());
		course.setCourseDesc(tf3.getText());
		Object[] prec = l4.getSelectedValues();
		course.setPrerequisites(Arrays.asList(prec));
		course.setCapacity(Integer.parseInt(tf5.getText()));
		course.setCreditsEarned(Integer.parseInt(tf6.getText()));
		//Object[] semsO = l7.getSelectedValues();
		//course.setSemestersOffered(Arrays.asList(semsO));
	//	int[] semsO = l7.getSelectedIndices();
		//course.setSemestersOffered(semsO);
		course.setOfferedSummer(c1.isSelected());
		course.setOfferedSpring(c2.isSelected());
		course.setOfferedFall(c3.isSelected());
		CourseScheduler.coursesTable.remove(coursecode);
		CourseScheduler.coursesTable.put(coursecode, course);
		System.out.println("Course Updated");
		JOptionPane.showMessageDialog(null, "Course Updated");
		JFrame cm = new CourseM();
		this.dispose();
		cm.setVisible(true);
		}
		if (ae.getSource()==b2){
			String coursecode =(String)tf1.getText();
			CourseScheduler.coursesTable.remove(coursecode);
			System.out.println("Course Deleted");
			JOptionPane.showMessageDialog(null, "Course Deleted");
			JFrame cm = new CourseM();
			this.dispose();
			cm.setVisible(true);
		}
		if (ae.getSource()==b3){
			clearForm();
		}
		if (ae.getSource()==b4){
			JFrame cm = new CourseM();
			this.dispose();
			cm.setVisible(true);
		}
	}
	/*public void itemStateChanged(ItemEvent ie){
		int z = jb.getSelectedIndex();
		if (z!=0){
		String courseid = (String)jb.getSelectedItem();
		course =(Course)CourseScheduler.coursesTable.get(courseid);
		tf2.setText(course.getCourseName());
		tf3.setText(course.getCourseDesc());
		//List preC = course.getPrerequisites();
		//l4.setSelectedValue(preC, true);
		//System.out.println(preC.get(0)+" ");
		tf4.setText(course.getPrerequisites());
		tf5.setText(Integer.toString(course.getCapacity()));
		tf6.setText(Integer.toString(course.getCreditsEarned()));
		int[] so = course.getSemestersOffered();
		
		l7.setSelectedIndices(so);
			
		}else{
			clearForm();
		}
	}*/
	
	public void clearForm(){
		System.out.println("In Clear Form");
		//jb.removeItemListener(this);
		//jb.setSelectedIndex(0);
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
		tf6.setText("");
		c1.setSelected(false);
		c2.setSelected(false);
		c3.setSelected(false);
		//l7.clearSelection();
	}
}
