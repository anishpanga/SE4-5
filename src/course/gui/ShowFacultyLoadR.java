package course.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ShowFacultyLoadR extends HomeFrame1{

	private JPanel panel;
	public ShowFacultyLoadR(JPanel panel){
		this.panel = panel;
		initComponents();
	}
	private void initComponents(){
		this.add(panel,BorderLayout.CENTER);
	}
}
