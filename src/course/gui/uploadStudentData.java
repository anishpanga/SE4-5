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
import course.bean.DegreePlan;
import course.bean.Semester;
import course.bean.Student;
import course.main.CourseScheduler;

public class uploadStudentData extends HomeFrame1 implements ActionListener{

	private JFileChooser fc;
	private JPanel hpanel,panel;
	private JLabel jl;
	private JButton b1,b2;
	private JTextField t1;
	public uploadStudentData(){
		initComponents();
	}
	private void initComponents(){
		t1 = new JTextField(20);
		b1 = new JButton("Select File");
		b2 = new JButton("Upload Students");
		fc = new JFileChooser();
		panel = new JPanel();
		jl = new JLabel("Upload Student Data");
		jl.setFont(new java.awt.Font("Tahoma", 1, 24));
		
		panel.add(t1);panel.add(b1);
		panel.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		//this.setLayout(new BorderLayout());
		hpanel = new JPanel(new BorderLayout());
		hpanel.add(jl,BorderLayout.NORTH);
		hpanel.add(panel,BorderLayout.CENTER);
		this.add(hpanel,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae){
		// calling superclass AP
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			int rv = fc.showOpenDialog(null);
			if (rv == JFileChooser.APPROVE_OPTION){
				File f = fc.getSelectedFile();
				t1.setText(f.getAbsolutePath());
			}
		}
		if (ae.getSource()==b2){
			try{
			String fn = t1.getText();
			FileInputStream fis = new FileInputStream(fn);
			readCSV(fn);
			JFrame ss = new ShowStudents();
			this.dispose();
			ss.setVisible(true);
			}catch(Exception e){
				e.printStackTrace();
			}
		}// end if 
	}
	public void readCSV(String csvFilename)throws IOException{
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		String[] row = null;
		while ((row = csvReader.readNext()) != null) {
			//System.out.println(row[0] + " # " + row[1] + " #  " + row[2]);
			String studentid = row[0];
			String degreecode = row[1];
			String semesternum = row[2];
			List stc = new ArrayList();
			Student s = new Student();
			s.setStudentid(studentid);
			DegreePlan dp =(DegreePlan)CourseScheduler.degreePlans.get(degreecode);
			
			s.setDegreeplan(dp);
			Semester semester = new Semester();
			semester.setSemesterNumber(semesternum);
			s.setSemester(semester);
			s.setStudentcoursestatus(stc);
			// saving student info
			CourseScheduler.students.put(studentid, s);
		}

		csvReader.close();
		JOptionPane.showMessageDialog(null, "Student Info Imported");
	}
}
