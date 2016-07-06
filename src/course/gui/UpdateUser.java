package course.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import course.bean.User;
import course.main.CourseScheduler;

public class UpdateUser extends HomeFrame1 implements ActionListener,ItemListener{

	private JComboBox jb,jb1;
	private JLabel l1,l2,l3,l4,l5;
	private JTextField t1,t2,t3;
	private JButton b1,b2,b3;
	private JPanel panel;
	private String[] usera;
	
	public UpdateUser(){
		initComponents();
	}
	private void initComponents(){
		int i=0,num;
		String[] utypes = {"Admin","Director"};
		panel = new JPanel(new GridLayout(5,2,10,10));
		l1 = new JLabel("Email");
		l2 = new JLabel("Username");
		l3 = new JLabel("Password");
		l5 = new JLabel("User Type");
		l4 = new JLabel("Update User");
		l4.setFont(new Font("Tahoma",1,18));
		//t1 = new JTextField(20);
		num = CourseScheduler.users.size();
		usera = new String[num];
		Enumeration e = CourseScheduler.users.keys();
		while(e.hasMoreElements()){
			usera[i] = (String)e.nextElement();
			i++;
		}
		jb = new JComboBox(usera);
		jb.addItemListener(this);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		jb1 = new JComboBox(utypes);
		b1 = new JButton("Update");
		b2 = new JButton("Cancel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		panel.add(l1);panel.add(jb);
		panel.add(l2);panel.add(t2);
		panel.add(l3);panel.add(t3);
		panel.add(l5);panel.add(jb1);
		panel.add(b1);panel.add(b2);
		this.add(l4,BorderLayout.PAGE_START);
		this.add(panel,BorderLayout.CENTER);
	
	}
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		if (ae.getSource()==b1){
			String uemail = (String)jb.getSelectedItem();
			User user = new User();
			user.setEmail(uemail);
			user.setUsername(t2.getText());
			user.setPassword(t3.getText());
			user.setUsertype((String)jb1.getSelectedItem());
			// updating user
			CourseScheduler.users.remove(uemail);
			CourseScheduler.users.put(uemail, user);
		}
		if (ae.getSource()==b2){
			JFrame uh = new UserM();
			this.dispose();
			uh.setVisible(true);
		}
	}
	public void itemStateChanged(ItemEvent ie){
		String uemail = (String)jb.getSelectedItem();
		User user =(User) CourseScheduler.users.get(uemail);
		t2.setText(user.getUsername());
		t3.setText(user.getPassword());
		jb1.setSelectedItem(user.getUsertype());
	}
}
