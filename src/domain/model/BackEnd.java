package domain.model;

import database.DataController;

import java.io.Serializable;
import java.time.LocalDate;

public class BackEnd implements Serializable {
	private static final long serialVersionUID = 1L;

	private DataController dataController;

	private RegisteredUser currentRegisteredUser;

	private GuestUser currentGuestUser;

	public BackEnd() {
		dataController = DataController.getOnlyInstance();
	}

	// Sets the current user to a Guest User
	public void guestUser() {
		currentGuestUser = new GuestUser();
		currentRegisteredUser = null;
	}

	// Verifies the login credentials of the current user
	// If the login is successful will set the current user to the registered user
	// and will return the User's ID;
	// If the login failed return null;
	public RegisteredUser verifyLogin(String username, String password) {
		for (int i = 0; i < dataController.getUserList().size(); i++) {
			if (dataController.getUserList().get(i).username.toLowerCase().compareTo(username.toLowerCase()) == 0
					&& dataController.getUserList().get(i).password.compareTo(password) == 0) {
				currentRegisteredUser = dataController.getUserList().get(i);
				currentGuestUser = null;
				return dataController.getUserList().get(i);
			}
		}
		return null;
	}

	// Clears the current user
	public void userLogout() {
		currentGuestUser = null;
		currentRegisteredUser = null;
	}

	public void registerUser(String username, String password, String f_name, String l_name, String email, String name,
			String cardType, String cardNum, String cardSVS, String expirationDate) {
		LocalDate todaysDate = LocalDate.now();
		BankingInfo bankInfo = new BankingInfo(name, cardType, cardNum, cardSVS, expirationDate);
		dataController.getUserList().add(new RegisteredUser(username, password, f_name, l_name, email, bankInfo,

		new Date(todaysDate.getDayOfMonth(), todaysDate.getMonthValue(), todaysDate.getYear() + 1)));
	}

	public boolean checkExisting(String username) {
		for (int i = 0; i < dataController.getUserList().size(); i++) {
			if (dataController.getUserList().get(i).username.compareTo(username) == 0) {
				return true;
			}
		}
		return false;
	}

	// Getters and setters
	public RegisteredUser getCurrentRegisteredUser() {
		return currentRegisteredUser;
	}

	public void setCurrentRegisteredUser(RegisteredUser currentRegisteredUser) {
		this.currentRegisteredUser = currentRegisteredUser;
	}

	public DataController getDataController() {
		return dataController;
	}

	public GuestUser getCurrentGuestUser() {
		return currentGuestUser;
	}

	public User getCurrentUser() {
		if (currentRegisteredUser != null) {
			return currentRegisteredUser;
		} else {
			return currentGuestUser;
		}
	}

	public void setCurrentGuestUser(GuestUser currentGuestUser) {
		this.currentGuestUser = currentGuestUser;
	}
}
