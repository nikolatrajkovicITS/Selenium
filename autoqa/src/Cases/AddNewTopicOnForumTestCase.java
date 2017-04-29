package Cases;

import java.io.IOException;
import java.net.MalformedURLException;

import Controllers.LoginController;
import Controllers.SubjectsController;
import xyz.autoqa.core.AutoqaDriver;
import xyz.autoqa.core.Browser;
import xyz.autoqa.core.Config;
import xyz.autoqa.core.TestCase;

public class AddNewTopicOnForumTestCase extends TestCase {

	public void run() throws MalformedURLException, IOException, InterruptedException {

		AutoqaDriver qaDriver = new AutoqaDriver(Browser.CHROME);
		LoginController loginController = new LoginController();
		SubjectsController subjectsController = new SubjectsController();
		Config config = new Config();

		setTestCaseID(14);
		setTestCaseTitle("Add new Topic on forum");
		setTestCaseCreator("Nikola Trajkovic");

		qaDriver.maximizeBrowser().deleteAllCookies().focus();

		qaDriver.openURL(config.getURL());

		loginController.login(config.getUsername(), config.getPassword(), qaDriver);

		subjectsController.openSubjects(qaDriver);

		subjectsController.openCourseKominikacije(qaDriver);

		subjectsController.addNewTopic(qaDriver);

		setTestCaseStatus(true);

		qaDriver.close();

		qaDriver.quit();

		printCase();

	}

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		new AddNewTopicOnForumTestCase().run();

	}

}
