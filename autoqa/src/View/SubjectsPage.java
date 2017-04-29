package View;

import org.openqa.selenium.By;

public interface SubjectsPage {

	public final By show_subjects = By.id("courses");
	
	public final By new_subject_button = By.id("titleForm:newSubCourseTab");
	
	public final By new_subject_name = By.id("newCourseForm:newCourseName");
	
	public final By new_subject_description = By.id("newCourseForm:newCourseDescription");
	
	// Treba da se namesti vidljivi ID ACTIVE checkbox-a

	public final By new_subject_status_active = By.id("newCourseForm:newCourseStatus");
	
	public final By save_new_subject_button = By.id("newCourseForm:saveNewCourse");
	

	// *** Buttons for Clone And Delete Test Case ***
	public final By subject_course_komunikacije = By.id("treeForm:tree:0_1");

	public final By subject_course_cloneSubject = By.id("titleForm:j_idt91");

	public final By subject_course_cloneSubject_yes_button = By.id("confirmDialog:yesBtn");

	public final By subject_course_delete = By.id("titleForm:deleteCourse");

	public final By subject_confirm_delete_yes = By.id("confirmDialog:yesBtn");

	// *** Buttons for Add New Topic Test Case ***
	public final By forum_button = By.id("butForm:viewForumTab");

	public final By new_topic_button = By.id("forumForm:addCommentBtn");

	public final By focus_text_area = By.id("forumForm:commentsInput");

	public final By save_text_form_button = By.id("forumForm:j_idt1149");

	// *** Buttons for Create New Lessons Test Case ***
	public final By open_instrumenti_course = By.id("treeForm:tree:0_0");

	public final By sub_course_komunikacije_u_instrumentalnim_uslovima = By
			.id("treeForm:tree:0_1_0']/span/span[3]/span");

	public final By Lesson_tab_button = By.id("butForm:viewCourseLessonsTab");

	public final By add_lesson_button = By.id("lessonsForm:addItemBtn");

	public final By lesson_name_field = By.id("newLessonItemForm:idemName");

	public final By save_lesson_button = By.id("newLessonItemForm:saveLessonItmBtn");

	public final By ljudske_mogucnosti_course = By.id("j_idt8");

	public final By test_tab_button = By.id("'butForm:viewCourseQuizzesTab']/span[2]");

	public final By new_progres_test_button = By.id("(//a[contains(text(),'New progress test')])[2]");

	public final By name_test_field = By.id("newQuizWizard:quizName");

	public final By next_button = By.id("newQuizWizard:quizWizardId_next");

	public final By add_pool_resourse = By.id("newQuizWizard:addPoolResourceBtn");

	public final By drop_down_menu_for_pool_resource = By.id("'newQuizWizard:poolResourcesPool']/div[3]/span");

	public final By drop_down_menu_select_pool_1 = By.id("newQuizWizard:poolResourcesPool_1");
	
	public final By question_medium_number_button = By.id("ui-icon ui-icon-triangle-1-n ui-c");
	// ui-icon ui-icon-triangle-1-n ui-c
	// ui-button-text

	public final By save_added_pool_resource = By.id("newQuizWizard:savePoolResourceBtn");

	public final By finish_wizard_button = By.id("newQuizWizard:finishWizardBtnGenerated");
}
