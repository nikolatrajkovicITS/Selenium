package View;

import org.openqa.selenium.By;

public interface LoginPage {

	public final By username_field = By.id("loginForm:username");
	public final By password_field = By.id("loginForm:password");
	public final By signIn_button = By.id("loginForm:signInBtn");
	
	public final By show_logout_button = By.id("j_idt20:j_idt30");
	public final By logout_button = By.id("j_idt20:j_idt25");
	
}
