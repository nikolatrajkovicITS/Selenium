package Cases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeoutException;

import Controllers.LoginController;
import Controllers.SubjectsController;
import xyz.autoqa.core.AutoqaDriver;
import xyz.autoqa.core.Browser;
import xyz.autoqa.core.Config;
import xyz.autoqa.core.TestCase;


public class CreateNewLessonsTestCase extends TestCase {

	public void run() throws MalformedURLException, IOException, InterruptedException {

		AutoqaDriver qaDriver = new AutoqaDriver(Browser.CHROME);
		LoginController loginController = new LoginController();
		SubjectsController subjectsController = new SubjectsController();
		Config config = new Config();

		setTestCaseID(42);
		setTestCaseTitle("Create New Lesson TestCase");
		setTestCaseDescription("Creating new lesson with random credentials");
		setTestCaseCreator("Nikola Trajkovic");

		qaDriver.maximizeBrowser().deleteAllCookies().focus();

		qaDriver.openURL(config.getURL());

		loginController.login(config.getUsername(), config.getPassword(), qaDriver);

		subjectsController.openSubjects(qaDriver);

		subjectsController.openCourseInstrumenti(qaDriver);

		subjectsController.createNewLesson(qaDriver);

		setTestCaseStatus(true);

		qaDriver.close();

		qaDriver.quit();

		printCase();

	}

	public static void main(String[] args)
			throws MalformedURLException, IOException, InterruptedException, TimeoutException {
		new CreateNewLessonsTestCase().run();
	}
}
