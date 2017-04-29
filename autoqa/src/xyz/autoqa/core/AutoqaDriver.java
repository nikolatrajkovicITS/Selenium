package xyz.autoqa.core;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import xyz.autoqa.function.Environment;
import xyz.autoqa.function.KeyBoard;
import xyz.autoqa.function.Mouse;

/**
 * @author Nikola Trajkovic
 *
 */
public class AutoqaDriver implements Closeable, Environment, Mouse, KeyBoard {
 private WebDriver webDriver;
 private JavascriptExecutor JSE;
 private int brokenLinks = 0;

 	/**
	 * <b>Auto.me</b> <br>
	 * Constructor that creates {@link WebDriver} from browser type.<br>
	 * 
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i> <br>
	 *        <b>Supported browsers:</b> <br>
	 *        1. Firefox<br>
	 *        2. Google Chrome<br>
	 *        3. Opera<br>
	 * 
	 */
 public AutoqaDriver(Browser browser) {
  switch (browser) {
   case FIREFOX:
    System.setProperty("webdriver.firefox.marionette", "Driver/ffdriver.exe");
    webDriver = new FirefoxDriver();
    break;

   case CHROME:
    System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
    webDriver = new ChromeDriver();
    break;

   case OPERA:
    System.setProperty("webdriver.opera.driver", "Driver/operadriver.exe");
    webDriver = new OperaDriver();
    break;

   default:
    System.err.println("JSL INFO: BROWSER \"" + browser + "\" IS NOT SUPPORTED.");
    System.exit(0);
    break;
  }
  JSE = (JavascriptExecutor) webDriver;
  webDriver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
  webDriver.manage().timeouts().setScriptTimeout(45, TimeUnit.SECONDS);
  System.err.println("\nJSL INFO: DRIVER FOR BROWSER " + browser + " IS SUCCESSFULLY CONFIGURED.");
  System.err.println("JSL INFO: Selenium begin test at: " + this.getCurrentTime());
 }

 // BROWSER
 // ENVIRONMENT***********************************************************************

 	/**
	 * Set browser window size to custom dimension.
	 * 
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i>
	 * @return WebDriverExtended
	 */
 public Environment customBrowserSize(int WIDTH, int HEIGHT) {
  Dimension dimension = new Dimension(WIDTH, HEIGHT);
  webDriver.manage().window().setSize(dimension);
  System.err.println("JSL INFO: Browser window size set to: " + WIDTH + "x" + HEIGHT);
  return this;
 }

 	/**
	 * Maximize browser screen to fit current resolution.
	 * 
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i>
	 * @return WebDriverExtended
	 */
 public Environment maximizeBrowser() {
  webDriver.manage().window().maximize();
  System.err.println("JSL INFO: Maximizing browser window. " + getCurrentTime());
  return this;
 }

 	/**
	 * Enter browser in full screen mode. (F11)
	 * 
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i>
	 * @return WebDriverExtended
	 */
 public Environment fullScreenBrowser() {
  webDriver.findElement(By.xpath("/html/body")).sendKeys(Keys.F11);
  System.err.println("JSL INFO: Entering full screen. " + getCurrentTime());
  return this;
 }

 	/**
	 * Focusing main screen.
	 * 
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i>
	 * @return WebDriverExtended
	 */
 public Environment focus() {
  webDriver.switchTo().defaultContent();
  System.err.println("JSL INFO: Focusing main screen. " + getCurrentTime());
  return this;
 }

 // BROWSER
 // NAVIGATION*******************************************************************

 	/**
	 * Refreshing current web page.
	 * 
	 * @author Nikola Trajkovic
	 * @return
	 * @since <i>Version 1.0</i>
	 */
 public Environment refresh() {
  System.err.println("JSL INFO: Refreshing page...");
  webDriver.navigate().refresh();
  System.err.println("JSL STATUS: Done.");
  return this;
 }

 	/**
	 * Navigate to previous web page using browser back button.
	 * 
	 * @author Nikola Trajkovic
	 * @return
	 * @since <i>Version 1.0</i>
	 */
 public Environment back() {
  webDriver.navigate().back();
  return this;
 }

 	/**
	 * Navigate to forward web page using browser forward button.
	 * 
	 * @author Nikola Trajkovic
	 * @return
	 * @since <i>Version 1.0</i>
	 */
 public Environment forward() {
  webDriver.navigate().forward();
  return this;
 }

 	/**
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i>
	 * @param url
	 * @return WebDriverExtended
	 * @throws IOException
	 * @throws MalformedURLException
	 */
 public boolean openURL(String url) throws MalformedURLException, IOException {
  if (isLinkBroken(new URL(url)).equals("OK")) {
   System.err.println("JSL INFO: Oppenning page: " + url + " " + this.getCurrentTime());
   webDriver.get(url);
   return true;
  } else {
   System.err.println("JSL ERROR: Page does not responce");
   return false;
  }
 }

 // TERMINATING ***********************************************************

 	/**
	 * Closing web browser.
	 * 
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i>
	 */
 public void close() {
  if (webDriver != null) {
   webDriver.close();
   JSE = null;
   quit();
  }
 }

 	/**
	 * Closing web browser and terminating Web Driver.
	 * 
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i>
	 */
 public void quit() {
  webDriver.quit();
  if (isDriverDead()) {
   System.err.println("JSL INFO: Driver successfully quit");
  }
 }

 public boolean isDriverDead() {
  return webDriver.toString().contains("(null)");
 }

 // Cookies Controller
 // **************************************************************

