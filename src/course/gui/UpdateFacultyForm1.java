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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
import course.bean.Faculty;
import course.main.CourseScheduler;

public class UpdateFacultyForm1 extends HomeFrame1 implements ActionListener,ItemListener{
	
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,l6;
	private JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	private JButton b1,b2,b4;
	private JPanel panel,cpanel,bpanel;
	private JList jl1;
	private DefaultListModel courselistModel;
	private JScrollPane jsp;
	private JComboBox jb,jb1;

	String[] courses;
	private DefaultListModel coursesModel;
	private JCheckBox c1,c2,c3,c4,c5;
	private Faculty faculty;
	public UpdateFacultyForm1(Faculty faculty){
		this.faculty = faculty;
		initComponents();
	}
	private void initComponents(){
		
		int i=0,j=0,num;
		// Array allocating 
		num = CourseScheduler.coursesTable.size();
		courses = new String[num];
		//
		
		label1 = new JLabel("First Name");
		label2 = new JLabel("Last Name");
		label3 = new JLabel("Title");
		label4 = new JLabel("Qualification Degree");
		label5 = new JLabel("Courses Taught");
		label6 = new JLabel("MaxLoad Summer");
		label7 = new JLabel("MaxLoad Spring");
		label8 = new JLabel("MaxLoad Fall");
		label9 = new JLabel("Days to Teach");
		l6 = new JLabel("Update Faculty Form");
		l6.setFont(new java.awt.Font("Tahoma", 1, 24));

		//Populating Faculty


		tf1 = new JTextField(20);
		tf1.setText(faculty.getFirstName());
		tf2 =new JTextField(20);
		tf2.setText(faculty.getLastName());
		tf3 = new JTextField(20);
		tf3.setText(faculty.getTitle());
		tf4 = new JTextField(20);
		tf4.setText(faculty.getDegree());
		tf5 = new JTextField(20);
		tf5.setText(new Integer(faculty.getMaxLoadSummmer()).toString());
		tf6 = new JTextField(20);
		tf6.setText(new Integer(faculty.getMaxLoadSpring()).toString());
		tf7 = new JTextField(20);
		tf7.setText(new Integer(faculty.getMaxLoadFall()).toString());

		
		// getting courses
		coursesModel = new DefaultListModel();
		Enumeration e = CourseScheduler.coursesTable.elements();
		while(e.hasMoreElements()){
			//courses[j] = (String)e.nextElement();
			coursesModel.addElement(e.nextElement());
			//j++;
		}
		
		jl1 = new JList(coursesModel);
		jl1.setCellRenderer(new CheckBoxListCellRenderer());
		jl1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		jl1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jl1.setVisibleRowCount(-1); 
		jsp = new JScrollPane(jl1);
		
		List ct = faculty.getCoursesTaught();
		for(int k=0;k<ct.size();k++){
			Course c = (Course)ct.get(k);
			int index = findIndex(c);
			System.out.println(c+" index "+index);
			jl1.getSelectionModel().addSelectionInterval(index, index);
		}
		c1 = new JCheckBox("MON");
		c2 = new JCheckBox("TUE");
		c3 = new JCheckBox("WED");
		c4 = new JCheckBox("THU");
		c5 = new JCheckBox("FRI");
		cpanel = new JPanel();
		cpanel.add(c1);cpanel.add(c2);cpanel.add(c3);cpanel.add(c4);cpanel.add(c5);
		String days = faculty.getDaystoTeach();
		System.out.println("Days to Teach"+days);
		for(int k=0;k<days.length();k++){
			char c = days.charAt(k);
			if (c == 'M')
				c1.setSelected(true);
			if (c == 'T')
				c2.setSelected(true);
			if (c == 'W')
				c3.setSelected(true);
			if (c =='R')
				c4.setSelected(true);
			if (c =='F')
				c5.setSelected(true);
		}	
			
		b1 = new JButton("Update");
		b2 = new JButton("Delete");
		b4 = new JButton("Cancel");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b4.addActionListener(this);
		
		panel = new JPanel(new GridLayout(10,2,10,10));
		bpanel = new JPanel();
		panel.add(label1);panel.add(tf1);
		panel.add(label2);panel.add(tf2);
		panel.add(label3);panel.add(tf3);
		panel.add(label4);panel.add(tf4);
		panel.add(label5);panel.add(jsp);
		panel.add(label6);panel.add(tf5);
		panel.add(label7);panel.add(tf6);
		panel.add(label8);panel.add(tf7);
		panel.add(label9);panel.add(cpanel);
		bpanel.add(b1); bpanel.add(b2);bpanel.add(b4);
		panel.add(bpanel);
		this.add(l6,BorderLayout.NORTH);
		this.add(panel,BorderLayout.CENTER);
		
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			Faculty f = new Faculty();
			String fid = tf2.getText();
			f.setFirstName(tf1.getText());
			f.setLastName(tf2.getText());
			f.setTitle(tf3.getText());
			f.setDegree(tf4.getText());
			Object[] courses = jl1.getSelectedValues();
			f.setCoursesTaught(Arrays.asList(courses));
			f.setMaxLoadSummmer(Integer.parseInt(tf5.getText()));
			f.setMaxLoadSpring(Integer.parseInt(tf6.getText()));
			f.setMaxLoadFall(Integer.parseInt(tf7.getText()));
			StringBuilder dt = new StringBuilder();
			if (c1.isSelected())
				dt.append('M');
			if (c2.isSelected())
				dt.append('T');
			if (c3.isSelected())
				dt.append('W');
			if (c4.isSelected())
				dt.append('R');
			if (c5.isSelected())
				dt.append('F');
			f.setDaystoTeach(dt.toString());
			// updating faculty table
			CourseScheduler.facultyTable.remove(fid);
			CourseScheduler.facultyTable.put(fid,f);
			JOptionPane.showMessageDialog(null, "Faculty Updated");
			JFrame jf = new FacultyM();
			this.dispose();
			jf.setVisible(true);
		}
		if (ae.getSource()==b2){
			String fid = tf2.getText();
			CourseScheduler.facultyTable.remove(fid);
			JOptionPane.showMessageDialog(null, "Faculty Deleted");
			JFrame jf = new FacultyM();
			this.dispose();
			jf.setVisible(true);
		}
		
		if (ae.getSource()==b4){
			JFrame jf = new FacultyM();
			this.dispose();
			jf.setVisible(true);

		}
	}
	public void itemStateChanged(ItemEvent ie){
		String fid = (String)jb1.getSelectedItem();
		System.out.println("Selected Fid "+fid);
		Faculty f = (Faculty)CourseScheduler.facultyTable.get(fid);
		tf2.setText(f.getFirstName());
		tf1.setText(f.getLastName());
		//tf3.setText(new Integer(f.getCoursesPerSem()).toString());
		List ct = f.getCoursesTaught();
		DefaultListModel model =(DefaultListModel) jl1.getModel();
		for(int i=0;i<ct.size();i++){
			String x = (String)ct.get(i);
			int index = model.indexOf(x);
			System.out.println("rc index "+index);
			jl1.addSelectionInterval(index, index);
		}
		//jb.setSelectedItem(f.getAvailability());
	}
	public int findIndex(Course c){
		int index=-1,i=0;
		ListModel model = jl1.getModel();
			do{
			Course c1 = (Course)model.getElementAt(i);
			System.out.println("cname -- "+c1+"index - "+i);
			if (c.getCourseCode().equals(c1.getCourseCode()))
				index = i;
			i++;
		}while(i<model.getSize() && index==-1);
		return index;
	}

}
