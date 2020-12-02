package domain.model;

public class User {
	private int userID;
	private static int userCounter = 0;
	/**
	 * Type of User
	 */
	private String userType;
	private Cart cart;

	/**
	 * Constructor to set the type of user
	 * 
	 * @param t the user type
	 */
	User(String t) {
<<<<<<< HEAD
		this.userID = userCounter++;
=======
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb
		this.userType = t;
		this.cart = new Cart();
	}

<<<<<<< HEAD
	/**
	 * Constructor to set the type of user
	 *
	 * @param t the user type
	 */
	User(int id, String t) {
		this.userID = id;
		userCounter++;
		this.userType = t;
		this.cart = new Cart();
	}

=======
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb
	// Getters and Setters
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
