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
		this.userID = userCounter++;
		this.userType = t;
		this.cart = new Cart();
	}

	/**
	 * Constructor to set the type of user
	 *
	 * @param t the user type
	 */
	User(int id, String t) {
		this.userID = id;
		if(id > userCounter){
			userCounter = id+1;
		}else {
			userCounter++;
		}
		this.userType = t;
		this.cart = new Cart();
	}

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

	public int getUserID() { return userID; }

	public void setUserID(int userID) { this.userID = userID; }
}
