package course.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import course.main.CourseScheduler;
import course.bean.*;

public class LoginFrame extends JFrame implements ActionListener{

	private JLabel label1,label2,label3;
	private JTextField textfield1,textfield2;
	private JButton button1,button2;
	private JPanel panel;
	public LoginFrame(){
		initComponents();
	}
	private void initComponents(){
	
		label1 = new JLabel("Email");
		label2 = new JLabel("Password");
		label3 = new JLabel("Course Scheduling");
		label3.setFont(new java.awt.Font("Tahoma", 1, 24)); 
		textfield1 = new JTextField(20);
		textfield2 = new JPasswordField(20);
		button1 = new JButton("Login");
		button2 = new JButton("Reset");
		button1.addActionListener(this);
		button2.addActionListener(this);
		panel = new JPanel(new GridLayout(3,2,10,10));
		panel.add(label1);
		panel.add(textfield1);
		panel.add(label2);
		panel.add(textfield2);
		panel.add(button1);
		panel.add(button2);
		this.setLayout(new BorderLayout());
		add(label3,BorderLayout.PAGE_START);
		add(panel,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(800,800));
		pack();
	}
	public void actionPerformed(ActionEvent ae){
		if ( ae.getSource()== button1){
			String email = textfield1.getText();
			String pwd = textfield2.getText();
			User user = (User)CourseScheduler.users.get(email);
		
			if (email.equals("")|| pwd.equals("")){
				JOptionPane.showMessageDialog(null, "Please Enter values for Email and Pwd");
			}
			
			else if (user == null){
				JOptionPane.showMessageDialog(null, "No user with that Email");
			}
			else if ( user != null && pwd.equals(user.getPassword())&& "Director".equals(user.getUsertype())){
				//CourseScheduler.loadData();
				System.out.println("User Type  "+user.getUsertype());
				//JPanel p = new JPanel();
				JFrame hf = new showHome();
				this.dispose();
				hf.setVisible(true);
			}else if(user != null && pwd.equals(user.getPassword()) && "Admin".equals(user.getUsertype()))
				{
				//CourseScheduler.loadData();
				System.out.println("User Type  "+user.getUsertype());
				JFrame hf = new showHome();
				this.dispose();
				hf.setVisible(true);
				}
			else{
				JOptionPane.showMessageDialog(null, "Wrong Password");
			}
		}// end of if
		if (ae.getSource()==button2){
			textfield1.setText("");
			textfield2.setText("");
		}
	}
}
