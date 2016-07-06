package course.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserM extends HomeFrame1 implements ActionListener{

	private JButton b1,b2,b3;
	private JPanel panel;
	public UserM(){
		super();
		initComponents();
	}
	private void initComponents(){
		panel = new JPanel();
		b1 = new JButton("Add");
		b2 = new JButton("Update/Delete");
		b3 = new JButton("Cancel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		panel.setLayout(new GridBagLayout());
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		this.add(panel,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			JFrame au = new AddUserForm();
			this.dispose();
			au.setVisible(true);
			
		}
		if (ae.getSource()==b2){
			JFrame uc = new UpdateUser();
			this.dispose();
			uc.setVisible(true);
		}
		if (ae.getSource()==b3){
			JFrame sh = new showHome();
			this.dispose();
			sh.setVisible(true);
		}
	}

}
