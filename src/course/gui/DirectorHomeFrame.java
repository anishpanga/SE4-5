package course.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DirectorHomeFrame extends JFrame implements ActionListener{
	private JMenuBar menuBar;
	private JMenu course,faculty,degreePlan,schedule,reports,exit;
	private JMenuItem addCourse,editCourse,deleteCourse,addFaculty,editFaculty,deleteFaculty,addDegreePlan,editDegreePlan,deleteDegreePlan;
	private JMenuItem generateSchedule,testSchedule;
	private JPanel panel;
	public DirectorHomeFrame(JPanel panel){
		this.panel = panel;
		initComponents();
	}
	private void initComponents(){
		menuBar = new JMenuBar();
		course = new JMenu("Course");
		faculty = new JMenu("Faculty");
		degreePlan = new JMenu("Degree Plan");
		schedule = new JMenu("Schedule");
		reports = new JMenu("Reports");
		exit = new JMenu("Exit");
		// defining menuItems
		
		addCourse = new JMenuItem("Add Course");
		editCourse = new JMenuItem("Edit Course");
		//deleteCourse = new JMenuItem("Delete Course");
		addFaculty = new JMenuItem("Add Faculty");
		editFaculty = new JMenuItem("Edit Faculty");
		//deleteFaculty = new JMenuItem("Delete Faculty");
		
		addDegreePlan = new JMenuItem("Add DegreePlan");
		editDegreePlan = new JMenuItem("Edit DegreePlan");
		
		addCourse.addActionListener(this);
		editCourse.addActionListener(this);
	//	deleteCourse.addActionListener(this);
		addFaculty.addActionListener(this);
		editFaculty.addActionListener(this);
	//	deleteFaculty.addActionListener(this);
		addDegreePlan.addActionListener(this);
		editDegreePlan.addActionListener(this);
		
		// schedule Menu
		generateSchedule = new JMenuItem("Generate Schedule");
		testSchedule = new JMenuItem("Test Schedule");
		
		exit.addActionListener(this);
		// add menu items to Menu
		course.add(addCourse);
		course.add(editCourse);
		//course.add(deleteCourse);
		faculty.add(addFaculty);
		faculty.add(editFaculty);
		//faculty.add(deleteFaculty);
		
		degreePlan.add(addDegreePlan);
		degreePlan.add(editDegreePlan);
		
		schedule.add(generateSchedule);
		schedule.add(testSchedule);
		
		//add menus to MenuBar
		menuBar.add(course);
		menuBar.add(faculty);
		menuBar.add(degreePlan);
		menuBar.add(schedule);
		menuBar.add(reports);
		menuBar.add(exit);
		
		
		this.setJMenuBar(menuBar);
		this.add(panel);
		this.setTitle("Director Course Scheduler");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500,500));
		pack();
	}
	
	public void actionPerformed(ActionEvent ae){
		if (ae.getSource()==addCourse){
/*			JPanel addcourse = new AddCourseForm();
			DirectorHomeFrame hf = new DirectorHomeFrame(addcourse);
			hf.setVisible(true);*/
		}
		if (ae.getSource()==addFaculty){
		/*	JPanel afaculty = new AddFacultyForm();
			DirectorHomeFrame hf = new DirectorHomeFrame(afaculty);
			hf.setVisible(true);*/
		}
		if (ae.getSource()==editCourse){
		/*	JPanel uCourse = new UpdateCourseForm();
			DirectorHomeFrame hf = new DirectorHomeFrame(uCourse);
			hf.setVisible(true);*/
		}
		if (ae.getSource()==editFaculty){
			/*JPanel uFaculty = new UpdateFacultyForm();
			DirectorHomeFrame hf = new DirectorHomeFrame(uFaculty);
			hf.setVisible(true);*/
		}
		if (ae.getSource()==addDegreePlan){
		/*	JPanel aDegreeplan = new AddDegreePlan();
			DirectorHomeFrame hf = new DirectorHomeFrame(aDegreeplan);
			hf.setVisible(true);*/
		}
		if (ae.getSource()== exit){
			System.exit(1);
		}
	}
}
