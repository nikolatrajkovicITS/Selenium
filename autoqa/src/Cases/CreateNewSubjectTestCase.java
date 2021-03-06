package Cases;

import java.io.IOException;
import java.net.MalformedURLException;

import Controllers.LoginController;
import Controllers.SubjectsController;
import xyz.autoqa.core.AutoqaDriver;
import xyz.autoqa.core.Browser;
import xyz.autoqa.core.Config;
import xyz.autoqa.core.TestCase;

public class CreateNewSubjectTestCase extends TestCase{

	public void run() throws MalformedURLException, IOException, InterruptedException {
		
		AutoqaDriver qaDriver = new AutoqaDriver(Browser.CHROME);
		LoginController loginController = new LoginController();
		SubjectsController subjectsController = new SubjectsController();
		Config config = new Config();
		
		setTestCaseID(3);
		setTestCaseTitle("Create new subject");
		setTestCaseDescription("Creating new subject with random credentials");
		setTestCaseCreator("Nikola Trajkovic");
		
		qaDriver.maximizeBrowser().deleteAllCookies().focus();
		
		qaDriver.openURL(config.getURL());
		
		loginController.login(config.getUsername(), config.getPassword(), qaDriver);
		
		subjectsController.openSubjects(qaDriver);
		
		// Treba da se namesti vidljivi ID ACTIVE checkbox-a
		subjectsController.createNewSubject(qaDriver);
		Thread.sleep(5000);
		setTestCaseStatus(true);
		
		qaDriver.close();
		
		qaDriver.quit();
		
		printCase();
		
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		new CreateNewSubjectTestCase().run();
	}
	
}
