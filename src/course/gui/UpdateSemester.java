package course.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Date;
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
public class UpdateSemester extends HomeFrame1{
	
	private JLabel l1,l2,l3,l4,l5,l6;
	private JTextField t1,t2,t3,t4;
	private JComboBox jb;
	private String[] st = {"Summer","Spring","Fall"};
	private JButton b1,b2,b3;
	private JPanel panel,bpanel;
	
	private Properties props;
	private JDatePickerImpl datePicker1,datePicker2;
	private Semester semester;
	public UpdateSemester(Semester semester){
		this.semester = semester;
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
	//	model.setDate(2016, 6, 14);
	//	model.setSelected(true);
		UtilDateModel model2 = new UtilDateModel();
		
	//	UtilCalendarModel model = new UtilCalendarModel();
//		SqlDateModel model = new SqlDateModel();
		
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model,props);
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2,props);

		datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		datePicker1.getModel().setValue(semester.getStartDate());
		datePicker2.getModel().setValue(semester.getEndDate());
		t3.setText(Integer.toString(semester.getYear()));
		jb = new JComboBox(st);
		jb.setSelectedItem(semester.getSemesterType());
		
		b1 = new JButton("Update");
		b2 = new JButton("Clear");
		b3 = new JButton("Cancel");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		l6 = new JLabel("Update Semester ");
		l6.setFont(new java.awt.Font("Tahoma", 1, 18));
		panel = new JPanel(new GridLayout(6,2,10,10));
		//panel.add(l1);panel.add(t1);
		panel.add(l1);panel.add(datePicker1);
				
		panel.add(l2);panel.add(datePicker2);
		panel.add(l3);panel.add(t3);
		panel.add(l5);panel.add(jb);
		//panel.add(label6);panel.add(tf5);
		bpanel = new JPanel();
		bpanel.add(b1);
		//bpanel.add(b2);
		bpanel.add(b3);
		panel.add(bpanel);
		
		this.add(l6,BorderLayout.NORTH);
		this.add(panel,BorderLayout.CENTER);
		
}
	public void actionPerformed(ActionEvent ae){
		String st;
		StringBuilder semNum;
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			
		semester.setStartDate((Date)datePicker1.getModel().getValue());
		semester.setEndDate((Date)datePicker2.getModel().getValue());
		semester.setYear(Integer.parseInt(t3.getText()));
		st = (String)jb.getSelectedItem();
		semester.setSemesterType(st);
		if (st.equals("Spring"))
			semNum = new StringBuilder("S");
		else if (st.equals("Fall"))
			semNum = new StringBuilder("F");
		else
			semNum = new StringBuilder("SU");
		semNum.append(t3.getText());
		System.out.println("Sem Num  "+semNum);
		semester.setSemesterNumber(semNum.toString());
		JOptionPane.showMessageDialog(null, "Semester Updated");
		this.dispose();
		JFrame ueh = new universityE(CourseScheduler.university);
		ueh.setVisible(true);
		}
		if (ae.getSource()==b3){
			JFrame ueh = new universityE(CourseScheduler.university);
			this.dispose();
			ueh.setVisible(true);
		}
	}
}