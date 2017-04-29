package View;

import org.openqa.selenium.By;

public interface ProfilesPage {

	public final By profiles_menu = By.id("profiles");
	
	public final By create_new_user_button = By.id("butForm:newUserBtn");
	
	public final By new_user_username = By.id("newForm:username");
	
	public final By new_user_email = By.id("newForm:email");
	
	public final By new_user_first_name = By.id("newForm:firstName");
	
	public final By new_user_last_name = By.id("newForm:lastName");
	
	public final By new_user_address = By.id("newForm:area");
	
	public final By save_new_user_button = By.id("newForm:createBtn");
	
	public final By show_roles = By.id("butForm:showRolesBtn");
	
	public final By new_roles = By.id("rolesForm:newRoleBtn");
	
	public final By new_roles_name_field = By.id("rolesForm:roleName");
	
	public final By new_roles_description_field = By.id("rolesForm:description");
	
	public final By new_roles_code_field = By.id("rolesForm:roleCodeBtn");
	
	public final By action_button = By.id("rolesForm:gradeActionBtn_button");
	
	public final By create_new_role = By.id("rolesForm:roleSave");
	
}
