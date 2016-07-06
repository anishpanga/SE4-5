package course.gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import course.bean.Schedule;
import course.bean.Section;

public class ShowSchedule extends HomeFrame1{

	private JPanel panel;
	private JTable jt;
	private Schedule schedule;
	private DefaultTableModel tablemodel;
	
	public ShowSchedule(){
		super();
	}
	public ShowSchedule(Schedule schedule){
		this.schedule = schedule;
		initComponents();
	}
	private void initComponents(){
		panel = new JPanel();
		List sections = schedule.getSections();
		Object labels[] ={"Semester","Course Code","Section Number","NumberOfStudents","Faculty"};
		Object rows[][] = new Object[sections.size()][5];
		for (int i=0;i<sections.size();i++){
			Section s = (Section)sections.get(i);
			rows[i][1] = s.getCourse();
			rows[i][0] = s.getSemester();
			rows[i][2] = s.getSectionNumber();
			rows[i][3] = Integer.toString(s.getStudentsAssigned().size());
			rows[i][4] = s.getFaculty();
		}
		tablemodel = new DefaultTableModel(rows,labels);
		jt = new JTable(tablemodel);
		panel.add(new JScrollPane(jt));
		this.add(panel,BorderLayout.CENTER);
	}
}