 	/**
	 * Deleting all cookies from browser.
	 * 
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i>
	 * @return WebDriverExtended
	 */
 public Environment deleteAllCookies() {
  webDriver.manage().deleteAllCookies();
  System.err.println("JSL INFO: All cookies deleted. " + getCurrentTime());
  return this;
 }

 // HTML GETTERS
 // *******************************************************************

 	/**
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i>
	 * @return Title from current web page.
	 */
 public String getTitle() {
  return webDriver.getTitle();
 }

 	/**
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i>
	 * @return URL from active web page.
	 */
 public String getActiveURL() {
  return webDriver.getCurrentUrl();
 }


 public String getPageSource() {
  return webDriver.getPageSource();
 }

 	/**
	 * Searching for text inside the HTML page source.
	 * 
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i>
	 * @param
	 * @return Text found status (True or False)
	 */
 public boolean isTextPresent(String text) {
  return webDriver.getPageSource().contains(text);
 }


 	/**
	 * Useful for checking, check boxes and radio buttons.
	 * 
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i>
	 * @param element
	 * @return boolean value if element is selected.
	 */
 public boolean isElementSelected(By element) {
  return webDriver.findElement(element).isSelected();
 }

 // MOUSE ACTIONS
 // *********************************************************************

 public Mouse click(By element) {
  clickableElement(element).click();
  return this;
 }

 public Mouse doubleClick(By element) {
  clickableElement(element).click();
  clickableElement(element).click();
  return this;
 }

 public Mouse hover(By element) {
  new Actions(webDriver).moveToElement(clickableElement(element)).perform();
  return this;
 }

 public Mouse scrollDown(int pixels) {
  JSE.executeScript("scroll(0," + pixels + ");");
  return this;
 }

 public Mouse scrollUp(int pixels) {
  JSE.executeScript("scroll(0, " + (-pixels) + ");");
  return this;
 }

 public Mouse scrollLeft(int pixels) {
  JSE.executeScript("scroll(" + (-pixels) + ", 0);");
  return this;
 }

 public Mouse scrollRight(int pixels) {
  JSE.executeScript("scroll(" + pixels + ", 0);");
  return this;
 }

 public Mouse scrollIntoView(By element) {
  JSE.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(element));
  return this;
 }

	public WebElement clickableElement(By element) {
  return new WebDriverWait(webDriver, 20).until(ExpectedConditions.elementToBeClickable(element));
 }

 @SuppressWarnings("unused")
	public WebElement visibleElement(By element) {
  return new WebDriverWait(webDriver, 20).until(ExpectedConditions.presenceOfElementLocated(element));
 }

 public KeyBoard type(By element, String value) {
  clickableElement(element).click();
  clickableElement(element).clear();
  clickableElement(element).sendKeys(value);
  return this;
 }

 // TIME CONTROL
 // *************************************************************************

 /** Return current local time. */
 private String getCurrentTime() {
  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  Date date = new Date();
  return dateFormat.format(date);
 }

 	/**
	 * Checking all 'a' and 'img' links on current webPage. Working links will
	 * result 'OK' and the failed links result exception.
	 * 
	 * @author Nikola Trajkovic
	 * @since<i>Version 1.0</i>
	 * @throws MalformedURLException
	 * @throws IOException
	 */
 public Environment checkPageLinks() throws MalformedURLException, IOException {
  List < WebElement > links = new ArrayList < > ();
  links.addAll(webDriver.findElements(By.tagName("a")));
  links.addAll(webDriver.findElements(By.tagName("img")));
  System.err.println("JSL INFO: Found " + links.size() + " links on page " + webDriver.getCurrentUrl());
  links.parallelStream().filter(e -> e.getAttribute("href") != null).forEach(e -> {
   try {
    System.out.println("URL: " + e.getAttribute("href") + " status: " + isLinkBroken(new URL(e.getAttribute("href"))));
   } catch (Exception ex) {
    System.out.println("URL: " + e.getAttribute("href") + " status: " + ex.getMessage());
    brokenLinks++;
   }
  });
  System.err.println("JSL INFO: Found " + brokenLinks + " broken links on page.");
  return this;
 }

 private String isLinkBroken(URL url) throws IOException {
  HttpURLConnection connection = (HttpURLConnection) url.openConnection();
  try {
   connection.connect();
   return connection.getResponseMessage();
  } catch (Exception ex) {
   return ex.getMessage();
  } finally {
   connection.disconnect();
  }
 }

 	/**
	 * Saving screenshot under the project folder screenshot.<br>
	 * Extensions available: PNG, JPG, JPEG, GIF
	 * 
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i>
	 * @param fileName
	 * @param ext
	 * @throws IOException
	 */
 public void takeScreenshot(String path, String fileName, FileExtension ext) throws IOException {
  StringBuilder sb = new StringBuilder(4);
  File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
  sb.append(path).append(fileName).append(".").append(ext.toString().toLowerCase());
  FileUtils.copyFile(scrFile, new File(sb.toString()));
 }

 	/**
	 * Generating random hash code
	 * 
	 * @author Nikola Trajkovic
	 * @since <i>Version 1.0</i>
	 * 
	 */
 public String generateHash() {
  return Long.toHexString(Double.doubleToLongBits(Math.random()));
 }

	/**
	 * Generating random string whit Uppercase letters
	 * @author Nikola Trajkovic
	 * 
	 */
	public String generateUppercaseString() {
		int length = 8;
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		String str = new Random().ints(length, 0, chars.length()).mapToObj(i -> "" + chars.charAt(i))
				.collect(Collectors.joining());
		return str;
	}
}