package Main;

import java.awt.EventQueue;

import javax.security.auth.callback.PasswordCallback;

import com.javaguides.javaswing.reg.UserRegistration;

	public class Driver {
	
		public static void main(String[] args) {
//			UserRegistration urg = new UserRegistration();
			
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    UserRegistration frame = new UserRegistration();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }); 
	        
	        
	        // COMPARE DATA SAVED IN DATABASE TO DATA REQUESTED ON LOGIN
	        // IF PASSWORD AND ID MATCH, DISPLAY ACCESS GRANTED
//			UserRegistration log = new UserRegistration();
	        
	    }

}
