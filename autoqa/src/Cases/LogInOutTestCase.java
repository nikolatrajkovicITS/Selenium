package Cases;

import java.io.IOException;
import java.net.MalformedURLException;

import Controllers.LoginController;
import xyz.autoqa.core.AutoqaDriver;
import xyz.autoqa.core.Browser;
import xyz.autoqa.core.Config;
import xyz.autoqa.core.TestCase;

public class LogInOutTestCase extends TestCase{
	
	public void run() throws MalformedURLException, IOException{
		
		AutoqaDriver qaDriver = new AutoqaDriver(Browser.CHROME);
		LoginController loginController = new LoginController();
		Config config = new Config();
		
		setTestCaseID(1);
		setTestCaseTitle("Log in and out");
		setTestCaseDescription("Testing Application login and out system.");
		
		qaDriver.maximizeBrowser().deleteAllCookies().focus();
		
		qaDriver.openURL(config.getURL());
		
		loginController.login(config.getUsername(), config.getPassword(), qaDriver);
		
		loginController.logout(qaDriver);
		
		qaDriver.close();
		
		qaDriver.quit();
		
		setTestCaseStatus(true);
		
		printCase();
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		new LogInOutTestCase().run();
	}
	
}
