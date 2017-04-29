package Controllers;

import java.io.IOException;
import java.net.MalformedURLException;

import View.ProfilesPage;
import xyz.autoqa.core.AutoqaDriver;

public class ProfilesController implements ProfilesPage{
	
	public boolean openProfiles(AutoqaDriver driver){
		
		driver.click(profiles_menu);
		
		return true;
	}

	public boolean createNewUser(AutoqaDriver driver) throws MalformedURLException, IOException{
		
		driver.click(create_new_user_button);
		
		driver.type(new_user_username, driver.generateHash());
		
		driver.type(new_user_email, driver.generateHash() + "@youtestme.com");
		
		driver.type(new_user_first_name, "AutoQA Bot");
		
		driver.type(new_user_last_name, "AutoQA Bot");
		
		driver.type(new_user_address, "AutoQA Bot");
		
		driver.scrollIntoView(save_new_user_button);
		
		driver.click(save_new_user_button);

		return true;
	}	
	
	public boolean showRoles(AutoqaDriver driver){
		
		driver.click(show_roles);
		
		return true;
	}
	
	public boolean addNewRole(AutoqaDriver driver){
		
		driver.click(new_roles);
		
		driver.type(new_roles_name_field, driver.generateHash());
		
		driver.type(new_roles_description_field, driver.generateHash() + driver.getActiveURL());
		
		driver.type(new_roles_code_field, driver.generateUppercaseString());
		
		driver.scrollIntoView(action_button);
		
		driver.click(action_button).click(create_new_role);
		
		return true;
	}
	
}
