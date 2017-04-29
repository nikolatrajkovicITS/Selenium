package Cases;

import java.io.IOException;
import java.net.MalformedURLException;

import Controllers.LoginController;
import Controllers.SubjectsController;
import xyz.autoqa.core.AutoqaDriver;
import xyz.autoqa.core.Browser;
import xyz.autoqa.core.Config;
import xyz.autoqa.core.TestCase;

public class CloneAndDeleteSubjectTestCase extends TestCase {

	public void run() throws MalformedURLException, IOException, InterruptedException {

		AutoqaDriver qaDriver = new AutoqaDriver(Browser.CHROME);
		LoginController loginController = new LoginController();
		SubjectsController subjectsController = new SubjectsController();
		Config config = new Config();

		setTestCaseID(15);
		setTestCaseTitle("Clone and Delete subject ");
		setTestCaseDescription("Clone Komunikacije Subject");
		setTestCaseCreator("Nikola Trajkovic");

		qaDriver.maximizeBrowser().deleteAllCookies().focus();

		qaDriver.openURL(config.getURL());

		loginController.login(config.getUsername(), config.getPassword(), qaDriver);

		subjectsController.openSubjects(qaDriver);

		subjectsController.openCourseKominikacije(qaDriver);

		subjectsController.openCloneSubject(qaDriver);
		Thread.sleep(2000);

		subjectsController.clickYes(qaDriver);
		Thread.sleep(2000);

		subjectsController.deleteSubject(qaDriver);
		Thread.sleep(2000);

		subjectsController.confirmDeleteButton(qaDriver);
		Thread.sleep(3000);

		setTestCaseStatus(true);

		qaDriver.close();

		qaDriver.quit();

		printCase();
	}

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		new CloneAndDeleteSubjectTestCase().run();
	}

}
