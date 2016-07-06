package course.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class showHome extends HomeFrame1{
	private JPanel p;
	private JLabel l1;
public showHome(){
	//p = new JPanel();
	super();
	initComponents();
}
private void initComponents(){
	p = new JPanel();
	p.setLayout(new GridBagLayout());
	l1 = new JLabel("Oklahoma Christain University");
	p.add(l1);
	this.add(p,BorderLayout.CENTER);
}
}
