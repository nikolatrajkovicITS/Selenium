package Controllers;

import View.SubjectsPage;
import xyz.autoqa.core.AutoqaDriver;

public class SubjectsController implements SubjectsPage{

	
	public boolean openSubjects(AutoqaDriver driver) {
		driver.click(show_subjects);
		return true;
	}
	
	public boolean createNewSubject(AutoqaDriver driver){
		
		driver.click(new_subject_button);
		
		driver.type(new_subject_name, driver.generateHash());
		
		driver.type(new_subject_description, driver.generateHash() + driver.generateHash());
		
		driver.click(new_subject_status_active);
		
		driver.click(save_new_subject_button);
		
		return true;
		
	}
	
	public boolean openCourseKominikacije(AutoqaDriver driver) {
		driver.click(subject_course_komunikacije);
		return true;
	}

	public boolean openCloneSubject(AutoqaDriver driver) {
		driver.click(subject_course_cloneSubject);
		return true;
	}
	
	public boolean clickYes(AutoqaDriver driver) {
		driver.click(subject_course_cloneSubject_yes_button);
		return true;
	}

	public boolean deleteSubject(AutoqaDriver driver) {
		driver.click(subject_course_delete);
		return true;
	}

	public boolean confirmDeleteButton(AutoqaDriver driver) {
		driver.click(subject_confirm_delete_yes);
		return true;
	}

	public boolean addNewTopic(AutoqaDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		driver.click(forum_button);

		Thread.sleep(2000);
		driver.click(new_topic_button);

		Thread.sleep(1000);
		driver.type(focus_text_area, driver.generateHash()).type(focus_text_area, driver.generateHash());

		Thread.sleep(1000);
		driver.click(save_text_form_button);

		return true;

	}

	public boolean createNewLesson(AutoqaDriver driver) throws InterruptedException {
		Thread.sleep(1000);

		driver.visibleElement(Lesson_tab_button);
		Thread.sleep(1000);

		driver.click(Lesson_tab_button);
		Thread.sleep(1000);

		driver.click(add_lesson_button);
		Thread.sleep(1000);

		driver.type(lesson_name_field, driver.generateHash()).type(lesson_name_field, driver.generateHash());
		Thread.sleep(1000);

		driver.click(save_lesson_button);
		Thread.sleep(2000);

		return true;

	}

	public boolean openCourseInstrumenti(AutoqaDriver driver) {
		driver.click(open_instrumenti_course);
		return true;
	}

	public boolean openCourseLjudskeMogucnostiCourse(AutoqaDriver driver) {
		driver.click(ljudske_mogucnosti_course);
		return true;
	}

	public boolean createNewProgressTest(AutoqaDriver driver) throws InterruptedException {
		Thread.sleep(1000);

		driver.visibleElement(new_progres_test_button);
		Thread.sleep(1000);

		driver.click(new_progres_test_button);
		Thread.sleep(3000);

		driver.visibleElement(name_test_field);
		Thread.sleep(1000);

		driver.type(name_test_field, driver.generateHash()).type(name_test_field, driver.generateHash());
		Thread.sleep(1000);

		driver.click(next_button);
		Thread.sleep(2000);

		driver.click(add_pool_resourse);
		Thread.sleep(2000);

		driver.click(save_lesson_button);
		Thread.sleep(2000);

		driver.click(drop_down_menu_for_pool_resource);
		Thread.sleep(1000);

		driver.click(drop_down_menu_select_pool_1);
		Thread.sleep(1000);

		driver.visibleElement(question_medium_number_button);
		Thread.sleep(1000);

		driver.click(question_medium_number_button);
		Thread.sleep(1000);

		driver.click(save_added_pool_resource);
		Thread.sleep(1000);

		driver.click(next_button);
		Thread.sleep(2000);

		driver.click(next_button);
		Thread.sleep(2000);

		driver.click(finish_wizard_button);
		Thread.sleep(2000);

		return true;

	}


}


