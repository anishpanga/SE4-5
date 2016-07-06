package course.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import au.com.bytecode.opencsv.CSVReader;
import course.bean.Course;
import course.bean.DegreePlan;
import course.bean.DegreePlanReq;
import course.bean.Faculty;

public class ImportData {
	
	public static void importCourses(File file){
		List pc = null;Course pcr;
		CSVReader csvReader;
		try{
		csvReader = new CSVReader(new FileReader(file),',','"',1);
		String[] row = null;
		while ((row = csvReader.readNext()) != null) {
			Course c = new Course();
			c.setCourseCode(row[0]);
			c.setCourseName(row[1]);
			c.setCourseDesc(row[2]);
			c.setCreditsEarned(Integer.parseInt(row[3]));
			c.setCapacity(Integer.parseInt(row[4]));
			if (row[5].equals("Y")){
				c.setOfferedFall(true);
			}else{
				c.setOfferedFall(false);
			}
			//System.out.println(row[5]+"---"+c.isOfferedFall());
			if (row[6].equals("Y")){
				c.setOfferedSpring(true);
			}else
			{
				c.setOfferedSpring(false);
			}
			if (row[7].equals("Y")){
				c.setOfferedSummer(true);
			}else{
				c.setOfferedSummer(false);
			}
				
			StringTokenizer st = new StringTokenizer(row[8],",");
			int nt = st.countTokens();
			String token = st.nextToken();
			pc = new ArrayList();
			if (nt==1 && token.equals("none")){
				
			}
			else{
				pcr = (Course)CourseScheduler.coursesTable.get(token);
				pc.add(pcr);
				while(st.hasMoreTokens()){
					token = st.nextToken();
					pcr = (Course)CourseScheduler.coursesTable.get(token);
					pc.add(pcr);
				}
			}
			c.setPrerequisites(pc);
			// saving teachers info
			StringTokenizer st1 = new StringTokenizer(row[9],",");
			while(st1.hasMoreTokens()){
				String token1 = st1.nextToken();
				//System.out.println("Staff  "+token1);
				Faculty f = (Faculty)CourseScheduler.facultyTable.get(token1);
				if (f != null)
					f.getCoursesTaught().add(c);
			}
			if (CourseScheduler.coursesTable.containsKey(row[0])){
				CourseScheduler.coursesTable.remove(row[0]);
			}
			CourseScheduler.coursesTable.put(row[0], c);
		}
		csvReader.close();
		System.out.println(CourseScheduler.coursesTable.size());
		}catch(FileNotFoundException fe){
			fe.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	// import faculty
	public static void importFaculty(File file){
		CSVReader csvReader;
		try{
		csvReader = new CSVReader(new FileReader(file),',','"',1);
		String[] row = null;
		while ((row = csvReader.readNext()) != null) {
			Faculty f = new Faculty();
			//String lastName = row[0];
			f.setLastName(row[0]);
			f.setFirstName(row[1]);
			f.setDegree(row[3]);
			f.setTitle(row[4]);
			f.setDaystoTeach(row[5]);
			f.setMaxLoadFall(Integer.parseInt(row[6]));
			f.setMaxLoadSpring(Integer.parseInt(row[7]));
			f.setMaxLoadSummmer(Integer.parseInt(row[8]));
			f.setCoursesTaught(new ArrayList());
			if (CourseScheduler.facultyTable.containsKey(row[0]))
			{
				CourseScheduler.facultyTable.remove(row[0]);
			}
			CourseScheduler.facultyTable.put(row[0], f);
		}
		csvReader.close();
	}catch(FileNotFoundException fe){
		fe.printStackTrace();
	}catch(IOException ioe){
		ioe.printStackTrace();
	}
	}
	
	// import DegreePlans
	public static void importDegreePlans(File file){
		CSVReader csvReader;
		try{
		csvReader = new CSVReader(new FileReader(file),',','"',1);
		String[] row = null;
		while ((row = csvReader.readNext()) != null) {
			DegreePlan dp = new DegreePlan();
			dp.setDegreeCode(row[0]);
			dp.setName(row[2]);
			dp.setSemForecast(Integer.parseInt(row[3]));
			dp.setDegreePlanRequirements(new ArrayList());
			CourseScheduler.degreePlans.put(row[0], dp);
		}
		csvReader.close();
		
		}catch(FileNotFoundException fe){
			fe.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}	
	}
	
	public static void importDegreePlanReqs(File file){
		CSVReader csvReader;
		List courses;
		try{
		csvReader = new CSVReader(new FileReader(file),',','"',1);
		String[] row = null;
		while ((row = csvReader.readNext()) != null) {
			DegreePlanReq dpr = new DegreePlanReq();
			dpr.setDegreecode(row[0]);
			dpr.setDescription(row[1]);
			dpr.setHours(Integer.parseInt(row[2]));
			dpr.setType(row[3]);
			StringTokenizer st = new StringTokenizer(row[4],",");
			courses = new ArrayList();
			while(st.hasMoreTokens()){
				String c = st.nextToken();
				Course course = (Course)CourseScheduler.coursesTable.get(c);
				courses.add(course);
			}
			dpr.setCourses(courses);
			DegreePlan dp = (DegreePlan)CourseScheduler.degreePlans.get(row[0]);
			dp.getDegreePlanRequirements().add(dpr);
		}
		csvReader.close();
		
		}catch(FileNotFoundException fe){
			fe.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}
