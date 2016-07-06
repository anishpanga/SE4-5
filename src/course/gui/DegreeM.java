package course.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import course.bean.DegreePlan;
import course.main.CourseScheduler;

public class DegreeM extends HomeFrame1 implements ActionListener{
	private JButton b1,b2,b3;
	private JTable jt;
	private DefaultTableModel tablemodel;
	private JPanel panel,tpanel;
	public DegreeM(){
		super();
		initComponents();
	}
	private void initComponents(){
		int num,i=0;
		Object[] labels = {"Degree Code","Degree Name","Department","Track"};
		Object[][] rows;
		num = CourseScheduler.degreePlans.size();
		rows = new Object[num][4];
		panel = new JPanel();
		tpanel = new JPanel();
		b1 = new JButton("AddDegreePlan");
		b2 = new JButton("Update/Delete DegreePlan");
		b3 = new JButton("Cancel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		Enumeration e = CourseScheduler.degreePlans.elements();
		while(e.hasMoreElements()){
			DegreePlan dp = (DegreePlan)e.nextElement();
			rows[i][0] = dp.getDegreeCode();
			rows[i][1] = dp.getName();
			rows[i][2] = dp.getDept();
			rows[i][3] = dp.getTrack();
			i++;
		}
		tablemodel = new DefaultTableModel(rows,labels);
		jt = new JTable(tablemodel);
		jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tpanel.add(new JScrollPane(jt));
		panel.setLayout(new GridBagLayout());
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		this.add(panel,BorderLayout.NORTH);
		this.add(tpanel,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			JFrame adp = new AddDegreePlan1();
			this.dispose();
			adp.setVisible(true);
			
		}
		if (ae.getSource()==b2){
			int r = jt.getSelectedRow();
			String degreecode = (String)jt.getValueAt(r, 0);
			DegreePlan dp = (DegreePlan)CourseScheduler.degreePlans.get(degreecode);
			System.out.println("DP Degree code"+dp.getDegreeCode());
			JFrame udp = new UpdateDegreePlan1(dp);
			this.dispose();
			udp.setVisible(true);
		}
		if (ae.getSource()==b3){
			JFrame sh = new showHome();
			this.dispose();
			sh.setVisible(true);
		}
	}

}
