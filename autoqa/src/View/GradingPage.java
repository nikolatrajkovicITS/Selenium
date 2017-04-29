package View;

import org.openqa.selenium.By;

public interface GradingPage {

	public final By grading_button = By.id("grading");
	
	public final By add_grade_button = By.id("gradeForm:addLabel");

	public final By incrase_percentage_button = By.id("gradeForm:gradeLabels:1:from']/a[2]/span/span");

	public final By reduce_percentage_button = By.id("gradeForm:gradeLabels:4:from']/a[2]/span/span");

	public final By save_grading_button = By.id("gradeForm:gradeUpdateBtn");

	public final By confirm_save_button = By.id("confirmDialog:yesBtn");

}
