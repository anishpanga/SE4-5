package course.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import course.main.CourseScheduler;
import course.reports.FacultyLoadR;
import course.reports.Report1;

public class HomeFrame1 extends JFrame implements ActionListener{
	private JMenuBar menuBar;
	private JMenu maintenance,imp,schedule,reports,system;
	private JMenuItem university,courses,faculty,degree,students,studentcourses,generateS,testS,editS,
		scheduleR,facultyR,group,user,logout;
//	private JPanel homepanel;
//	private JLabel l1;
	
	public HomeFrame1(){
		initComponents();
	}
	/*public HomeFrame1(JPanel panel){
		this.homepanel = panel;
		initComponents();
	}*/
	private void initComponents(){
		menuBar = new JMenuBar();
		maintenance = new JMenu("Maintenance");
		imp = new JMenu("Import");
		schedule = new JMenu("Schedule");
		reports = new JMenu("Reports");
		system = new JMenu("System");
		// creating menu items
		
		university = new JMenuItem("University");
		courses = new JMenuItem("Courses");
		faculty = new JMenuItem("Faculty");
		degree = new JMenuItem("Degree");
		students = new JMenuItem("Students");
		studentcourses = new JMenuItem("Student Courses");
		
		generateS = new JMenuItem("Generate");
		testS = new JMenuItem("Test");
		editS = new JMenuItem("Edit");
		
		
		
		scheduleR = new JMenuItem("Schedule");
		facultyR = new JMenuItem("Faculty");
		
		group = new JMenuItem("Group");
		user = new JMenuItem("User");
		logout = new JMenuItem("Logout");
		//adding menuitems
		maintenance.add(university);
		maintenance.add(courses);
		maintenance.add(faculty);
		maintenance.add(degree);
		
		university.addActionListener(this);
		courses.addActionListener(this);
		faculty.addActionListener(this);
		degree.addActionListener(this);
		
		imp.add(students);
		imp.add(studentcourses);
		
		students.addActionListener(this);
		studentcourses.addActionListener(this);
		
		schedule.add(generateS);
		schedule.add(testS);
		schedule.add(editS);
		
		generateS.addActionListener(this);
		testS.addActionListener(this);
		editS.addActionListener(this);
		reports.add(scheduleR);
		reports.add(facultyR);
		scheduleR.addActionListener(this);
		facultyR.addActionListener(this);
		system.add(group);
		system.add(user);
		system.add(logout);
		user.addActionListener(this);
		logout.addActionListener(this);
		
		menuBar.add(maintenance);
		menuBar.add(imp);
		menuBar.add(schedule);
		menuBar.add(reports);
		menuBar.add(system);
		
		//l1 = new JLabel("Oklahoma Christain University");
		
		//homepanel.setLayout(new GridBagLayout());
		//homepanel.add(l1);
		this.setJMenuBar(menuBar);
		this.setLayout(new BorderLayout());
		//this.add(homepanel,BorderLayout.CENTER);
		this.setTitle("Course Scheduler");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(600,600));
		pack();
	}
	
	public void actionPerformed(ActionEvent ae){
		if (ae.getSource()==university){
			System.out.println("uni edit");
			JFrame uedit = new universityE(CourseScheduler.university);
			//this.remove(homepanel);
			//this.homepanel = uedit;
			//this.add(homepanel,BorderLayout.CENTER);
			//this.validate();
			//this.panel.validate();
			//add(uedit);
			//JFrame hf = new HomeFrame1(uedit);
			//hf.setVisible(true);
			//this.repaint();
			this.dispose();
			uedit.setVisible(true);
		}
		if (ae.getSource()==courses){
			JFrame cm = new CourseM();
			
			/*this.remove(panel);
			this.panel = cm;
			this.add(panel,BorderLayout.CENTER);
			this.validate();
			this.repaint();*/
			this.dispose();
			cm.setVisible(true);
		}
		if (ae.getSource()==faculty){
			JFrame fm = new FacultyM();
			this.dispose();
			fm.setVisible(true);
		}
		if (ae.getSource()==degree){
			JFrame df = new DegreeM();
			this.dispose();
			df.setVisible(true);
		}
		if (ae.getSource()==students){
			JFrame uStudents = new uploadStudentData();
			this.dispose();
			uStudents.setVisible(true);
		}
		if (ae.getSource()==studentcourses){
			JFrame uStuc = new UploadStudentCourses();
			this.dispose();
			uStuc.setVisible(true);
		}
		if (ae.getSource()==generateS){
			JFrame gs = new GenerateSchedule();
			this.dispose();
			gs.setVisible(true);
		}
		if (ae.getSource()==testS){
			JFrame gs = new TestSchedule();
			this.dispose();
			gs.setVisible(true);
		}
		if (ae.getSource()==editS){
			JFrame gs = new EditScheduleF();
			this.dispose();
			gs.setVisible(true);
		}
		if (ae.getSource()==scheduleR){
			JFrame gs = new Report1();
			this.dispose();
			gs.setVisible(true);
		}
		if (ae.getSource()==facultyR){
			JFrame gs = new FacultyLoadR();
			this.dispose();
			gs.setVisible(true);
		}
		if (ae.getSource()==user){
			JFrame userM = new UserM();
			this.dispose();
			userM.setVisible(true);
		}
		if (ae.getSource() == logout){
			CourseScheduler.saveData();
			System.exit(1);
		}
	}
}
