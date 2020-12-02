package domain.model;

import java.util.*;

public class Cart {
	private ArrayList<Booking> items_in_cart;
	private Payment payment;
	private float cartCost;

	public Cart() {
		items_in_cart = new ArrayList<Booking>();
		payment = null;
		cartCost = 0;
	}

	public Cart(ArrayList<Booking> items, Payment pay) {
		items_in_cart = new ArrayList<Booking>();
		for (int i = 0; i < items.size(); i++) {
			items_in_cart.add(items.get(i));
		}
		setPayment(pay);
		for (Booking cartItem : items_in_cart) {
			cartCost += 13.99;
		}
	}

	// This method adds a ticket from the argument to the cart items list
	public void addToCart(Booking item) {
		items_in_cart.add(item);
	}

	// This method removes a ticket specified item from the cart
	public void removeFromCart(Booking item) {
		Iterator<Booking> it = items_in_cart.iterator();
		while (it.hasNext()) {
			Booking currentTicket = (Booking) it.next();
			if (item.getBookingID() == currentTicket.getBookingID()) {
				it.remove();
				return;
			}
		}
		return;
	}

	// Getters and Setters
	public ArrayList<Booking> getItems_in_cart() {
		return items_in_cart;
	}

	public void setItems_in_cart(ArrayList<Booking> items_in_cart) {
		this.items_in_cart = items_in_cart;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public float getCartCost() {
		return cartCost;
	}

	public float calculateCartCost() {
		cartCost = 0;
		for (Booking cartItem : items_in_cart) {
			cartCost += 13.99;
		}
		return cartCost;
	}

	public void setCartCost(float cartCost) {
		this.cartCost = cartCost;
	}
}