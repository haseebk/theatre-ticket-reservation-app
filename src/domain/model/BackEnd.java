package domain.model;

import database.DataController;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

public class BackEnd implements Serializable{
	private static final long serialVersionUID = 1L;

	private DataController dataController;

	private RegisteredUser currentUser;

	public BackEnd() {
		dataController = DataController.getOnlyInstance();
	}

	//Sets the current user to a Guest User
	public void guestUser(){
		currentUser = null;
	}

	//Verifies the login credentials of the current user
	//If the login is successful will set the current user to the registered user and will return the User's ID;
	//If the login failed return -1;
	public RegisteredUser verifyLogin(String username, String password){
		System.out.println("verify login" + dataController.getUserList().size());
		for(int i = 0; i < dataController.getUserList().size(); i++){
			System.out.println("The system's info: " + dataController.getUserList().get(i).username + " " + dataController.getUserList().get(i).password);
			if(dataController.getUserList().get(i).username.compareTo(username) == 0 && dataController.getUserList().get(i).password.compareTo(password) == 0){
				currentUser = dataController.getUserList().get(i);
				return dataController.getUserList().get(i);
			}
		}
		return null;
	}

	//Clears the current user
	public void userLogout(){
		currentUser = null;
	}
	
	public void registerUser(String username, String password, String f_name, String l_name, String email) {
		LocalDate todaysDate = LocalDate.now();
		BankingInfo bankInfo;
		dataController.getUserList().add(new RegisteredUser(username, password, f_name, l_name, email, null, new Date(todaysDate.getDayOfMonth(), todaysDate.getMonth().toString(), todaysDate.getYear())));
	}
	
	public boolean checkExisting(String username) {
		for(int i = 0; i < dataController.getUserList().size(); i++){
			System.out.println("The system's info: " + dataController.getUserList().get(i).username);
			if(dataController.getUserList().get(i).username.compareTo(username) == 0){
				return true;
			}
		}
		return false;
	}


	//Getters and setters
	public RegisteredUser getCurrentUser() { return currentUser; }

	public void setCurrentUser(RegisteredUser currentUser) { this.currentUser = currentUser; }


}
