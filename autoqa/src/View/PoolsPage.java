package View;

import org.openqa.selenium.By;

public interface PoolsPage {

	public final By show_pools = By.id("pools");
	
	public final By new_pool_button = By.id("titleForm:newPoolBtn");
	
	public final By new_pool_name_field = By.id("newPoolForm:newPoolName");
	
	public final By new_pool_description_field = By.id("newPoolForm:newPoolD");
	
	public final By save_new_pool = By.id("newPoolForm:saveNewPoolBtn");
	
	public final By pool_questions_button = By.id("butForm:questionsBtn");
	
	public final By add_new_question_button = By.id("questionForm:questionsSummary:addQuestionBtn_button");
	
	public final By true_or_false_question_button = By.id("questionForm:questionsSummary:j_idt345");
	
	public final By check_first_true = By.id("questionForm:singleAndMultipleChoiceQuestion:answersList:0:checkCorrectAnswer");
	
	public final By save_to_pool_button = By.id("questionForm:questionEditorId_saveToQuizBtn");
	
	public final By add_single_choice_question = By.id("questionForm:questionsSummary:addQuestionBtn_menu']/ul/li/a/span");

	public final By click_on_question_text_field = By.id("questionForm:qTextEditorField_input");

	public final By add_answer = By.id("questionForm:singleAndMultipleChoiceQuestion:questionEditorId_addAnswerBtn");

	public final By add_essay_question = By
			.id("//div[@id='questionForm:questionsSummary:addQuestionBtn_menu']/ul/li[3]/a/span");

	public final By add_to_pool_button = By.id("questionForm:questionEditorId_saveToQuizBtn");

	public final By select_move_question_destination = By.id("questionForm:questionsSummary:j_idt353_items");

	public final By confirm_select_destination = By.id("questionForm:questionsSummary:confirmDest");
}

