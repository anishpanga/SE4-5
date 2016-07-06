package course.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import course.bean.Faculty;
import course.main.CourseScheduler;

public class FacultyM extends HomeFrame1 implements ActionListener{

	private JButton b1,b2,b3;
	private JPanel panel,tpanel;
	private JTable jt;
	private DefaultTableModel tmodel;
	public FacultyM(){
		super();
		initComponents();
	}
	private void initComponents(){
		int num,i=0,j;
		Object[] labels = {"First Name","Last Name","Degree","Title","MaxLoadFall","MaxLoadSpring","MaxLoadSummer","Courses Taught","Days toTeach"};
		Object[][] rows;
		num = CourseScheduler.coursesTable.size();
		rows = new Object[num][9];
		panel = new JPanel();
		b1 = new JButton("Add Faculty");
		b2 = new JButton("Update/Delete Faculty");
		b3 = new JButton("Cancel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		panel.setLayout(new GridBagLayout());
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		Enumeration e = CourseScheduler.facultyTable.elements();
		while(e.hasMoreElements()){
			Faculty f = (Faculty)e.nextElement();

			rows[i][0] = f.getFirstName();
			rows[i][1] = f.getLastName();
			rows[i][2] = f.getDegree();
			rows[i][3] = f.getTitle();
			rows[i][4] = new Integer(f.getMaxLoadFall());
			rows[i][5] = new Integer(f.getMaxLoadSpring());
			rows[i][6] = new Integer(f.getMaxLoadSummmer());
			rows[i][7] = f.getCoursesTaught();
			rows[i][8] = f.getDaystoTeach();
			i++;
		}
		tmodel = new DefaultTableModel(rows,labels);
		jt = new JTable(tmodel);
		tpanel = new JPanel();
		tpanel.add(new JScrollPane(jt));
		this.add(panel,BorderLayout.NORTH);
		this.add(tpanel,BorderLayout.CENTER);
		
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			JFrame ac = new AddFacultyForm();
			this.dispose();
			ac.setVisible(true);
		}
		if (ae.getSource()==b2){
			Faculty f=null;
			int row = jt.getSelectedRow();
			if (row>=0){
			f = new Faculty();
			f.setFirstName((String)jt.getValueAt(row, 0));
			f.setLastName((String)jt.getValueAt(row, 1));
			f.setDegree((String)jt.getValueAt(row, 2));
			f.setTitle((String)jt.getValueAt(row, 3));
			f.setMaxLoadSummmer(((Integer)jt.getValueAt(row, 4)).intValue());
			f.setMaxLoadSpring(((Integer)jt.getValueAt(row, 5)).intValue());
			f.setMaxLoadFall(((Integer)jt.getValueAt(row, 6)).intValue());
			List coursesTaught = (List)jt.getValueAt(row, 7);
			f.setCoursesTaught(coursesTaught);
			f.setDaystoTeach((String)jt.getValueAt(row, 8));
			}else{
				JOptionPane.showMessageDialog(null, "Please Select a Row");
			}
			JFrame uf = new UpdateFacultyForm1(f);
			this.dispose();
			uf.setVisible(true);
		}
		if (ae.getSource()==b3){
			JFrame fh = new showHome();
			this.dispose();
			fh.setVisible(true);
		}
	}
}
