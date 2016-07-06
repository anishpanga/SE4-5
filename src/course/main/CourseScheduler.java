package course.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JFrame;

import course.bean.Schedule;
import course.bean.University;
import course.gui.LoginFrame;
public class CourseScheduler {

	/**
	 * @param args
	 */
	public static Hashtable coursesTable;
	public static Hashtable facultyTable;
	public static Hashtable degreePlans;
	public static Hashtable students;
	public static Hashtable users;
	public static University university;
	public static Hashtable scheduleTable;
	public CourseScheduler(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		coursesTable = new Hashtable();
		facultyTable = new Hashtable();
		degreePlans = new Hashtable();
		students = new Hashtable();
		users = new Hashtable();
		scheduleTable = new Hashtable();
		university = new University();
		System.out.println("initializing University");
		university.setName("");
		university.setAbbrevation("");
		university.setGradSchools(new ArrayList());
		university.setSemesters(new ArrayList());
		
	/*	GradSchool gs = new GradSchool();
		gs.setGradschoolname("Graduate School of Engineering and Computer Science");
		gs.setAbbr("GSECS");
		List dplans = new Vector();
		gs.setDegreePlansOffered(dplans);
		List gschools = new Vector();
		gschools.add(gs);
		List semesters = new ArrayList();*/
		
		
		// loading data
		loadData();
		// importing CoursesTestData
		
		File file1 = new File("TestData\\TestDataFaculty.csv");
		ImportData.importFaculty(file1);
		File file = new File("TestData\\TestDataCourses.csv");
		ImportData.importCourses(file);
		File file2 = new File("TestData\\TestDataDegrees.csv");
		ImportData.importDegreePlans(file2);
		File file3 = new File("TestData\\TestDataDegreePlanReq.csv");
		ImportData.importDegreePlanReqs(file3);
		
		
		if (university==null){
			System.out.println("initializing University");
			university.setName("");
			university.setAbbrevation("");
			university.setGradSchools(new ArrayList());
			university.setSemesters(new ArrayList());
		}
		// Login Frame
		JFrame lf = new LoginFrame();
		lf.setVisible(true);
	}
	
	public static void saveData(){
		Hashtable table;
		FileOutputStream fos;
		ObjectOutputStream oos;
		File file;
		try{
		// saving courses data
		System.out.println("Saving Courses --");
		file = new File("courses.ser");
		if (file.exists()){
			// delte existing file
			file.delete();
		}
		table = CourseScheduler.coursesTable;
		fos =new FileOutputStream(file);
		oos = new ObjectOutputStream(fos);
		
		// writing object
		oos.writeObject(table);
		
		oos.close();
		fos.close();
		
		//saving faculty data
		System.out.println("Saving Faculty --");
		file = new File("faculty.ser");
		if (file.exists()){
			file.delete();
		}
		table = CourseScheduler.facultyTable;
		
		fos =new FileOutputStream(file);
		oos = new ObjectOutputStream(fos);
		
		// writing object
		oos.writeObject(table);
		
		oos.close();
		fos.close();
		
		// saving degreePlans
		System.out.println("Saving DegreePlans --");
		file = new File("degreeplans.ser");
		if (file.exists()){
			file.delete();
		}
		table = CourseScheduler.degreePlans;
		fos = new FileOutputStream(file);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(table);
		
		oos.close();
		fos.close();
		
		// saving students info
		System.out.println("Saving Students --");
		file = new File("studump.ser");
		if (file.exists()){
			file.delete();
		}
		table = CourseScheduler.students;
		fos = new FileOutputStream(file);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(table);
		
		oos.close();
		fos.close();
		
		// saving users info
		System.out.println("Saving Users --");
		file = new File("users.ser");
		if (file.exists()){
			file.delete();
		}
		table = CourseScheduler.users;
		fos = new FileOutputStream(file);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(table);
		
		oos.close();
		fos.close();

		// saving Universiry Info
		System.out.println("Saving University --");
		file = new File("university.ser");
		if (file.exists()){
			file.delete();
		}
		fos = new FileOutputStream(file);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(CourseScheduler.university);
		
		
		
		// saving Schedule info
		
		
		System.out.println("Saving Schedule --");
		file = new File("schedules.ser");
		if (file.exists()){
			file.delete();
		}
		fos = new FileOutputStream(file);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(CourseScheduler.scheduleTable);
		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}		
	}
	public static void loadData(){
		File file;
		FileInputStream fis;
		ObjectInputStream ois;
		try{
			
			// loading users info
			System.out.println("loading users..");
			file = new File("users.ser");
			if (file.exists()){
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				// reading object
			
				users = (Hashtable)ois.readObject();
				System.out.println("Users.."+users.size());
			}
			// loading university Object
			System.out.println("loading university..");
			file = new File("university.ser");
			if (file.exists()){
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
			
				university = (University)ois.readObject();
				System.out.println("University.."+university.getName());
			}
			
			
			
			
			// loading courses data
			System.out.println("loading courses..");
			file = new File("courses.ser");
			if (file.exists()){
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			// reading object
			
			coursesTable = (Hashtable)ois.readObject();
			System.out.println("courses.."+coursesTable.size());
			}
			// loading faculty data
			
			System.out.println("loading faculty data..");
			file = new File("faculty.ser");
			if (file.exists()){
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			// reading object
			
			facultyTable = (Hashtable)ois.readObject();
			System.out.println("facultyTable.."+facultyTable.size());
			
			}
			
			System.out.println("loading degreePlans..");
			file = new File("degreeplans.ser");
			if (file.exists()){
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			// reading object
			
			degreePlans = (Hashtable)ois.readObject();
			System.out.println("degreePlans.."+degreePlans.size());
			
			}
			// loading students info
			System.out.println("loading studentsdump..");
			file = new File("studump.ser");
			if (file.exists()){
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			// reading object
			
			students = (Hashtable)ois.readObject();
			System.out.println("Students.."+students.size());
			
			}
			
			//loading Schedule
			System.out.println("loading schedule..");
			file = new File("schedules.ser");
			if (file.exists()){
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			// reading object
			
			scheduleTable = (Hashtable)ois.readObject();
			System.out.println("Schedules loaded.."+scheduleTable.size());
			}
			
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			//System.out.println("FileNot Found:"+e);
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			//saveData();
		}
	}
	
}
