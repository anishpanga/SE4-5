package course.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import course.bean.Faculty;
import course.bean.Schedule;
import course.bean.Section;
import course.bean.Semester;

public class EditSchedule extends HomeFrame1 implements ActionListener{

	private JPanel panel,tpanel;
	private JTable jt;
	private DefaultTableModel tablemodel;
	private Schedule schedule;
	private JButton b1,b2,b3;
	
	public EditSchedule(Schedule schedule){
		this.schedule = schedule;
		initComponents();
	}
	private void initComponents(){
		
		List sections = schedule.getSections();
		Object labels[] ={"Semester","Section Number","Number of Students","Faculty"};
		Object rows[][] = new Object[sections.size()][4];
		for (int i=0;i<sections.size();i++){
			Section s = (Section)sections.get(i);
			rows[i][1] = s.getSectionNumber();
			rows[i][0] = s.getSemester();
			rows[i][2] = Integer.toString(s.getNumStudents());
			rows[i][3] = s.getFaculty();
		}
		tablemodel = new DefaultTableModel(rows,labels);
		jt = new JTable(tablemodel);
		tpanel = new JPanel();
		tpanel.add(new JScrollPane(jt));
		panel = new JPanel(new GridBagLayout());
		b1 = new JButton("Edit/Delete");
		//b2 = new JButton("Delete");
		b3 = new JButton("Cancel");
		b1.addActionListener(this);
		//b2.addActionListener(this);
		b3.addActionListener(this);
		panel.add(b1);//panel.add(b2);
		panel.add(b3);
		this.add(panel,BorderLayout.NORTH);
		this.add(tpanel,BorderLayout.CENTER);
		
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			int r = jt.getSelectedRow();
			if (r>=0){
				Section sc = new Section();
				 
				Semester semester = (Semester)jt.getValueAt(r, 0);
				
				sc.setSemester(semester);
				String secNum = (String)jt.getValueAt(r,1);
				sc.setSectionNumber(secNum);
				sc.setNumStudents(Integer.parseInt((String)jt.getValueAt(r,2)));
				sc.setFaculty((Faculty)jt.getValueAt(r, 3));
				JFrame es = new EditSection(this.schedule,sc);
				this.dispose();
				es.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "Please Select Section");
			}

		}
		if (ae.getSource()==b2){
			int r = jt.getSelectedRow();
			if (r>=0){
			Section sc = new Section();
			
			Semester semester = (Semester)jt.getValueAt(r, 0);
			
			sc.setSemester((semester));
			String secNum = (String)jt.getValueAt(r,1);
			sc.setSectionNumber(secNum);
			sc.setNumStudents(Integer.parseInt((String)jt.getValueAt(r,2)));
			sc.setFaculty((Faculty)jt.getValueAt(r, 3));
			List sections = this.schedule.getSections();
			sections.remove(sc);
			this.schedule.setSections(sections);
			JOptionPane.showMessageDialog(null, "Section Removed");
			}else{
				JOptionPane.showMessageDialog(null, "Please Select Section");
			}
			
		}
		if (ae.getSource()==b3){
			JFrame esf = new EditScheduleF();
			this.dispose();
			esf.setVisible(true);
		}
	} // end of ActionPerformed
}
