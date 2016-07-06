package course.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import course.bean.User;
import course.main.CourseScheduler;

public class AddUserForm extends HomeFrame1 implements ActionListener{

	private JLabel l1,l2,l3,l4,l5;
	private JTextField t1,t2,t3;
	private JButton b1,b2;
	private JComboBox jb;
	private JPanel panel;
	public AddUserForm(){
		initComponents();
	}
	private void initComponents(){
		String[] utypes = {"Admin","Director"};
		panel = new JPanel(new GridLayout(5,2,10,10));
		l1 = new JLabel("Email");
		l2 = new JLabel("Username");
		l3 = new JLabel("Password");
		l4 = new JLabel("User Type");
		l5 = new JLabel("Add New User");
		l5.setFont(new Font("Tahoma",1,18));
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		jb = new JComboBox(utypes);
		b1 = new JButton("Save");
		b2 = new JButton("Cancel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		panel.add(l1);panel.add(t1);
		panel.add(l2);panel.add(t2);
		panel.add(l3);panel.add(t3);
		panel.add(l4);panel.add(jb);
		panel.add(b1);panel.add(b2);
		this.add(l5,BorderLayout.PAGE_START);
		this.add(panel,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			User u = new User();
			String email = t1.getText();
			u.setEmail(email);
			u.setUsername(t2.getText());
			u.setPassword(t3.getText());
			u.setUsertype((String)jb.getSelectedItem());
			// saving user data
			CourseScheduler.users.put(email, u);
			JOptionPane.showMessageDialog(null, "User Data Stored");
		}
		if (ae.getSource()==b2){
			JFrame um = new UserM();
			this.dispose();
			um.setVisible(true);
		}
	}
}
