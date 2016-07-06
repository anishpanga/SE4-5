package course.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import course.bean.Semester;
import course.main.CourseScheduler;

public class AddSemesterForm extends HomeFrame1 implements ActionListener{
	
	private JLabel l1,l2,l3,l4,l5,l6;
	private JTextField t1,t2,t3,t4;
	private JComboBox jb;
	private String[] st = {"Summer","Spring","Fall"};
	private JButton b1,b2,b3;
	private JPanel panel,bpanel;
	
	private Properties props;
	private JDatePickerImpl datePicker1,datePicker2;
	
	public AddSemesterForm(){
		initComponents();
	}
	private void initComponents(){
		l1 = new JLabel("Start Date");
		l2 = new JLabel("End Date");
		l3 = new JLabel("Year");
		l4 = new JLabel("Semester Code");
		l5 = new JLabel("Semester Type");
		
		//t1 = new JTextField(20);
		//t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
				
		props = new Properties();
		UtilDateModel model = new UtilDateModel();
		//model.setDate(2016, 6, 14);
		//model.setSelected(true);
		UtilDateModel model2 = new UtilDateModel();
		
	//	UtilCalendarModel model = new UtilCalendarModel();
//		SqlDateModel model = new SqlDateModel();
		
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model,props);
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2,props);
//		datePicker = new JDatePickerImpl(datePanel);
		datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());

		
		jb = new JComboBox(st);
		
		b1 = new JButton("Save");
		b2 = new JButton("Clear");
		b3 = new JButton("Cancel");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		l6 = new JLabel("Define New Semester ");
		l6.setFont(new java.awt.Font("Tahoma", 1, 24));
		panel = new JPanel(new GridLayout(6,2,10,10));
		//panel.add(l1);panel.add(t1);
		panel.add(l1);panel.add(datePicker1);
		//
		
		//panel.add(l2);panel.add(t2);
		panel.add(l2);panel.add(datePicker2);
		//panel.add(l3);panel.add(t3);
		//panel.add(l4);panel.add(t4);
		panel.add(l5);panel.add(jb);
		//panel.add(label6);panel.add(tf5);
		bpanel = new JPanel();
		bpanel.add(b1); bpanel.add(b2);bpanel.add(b3);
		panel.add(bpanel);
		//this.setLayout(new BorderLayout());
		this.add(l6,BorderLayout.NORTH);
		this.add(panel,BorderLayout.CENTER);
		
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		StringBuilder semNum;
		if (ae.getSource()==b1){
		Semester s = new Semester();
		Date startDate = (Date)datePicker1.getModel().getValue();
		Date endDate = (Date)datePicker2.getModel().getValue();
		s.setStartDate(startDate);
		s.setEndDate(endDate);
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		int year = c.get(Calendar.YEAR);
		System.out.println("Year  "+year);
		s.setYear(year);
	//	s.setYear(Integer.parseInt(t3.getText()));
		String st = (String)jb.getSelectedItem();
		s.setSemesterType(st);
		semNum = new StringBuilder(Integer.toString(year));
		if (st.equals("Spring"))
			//semNum = new StringBuilder("S");
			semNum.append("SP");
		else if (st.equals("Fall"))
			//semNum = new StringBuilder("F");
			semNum.append("FA");
		else
			//semNum = new StringBuilder("SU");
			semNum.append("SU");
		//semNum.append(t3.getText());
		System.out.println("Sem Num  "+semNum);
		s.setSemesterNumber(semNum.toString());
		// saving semster
		JOptionPane.showMessageDialog(null, semNum.toString()+" is the SemesterNumber");
		//List semList = CourseScheduler.university.getSemesters();
		CourseScheduler.university.getSemesters().add(s);
		// Getting back to Univesity
		JFrame ue = new universityE(CourseScheduler.university);
		this.dispose();
		ue.setVisible(true);
		}
		if (ae.getSource()==b2){
			datePicker1.getModel().setValue(new Date(System.currentTimeMillis()));
			datePicker2.getModel().setValue(new Date(System.currentTimeMillis()));
			t3.setText("");
			jb.setSelectedIndex(0);
		}
		if (ae.getSource()==b3){
			JFrame ueh = new universityE(CourseScheduler.university);
			this.dispose();
			ueh.setVisible(true);
		}
	}
}
