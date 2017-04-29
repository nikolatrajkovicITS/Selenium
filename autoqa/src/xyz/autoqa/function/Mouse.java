package xyz.autoqa.function;

import org.openqa.selenium.By;

/**
 * @author Nikola Trajkovic
 *
 */
public interface Mouse {

	Mouse click(By element);

    Mouse hover(By element);
    
    Mouse doubleClick(By element);
    
    Mouse scrollIntoView(By element);
    
    //@TODO scroll down, up, left, right
    
}
