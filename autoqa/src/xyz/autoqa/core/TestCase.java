package xyz.autoqa.core;

public class TestCase {

	private int testCaseID = 0;
	
	private String testCaseTitle = "";
	
	private String testCaseDescription = "";
	
	private boolean testCaseStatus = false;
	
	private String testCaseCreator = "";
	
	
	public int getTestCaseID() {
		return testCaseID;
	}


	public void setTestCaseID(int testCaseID) {
		this.testCaseID = testCaseID;
	}


	public String getTestCaseTitle() {
		return testCaseTitle;
	}


	public void setTestCaseTitle(String testCaseTitle) {
		this.testCaseTitle = testCaseTitle;
	}


	public String getTestCaseDescription() {
		return testCaseDescription;
	}


	public void setTestCaseDescription(String testCaseDescription) {
		this.testCaseDescription = testCaseDescription;
	}


	public boolean isTestCaseStatus() {
		return testCaseStatus;
	}


	public void setTestCaseStatus(boolean testCaseStatus) {
		this.testCaseStatus = testCaseStatus;
	}

	public String getTestCaseCreator() {
		return testCaseCreator;
	}


	public void setTestCaseCreator(String testCaseCreator) {
		this.testCaseCreator = testCaseCreator;
	}


	public void printCase(){
		
		System.err.println("Case ID: " + testCaseID);
		System.err.println("Case TITLE: " + testCaseTitle);
		System.err.println("Case DESCRIPTION: " + testCaseDescription);
		System.err.println("Case STATUS: " + testCaseStatus);
		System.err.println("Case CREATOR: " + testCaseCreator);
		
	}
	
}
