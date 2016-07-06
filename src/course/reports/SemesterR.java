package course.reports;

import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SemesterR extends JPanel{
	private JLabel l7;
	private JTable jt1;
	private String[] colNames = {"Degree Plan","Semester","Number Of Students"};
	private Vector colV,dataV,rowV;
	JScrollPane jp;
	public SemesterR(){
		initComponents();
	}
	private void initComponents(){
		
		colV = new Vector(Arrays.asList(colNames));
		rowV = new Vector();
		// sample data;
		dataV = new Vector();
		dataV.add("");
		dataV.add("");
		dataV.add("25");
		rowV.add(dataV);
		dataV = new Vector();
		dataV.add("");
		dataV.add("");
		dataV.add("18");
		
		rowV.add(dataV);
		jt1 = new JTable(rowV,colV);
		l7 = new JLabel(" DegreePlan Report ");
		l7.setFont(new java.awt.Font("Tahoma", 1, 24));
		jp = new JScrollPane(jt1);
		setLayout(new BorderLayout());
		this.add(l7,BorderLayout.PAGE_START);
		this.add(jp,BorderLayout.CENTER);

}
}
