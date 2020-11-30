package domain.model;

<<<<<<< HEAD
=======
import database.DataController;

>>>>>>> 894e77af10f4a039a72e9a3bf4b3d8bff9f91556
import java.io.Serializable;

public class BackEnd implements Serializable{
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	public BackEnd() {
		
	}
=======

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


	//Getters and setters
	public RegisteredUser getCurrentUser() { return currentUser; }

	public void setCurrentUser(RegisteredUser currentUser) { this.currentUser = currentUser; }

	public DataController getDataController() { return dataController; }
>>>>>>> 894e77af10f4a039a72e9a3bf4b3d8bff9f91556
}
