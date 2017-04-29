package Controllers;

import View.PoolsPage;
import xyz.autoqa.core.AutoqaDriver;

public class PoolsController implements PoolsPage{

	public boolean showPools(AutoqaDriver driver){
		
		driver.click(show_pools);
		
		return true;
	}
	
	public boolean createNewPool(AutoqaDriver driver){
		
		driver.click(new_pool_button);
		
		driver.type(new_pool_name_field, driver.generateHash()).type(new_pool_description_field, driver.generateHash());;
		
		driver.click(save_new_pool);
		
		return true;
	}
	
	public boolean showPoolQuestions(AutoqaDriver driver){
		
		driver.click(pool_questions_button);
		
		return true;
	}
	
	public boolean createNewTFQuestion(AutoqaDriver driver){
		
		driver.click(add_new_question_button);
		
		driver.click(add_essay_question); // OVDE SU DVE STAVKE OSTALE DA SE
											// URADE

		// driver.click(true_or_false_question_button);
		// driver.type(text_field, driver.generateHash()).type(text_field, driver.generateHash());
		
		driver.click(add_to_pool_button);
		return true;
	}
	


}
