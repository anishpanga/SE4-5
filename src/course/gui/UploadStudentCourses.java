package course.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import au.com.bytecode.opencsv.CSVReader;
import course.bean.Course;
import course.bean.Semester;
import course.bean.Student;
import course.bean.StudentCourseGrade;
import course.main.CourseScheduler;

public class UploadStudentCourses extends HomeFrame1 implements ActionListener{

	private JPanel panel;
	private JLabel l1,l2;
	private JTextField t1;
	private JButton b1,b2;
	private JFileChooser jfc;
	
	public UploadStudentCourses(){
		initComponents();
	}
	private void initComponents(){
		panel = new JPanel();
		l1 = new JLabel("File Name");
		t1 = new JTextField(20);
		b1 = new JButton("Select File");
		b2 = new JButton("Upload Student Courses");
		jfc = new JFileChooser();
		panel.add(l1);panel.add(t1);
		panel.add(b1);panel.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		this.add(panel,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			
			int rv = jfc.showOpenDialog(null);
			if (rv == JFileChooser.APPROVE_OPTION){
				File f = jfc.getSelectedFile();
				t1.setText(f.getAbsolutePath());
			}// end of if
		}
		if (ae.getSource()==b2){
			try{
				String fn = t1.getText();
				FileInputStream fis = new FileInputStream(fn);
				readCSV(fn);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}// end of ActionPerformed
	
	public void readCSV(String filename) throws IOException{
		CSVReader csvReader = new CSVReader(new FileReader(filename),',');
		String[] row = null;
		while ((row = csvReader.readNext()) != null) {
			//System.out.println(row[0] + " # " + row[1] + " #  " + row[2]);
			//System.out.println(row[0]);
			String studentid = row[0];
			String coursecode = row[1];
			String cname = row[2];
			String sem = row[3];
			String st = row[4];
			System.out.println("studentid.."+studentid+"cc.."+coursecode);
			System.out.println("cname.."+cname+"semester.."+sem+"  status  "+st);
			Student s = (Student)CourseScheduler.students.get(studentid);
			//System.out.println("studentid  "+s.getStudentid());
			if (s!=null){
				List sc = s.getStudentcoursegrades();
				if (sc == null)
					sc = new ArrayList();
			
				StudentCourseGrade scs = new StudentCourseGrade(coursecode,cname,sem,st);
				sc.add(scs);
				s.setStudentcoursestatus(sc);			
			// saving student info
			System.out.println(coursecode +"is set for "+s.getStudentid());
			CourseScheduler.students.put(studentid, s);
			}
		}

		csvReader.close();
		JOptionPane.showMessageDialog(null, "Student courses Imported");
		JFrame ss = new ShowStudents();
		this.dispose();
		ss.setVisible(true);
	}

	
}
