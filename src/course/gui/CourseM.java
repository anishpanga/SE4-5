package course.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import course.bean.Course;
import course.main.CourseScheduler;

public class CourseM extends HomeFrame1 implements ActionListener{

	private JButton b1,b2,b3;
	private JTable jt;
	private DefaultTableModel tableModel;
	private JPanel panel,tpanel;
	public CourseM(){
		super();
		initComponents();
	}
	private void initComponents(){
		Vector labels,rows,row;
		panel = new JPanel();
		labels = new Vector();
		labels.add("Course Code");
		labels.add("Course Name");
		labels.add("Course Description");
		labels.add("Course Credits");
		labels.add("Prerequisites");
		labels.add("Capacity");
		labels.add("IsOfferedSummer");
		labels.add("IsOfferedSpring");
		labels.add("IsOfferedFall");
		rows = new Vector();
		Enumeration e = CourseScheduler.coursesTable.elements();
		while(e.hasMoreElements()){
			Course c = (Course)e.nextElement();
			row = new Vector();
			row.add(c.getCourseCode());
			row.add(c.getCourseName());
			row.add(c.getCourseDesc());
			row.add(new Integer(c.getCreditsEarned()));
			//System.out.println("Preq  "+c.getPrerequisites());
			row.add(c.getPrerequisites());
			row.add(new Integer(c.getCapacity()));
			row.add(new Boolean(c.isOfferedSummer()));
			row.add(new Boolean(c.isOfferedSpring()));
			row.add(new Boolean(c.isOfferedFall()));
			rows.add(row);
		}
		tableModel = new DefaultTableModel(rows,labels);
		jt = new JTable(tableModel);
		jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		b1 = new JButton("Add Course");
		b2 = new JButton("Update/Delete Course");
		b3 = new JButton("Cancel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		tpanel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx = 4;
		gbc.gridy = 0;
		tpanel.add(new JScrollPane(jt));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = GridBagConstraints.RELATIVE;
		panel.add(b1,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = GridBagConstraints.RELATIVE;
		panel.add(b2,gbc);
		panel.add(b3);
		this.add(tpanel,BorderLayout.CENTER);
		this.add(panel,BorderLayout.NORTH);
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			JFrame ac = new AddCourseForm();
			this.dispose();
			ac.setVisible(true);
			
		}
		if (ae.getSource()==b2){
			int r = jt.getSelectedRow();
			if (r>=0){
			Course c = new Course();
			String coursecode = (String)jt.getValueAt(r, 0);
			c.setCourseCode(coursecode);
			String cname = (String)jt.getValueAt(r, 1);
			c.setCourseName(cname);
			String cdesc = (String)jt.getValueAt(r, 2);
			c.setCourseDesc(cdesc);
			Integer cr = (Integer)jt.getValueAt(r, 3);
			c.setCreditsEarned(cr.intValue());
			List pc = (List)jt.getValueAt(r, 4);
			c.setPrerequisites(pc);
			Integer cp = (Integer)jt.getValueAt(r, 5);
			c.setCapacity(cp.intValue());
			Boolean os = (Boolean)jt.getValueAt(r, 6);
			c.setOfferedSummer(os.booleanValue());
			Boolean osp = (Boolean)jt.getValueAt(r, 7);
			c.setOfferedSpring(osp.booleanValue());
			Boolean of = (Boolean)jt.getValueAt(r, 8);
			c.setOfferedFall(of.booleanValue());
			JFrame uc = new UpdateCourseForm(c);
			this.dispose();
			uc.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "Please Select a Row from Table");
			}
		}
		if (ae.getSource()==b3){
			JFrame sh = new showHome();
			this.dispose();
			sh.setVisible(true);
		}
	}
}
