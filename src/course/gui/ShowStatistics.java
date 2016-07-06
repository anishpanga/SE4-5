package course.gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowStatistics extends HomeFrame1{

	private JPanel panel;
	private JLabel hl;
	public ShowStatistics(JPanel panel){
		this.panel = panel;
		initComponents();
	}
	private void initComponents(){
		hl = new JLabel("Statistics Of Schedule");
		hl.setFont(new Font("Tahoma",1,24));
		this.add(hl,BorderLayout.NORTH);
		this.add(panel,BorderLayout.CENTER);
	}
}
