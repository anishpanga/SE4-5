package course.gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import course.main.CourseScheduler;

public class HomeFrame extends JFrame implements ActionListener{
	private JMenuBar menuBar;
	private JMenu course,faculty,degreePlan,reports,exit;
	private JMenuItem addCourse,editCourse,deleteCourse,addFaculty,editFaculty,
	deleteFaculty,addDegreePlan,editDegreePlan,deleteDegreePlan,defineSem,
	uploadStudents,logout;
	private JPanel panel;
	public HomeFrame(JPanel panel){
		this.panel = panel;
		initComponents();
	}
	private void initComponents(){
		menuBar = new JMenuBar();
		course = new JMenu("Course");
		faculty = new JMenu("Faculty");
		degreePlan = new JMenu("Degree Plan");
		reports = new JMenu("Reports");
		exit = new JMenu("Exit");
		// defining menuItems
		
		addCourse = new JMenuItem("Add Course");
		editCourse = new JMenuItem("Edit Course");
		defineSem = new JMenuItem("Define Semester");
		uploadStudents = new JMenuItem("Upload Students");
		//deleteCourse = new JMenuItem("Delete Course");
		addFaculty = new JMenuItem("Add Faculty");
		editFaculty = new JMenuItem("Edit Faculty");
		//deleteFaculty = new JMenuItem("Delete Faculty");
		
		addDegreePlan = new JMenuItem("Add DegreePlan");
		editDegreePlan = new JMenuItem("Edit DegreePlan");
		
		
		logout = new JMenuItem("Logout");
		
		addCourse.addActionListener(this);
		editCourse.addActionListener(this);
		defineSem.addActionListener(this);
		uploadStudents.addActionListener(this);
	//	deleteCourse.addActionListener(this);
		addFaculty.addActionListener(this);
		editFaculty.addActionListener(this);
	//	deleteFaculty.addActionListener(this);
		addDegreePlan.addActionListener(this);
		editDegreePlan.addActionListener(this);
		
		logout.addActionListener(this);
		
		//exit.addActionListener(this);
		// add menu items to Menu
		course.add(addCourse);
		course.add(editCourse);
		course.add(defineSem);
		course.add(uploadStudents);
		//course.add(deleteCourse);
		faculty.add(addFaculty);
		faculty.add(editFaculty);
		//faculty.add(deleteFaculty);
		
		degreePlan.add(addDegreePlan);
		degreePlan.add(editDegreePlan);
		
		
		exit.add(logout);
		
		//add menus to MenuBar
		menuBar.add(course);
		menuBar.add(faculty);
		menuBar.add(degreePlan);
		menuBar.add(reports);
		menuBar.add(exit);
		
		
		this.setJMenuBar(menuBar);
		this.add(panel);
		this.setTitle("Course Scheduler");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(500,500));
		pack();
	}
	
	public void actionPerformed(ActionEvent ae){
		if (ae.getSource()==addCourse){
		/*	JPanel addcourse = new AddCourseForm();
			//this.panel = addcourse;
			//this.setVisible(true);
			this.dispose();
			HomeFrame hf = new HomeFrame(addcourse);
			hf.setVisible(true);*/
		}
		if (ae.getSource()==addFaculty){
/*			JPanel afaculty = new AddFacultyForm();
			this.dispose();
			HomeFrame hf = new HomeFrame(afaculty);
			hf.setVisible(true);*/
		}
		if (ae.getSource()==editCourse){
		/*	JPanel uCourse = new UpdateCourseForm();
			this.dispose();
			HomeFrame hf = new HomeFrame(uCourse);
			hf.setVisible(true);*/
		}
		if (ae.getSource()==editFaculty){
			/*JPanel uFaculty = new UpdateFacultyForm();
			this.dispose();
			HomeFrame hf = new HomeFrame(uFaculty);
			hf.setVisible(true);*/
		}
		if (ae.getSource()==addDegreePlan){
			/*JPanel aDegreeplan = new AddDegreePlan1();
			this.dispose();
			HomeFrame hf = new HomeFrame(aDegreeplan);
			hf.setVisible(true);*/
		}
		if (ae.getSource()==editDegreePlan){
			/*JPanel uDegreeplan = new UpdateDegreePlan1();
			this.dispose();
			HomeFrame hf = new HomeFrame(uDegreeplan);
			hf.setVisible(true);*/
		}
		if (ae.getSource()==defineSem){
		/*	JPanel defSem = new SemesterForm();
			this.dispose();
			Frame hf = new HomeFrame(defSem);
			hf.setVisible(true);*/
		}
		if (ae.getSource()==uploadStudents){
			/*JPanel uStudents = new uploadStudentData();
			this.dispose();
			Frame hf = new HomeFrame(uStudents);
			hf.setVisible(true);*/
		}
		if (ae.getSource()== logout){
			CourseScheduler.saveData();
			
			System.exit(1);
		}
	}
}
