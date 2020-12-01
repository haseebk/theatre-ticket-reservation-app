package domain.model;

public class User {
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
}
