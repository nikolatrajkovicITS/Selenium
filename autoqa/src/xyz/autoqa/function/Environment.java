package xyz.autoqa.function;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;

/**
 * @author Nikola Trajkovic
 *
 */
public interface Environment {
    
    Environment customBrowserSize(int WIDTH, int HEIGHT);
    
    Environment maximizeBrowser();
    
    Environment fullScreenBrowser();
    
    Environment focus();
    
    Environment deleteAllCookies();
    
    Environment refresh();
    
    Environment back();
    
    Environment forward();
    
    boolean openURL(String url) throws MalformedURLException, IOException;
    
    String getTitle();
    
    String getActiveURL();
    
    String getPageSource();
    
    boolean isElementSelected(By element);
    
    boolean isTextPresent(String text);
    
    Environment checkPageLinks() throws MalformedURLException, IOException;
    
	String generateUppercaseString();

}
