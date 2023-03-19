package project;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import factories.DBConnectorFactory;
	/*********CONNECT THIS CLASS TO A DATABASE AND MATCH INPUT WITH STORED VALUE*********/

public class LoginPage extends JFrame implements ActionListener{

	private ResultSet rs;
	private Connection connection = null;
	private Statement stmt; 
	
	
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField username = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
 
 
    public LoginPage() {
    	connection = DBConnectorFactory.getDatbaseConnection();		//get connection from database
    	
    	
    	
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        username.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
 
 
    }
 
    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(username);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }
 
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
 
 
    @SuppressWarnings("unlikely-arg-type")
	@Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == loginButton) {
			try {
				
		        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/dbproject", "root", "usbw");	
		        String sql = "Select * from account where userName=? and password= ?";
		        
		        PreparedStatement pst = connection.prepareStatement(sql);
		        //accepting from user
		        pst.setString(1, username.getText());
		        pst.setString(2, passwordField.getText());
		        
		        ResultSet rs = pst.executeQuery();
		        
		        if(rs.next()) {
		        	JOptionPane.showMessageDialog(null, "Username and Password Matched");
		        	MainMenu menu = new MainMenu();		//opens a main menu once the information is valid
		        	menu.setVisible(true);
		        	setVisible(false);
		        }else {
		        	JOptionPane.showMessageDialog(null, "Username and Password DO NOT Match");
		        	username.setText("");
		        	passwordField.setText("");
		        }
		        
		        connection.close();
		        
		    	} catch (Exception exception) {
		    		exception.printStackTrace();
            } 
    	}
           
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            username.setText("");
            passwordField.setText("");
        }
        
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
        
    } //this close the entire action performed
 


	
	public static void main(String args[]) {
		
		LoginPage frame = new LoginPage();
		frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
		
		
	}     

}

