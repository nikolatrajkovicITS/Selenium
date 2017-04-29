package Cases;

import java.io.IOException;
import java.net.MalformedURLException;

import Controllers.LoginController;
import Controllers.PoolsController;
import xyz.autoqa.core.AutoqaDriver;
import xyz.autoqa.core.Browser;
import xyz.autoqa.core.Config;
import xyz.autoqa.core.TestCase;

public class CreateNewPoolTestCase extends TestCase{

	public void run() throws MalformedURLException, IOException, InterruptedException {
		
		AutoqaDriver qaDriver = new AutoqaDriver(Browser.CHROME);
		LoginController loginController = new LoginController();
		PoolsController poolsController = new PoolsController();
		Config config = new Config();
		
		setTestCaseID(4);
		setTestCaseTitle("Create new pool");
		setTestCaseDescription("Creating new pool with random credentials");
		setTestCaseCreator("Nikola Trajkovic");
		
		qaDriver.maximizeBrowser().deleteAllCookies().focus();
		
		qaDriver.openURL(config.getURL());
		
		loginController.login(config.getUsername(), config.getPassword(), qaDriver);
		
		poolsController.showPools(qaDriver);
		
		poolsController.createNewPool(qaDriver);
		Thread.sleep(3000);

		setTestCaseStatus(true);
		
		qaDriver.close();
		
		qaDriver.quit();
		
		printCase();
		
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		new CreateNewPoolTestCase().run();
	}
	
}
