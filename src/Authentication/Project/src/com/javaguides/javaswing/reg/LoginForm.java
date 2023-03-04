package com.javaguides.javaswing.reg;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginForm extends JFrame{
	 //part2
	
	JPanel panel;
	JFrame jf;
	JLabel label1,label2;
	JButton login;
	JTextField textfield1,textfield2,textfield3;
	JPasswordField passwordfield;
	
	public LoginForm() {
		initComponents();
		handlingEvents();
	}
	
	public void initComponents() {
		jf=new javax.swing.JFrame();
		jf.setTitle("Login");
		jf.setLayout(null);
		jf.setSize(800,500);
		jf.show();
		jf.setVisible(true);
		
		JScrollPane scrollBar=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jf.add(scrollBar);
		
		label1=new JLabel("User Login");
		label1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
		label1.setBounds(400,20,500,40);
		jf.add(label1);
		
		label1=new JLabel("Username");
		label1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
		label1.setBounds(200,80,150,40);
		jf.add(label1);
		
		textfield1=new JTextField();
		textfield1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
		textfield1.setBounds(400,80,150,30);
		jf.add(textfield1);
		
		label1=new JLabel("Password");
		label1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
		label1.setBounds(200,200,100,40);
		jf.add(label1);
		
		passwordfield=new JPasswordField();
		passwordfield.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
		passwordfield.setBounds(400,200,150,30);
		jf.add(passwordfield);
		
		login=new JButton("Login");
		login.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
		login.setBounds(250,280,100,30);
		jf.add(login);
		
		}
	 
	public void handlingEvents() {
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			String un = textfield1.getText();
			String ui = passwordfield.getText();
			boolean valid = false;
			String username="";
			String uid="";
			
			if(un.equals("admin") && ui.equals("123")) {
				JOptionPane.showMessageDialog(null, "Login Successfully");
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Username or id");
			}
			
		/*	
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");    
				Connection c = DriverManager.getConnection("url", "root", "usbw");
				Statement st = c.createStatement();
				st.execute("SELECT userName, password FROM account WHERE userName='"+un+"' AND password='"+ui+"'");
				ResultSet rs = st.getResultSet();
				while(rs.next())
					{
						if(rs != null) {
							valid = true;
							username = rs.getString(1);
							uid = rs.getString(2);
						}
						else
						valid = false;
					}
				if(valid == true) {
					JOptionPane.showMessageDialog(null,"Authenticated User");
					textfield1.setText("");
					passwordfield.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null,"Not Authenticated User");
				}
				c.close();
				st.close();
			
			}
			catch (Exception e) {
				e.printStackTrace();
				//System.out.println(e);
			}
			*/
			
			
			}
		});
	}
	
	public static void main(String args[]) {
		LoginForm log = new LoginForm();
	}     
	
	
	
	
	
}
