package domain;

import java.util.*;

public class Cart {
	private ArrayList<Ticket> items_in_cart;
	
	public Cart () {
		items_in_cart =  new ArrayList<Ticket>(); 
	}
	
	// This method adds a ticket from the argument to the cart items list
	public void addToCart(Ticket item) {
		items_in_cart.add(item);
	}
	
	// This method removes a ticket specified item from the cart
	public void removeFromCart(Ticket item) {
		Iterator<Ticket> it = items_in_cart.iterator(); 
        while (it.hasNext()) {
        	Ticket currentTicket = (Ticket)it.next();
            if(item.getTicketID() == currentTicket.getTicketID()) {
            	it.remove();
            	return;
            }
        }
        return;
	}

	// Getters and Setters
	public ArrayList<Ticket> getItems_in_cart() {
		return items_in_cart;
	}

	public void setItems_in_cart(ArrayList<Ticket> items_in_cart) {
		this.items_in_cart = items_in_cart;
	}
}
