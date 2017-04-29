package Cases;

import java.io.IOException;
import java.net.MalformedURLException;

import Controllers.LoginController;
import Controllers.ProfilesController;
import xyz.autoqa.core.AutoqaDriver;
import xyz.autoqa.core.Browser;
import xyz.autoqa.core.Config;
import xyz.autoqa.core.TestCase;

public class CreateNewUserTestCase extends TestCase {
	
	public void run() throws MalformedURLException, IOException{
		
		AutoqaDriver qaDriver = new AutoqaDriver(Browser.CHROME);
		LoginController loginController = new LoginController();
		ProfilesController profilesController = new ProfilesController();
		Config config = new Config();
		
		setTestCaseID(2);
		setTestCaseTitle("Create new user");
		setTestCaseDescription("Creating new user with random credentials");
		setTestCaseCreator("Nikola Trajkovic");
		
		qaDriver.maximizeBrowser().deleteAllCookies().focus();
		
		qaDriver.openURL(config.getURL());
		
		loginController.login(config.getUsername(), config.getPassword(), qaDriver);
		
		profilesController.openProfiles(qaDriver);
		
		profilesController.createNewUser(qaDriver);
		
		setTestCaseStatus(true);
		
		qaDriver.close();
		
		qaDriver.quit();
		
		printCase();
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		new CreateNewUserTestCase().run();
	}

}
