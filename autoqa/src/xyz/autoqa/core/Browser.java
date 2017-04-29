package xyz.autoqa.core;

import org.openqa.selenium.remote.server.SeleniumServer;

/**
 * <br>
 * Enum class {@link Browser} hold all types of browsers supported by
 * {@link SeleniumServer}. <br>
 * <h5>List of supported browsers:</h5>
 * 
 * <pre>
 * 1. Chrome.
 * 2. Firefox.
 * 3. Opera.
 * 4. InternetExplorer.
 * 5. Edge.
 * 6. Safari.
 * 7. Headless.
 * </pre>
 * 
 * @author Nikola Trajkovic
 * @version 1.00
 * @since 14.10.2016.
 */
public enum Browser {
	CHROME, FIREFOX, OPERA, IE, EDGE, SAFARI, HEADLESS
}
