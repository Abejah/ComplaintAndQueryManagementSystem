package com.javaguides.javaswing.reg;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;

/**
 * User Registration using Swing
 * @author javaguides.net
 *
 */
public class UserRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    
    //part2
//    private JFrame jf;
//    private JLabel label1, label2;
//    private JTextField textfield1,textfield2,textfield3;
//    private JPasswordField passwordfield;
//    private JButton login;

    
    public UserRegistration() {
//        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("New User Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 151, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(214, 235, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 320, 228, 50);
        contentPane.add(email);
        email.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(707, 151, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 329, 139, 26);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mob.setBounds(707, 320, 228, 50);
        contentPane.add(mob);
        mob.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(707, 235, 228, 50);
        contentPane.add(passwordField);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String emailId = email.getText();
                String userName = username.getText();
                String mobileNumber = mob.getText();
                int len = mobileNumber.length();
                String password = passwordField.getText();

                String msg = "" + firstName;
                msg += " \n";
                //NOTE: THE MOBILE NUMBER MUST BE LESS THAN 10 !!!!!!!
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/dbproject", "root", "usbw");

                    String insertSQL = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userName + "','" +
                        password + "','" + emailId + "','" + mobileNumber + "')";

                    Statement stmt = connection.createStatement();
                    int x = stmt.executeUpdate(insertSQL);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                } 
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);
        
        
        //part 2
        
//        initComponents();
//    	handlingEvents();
        
        
    } 
        
    
    	//part 2
  /*  
    public void initComponents() {
    	jf =new javax.swing.JFrame();
    	jf.setTitle("Login");
    	jf.setLayout(null);
    	jf.setSize(800,500);
    	jf.show();
    	jf.setVisible(true);

    	JScrollPane scrollBar=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    	JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    	jf.add(scrollBar);

    	label1=new javax.swing.JLabel("User Login");
    	label1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
    	label1.setBounds(400,20,500,40);
    	jf.add(label1);

    	label1=new javax.swing.JLabel("Username");
    	label1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
    	label1.setBounds(200,80,150,40);
    	jf.add(label1);

    	textfield1=new javax.swing.JTextField();
    	textfield1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
    	textfield1.setBounds(400,80,150,30);
    	jf.add(textfield1);

    	label1=new javax.swing.JLabel("Password");
    	label1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
    	label1.setBounds(200,200,100,40);
    	jf.add(label1);

    	passwordfield=new javax.swing.JPasswordField();
    	passwordfield.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
    	passwordfield.setBounds(400,200,150,30);
    	jf.add(passwordfield);

    	login=new javax.swing.JButton("Login");
    	login.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
    	login.setBounds(250,280,100,30);
    	jf.add(login);

    	}
    
    
        public void handlingEvents() {
        	btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        	String username = textfield1.getText();
        	String password = passwordField.getText();
        	boolean valid = false;
        	String id="";
        	String pWord="";
        	try {
        	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/dbproject", "root", "usbw");
        	Statement st = c.createStatement();
        	st.execute("SELECT userName, password FROM account WHERE userName='"+username+"' AND password='"+password+"'");
        	
        	ResultSet rs = st.getResultSet();
        	while(rs.next())
        	{
	        	if(rs != null) {
	        	valid = true;
	        	id = rs.getString(1);
	        	pWord = rs.getString(2);
        	}
        	
        	else
        	valid = false;
        	}
        	
        	if(valid == true)
        	{
	        	JOptionPane.showMessageDialog(null, "Authenticated User");
	        	textfield1.setText("");			
	        	passwordField.setText("");
        	}
	        	else {
	        	JOptionPane.showMessageDialog(null, "Not Authenticated User");
	        	}
	        	c.close();
	        	st.close();

        	}
        	catch (Exception e) {
        		System.out.println(e);
        	}
        }
      });
   }
        */
    
    
    
    
    /******Part 2*****COMPARE DATA SAVED IN DATABASE TO DATA REQUESTED ON LOGIN
	        // IF PASSWORD AND ID MATCH, DISPLAY ACCESS GRANTED********/
    
    //OR MAKE A DEFAULT LOGIN USER NAME AND PASSWORD ???
    private Connection Login(Connection c) {
		
    	
    	
    	return c;
    	
    }
        
}