package Controllers;

import View.LoginPage;
import xyz.autoqa.core.AutoqaDriver;

public class LoginController implements LoginPage{

	
	public boolean login(String username, String password, AutoqaDriver driver){
		
		driver.type(username_field, username).type(password_field, password);
		
		driver.click(signIn_button);
		
		return true;
	}
	
	public boolean logout(AutoqaDriver driver){
		
		driver.click(show_logout_button).click(logout_button);
		
		return true;
	}
	
}
