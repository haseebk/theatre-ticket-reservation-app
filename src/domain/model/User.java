package domain.model;

public class User {
	/**
	 * Type of User
	 */
	String userType;
	
	/**
	 * Constructor to set the type of user
	 * @param t the user type
	 */
	User(String t){
		this.userType = t;
	}
	
	// Getters and Setters
	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
}
