package xyz.autoqa.core;

public class Config {
	
	private String URL = "https://nikola.youtestme.com/login.xhtml";

	private final String username 		= "admin";
	
	private final String password 		= "Admin12#";
	
	private final String dbConnection 	= "";
	
	private final String dbUsername 	= "";
	
	private final String dbPassword 	= "";
	
	

	public String getURL() {
		return URL;
	}
	
	public String setURL(String URL){
		return this.URL = URL;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getDbConnection() {
		return dbConnection;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}
	
	
	
}
