package webapp;

import java.net.PasswordAuthentication;

/**
 * first-web-application
 * @author Winnie Sep 23, 2016
 * UserValidationService.java
 */
public class UserValidationService {

	//hard-coded simple validation service
	public boolean isUserValid(String user, String password){
		if(user.equals("Winnie") && password.equals("123")){
			return true;
		}
		return false;
	}
}
