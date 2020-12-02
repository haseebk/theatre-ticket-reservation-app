package domain.model;

import java.util.ArrayList;

public class Receipt {
	private int receiptID;
	private static int receiptCounter = 1100;
	private Payment payment;
	private Date date;
	private ArrayList<Ticket> ticket;

	public Receipt(int receiptID, Payment payment, Date date) {
		this.receiptID = receiptID;
		receiptCounter++;
		this.payment = payment;
		this.date = date;
		this.ticket = new ArrayList<Ticket>();
	}

	public Receipt(Payment payment, Date date,ArrayList<Ticket> ticket) {
		this.receiptID = receiptCounter++;
		this.payment = payment;
		this.date = date;
		this.ticket = ticket;
		for(int i = 0; i < ticket.size(); i++){
			ticket.get(i).setReceipt(this);
		}
	}

	// This method will print the receipt to the screen?
	public void printReceipt() {
		System.out.println(receiptToString());
	}

	// This method emails the receipt created
	public void emailReceipt(String email) {
		System.out.println("To: " + email + "\n" + receiptToString());
	}

	// Receipt info printed to console
	public String receiptToString() {
		String receipt = "Reciept ID: " + getReceiptID() + "\n";
		for(int i=0; i<ticket.size(); i++) {
			receipt += "TicketID: " + ticket.get(i).getTicketID() + "\nMovie: " + ticket.get(i).getThe_movie().getTitle() + "\nTheatre: " +
					ticket.get(i).getShowtime().getAuditorium().getTheatre().getT_name() + "\nAuditorium: " + ticket.get(i).getShowtime().getAuditorium().getAuditoriumID() + "\nSeat: " + ticket.get(i).getSeat() +"\n";
		}
		return receipt;
	}

	// Getters and Setters
	public int getReceiptID() {
		return receiptID;
	}

	public void setReceiptID(int receiptID) {
		this.receiptID = receiptID;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(ArrayList<Ticket> ticket) {
		this.ticket = ticket;
	}

	public void addTicket(Ticket t){this.ticket.add(t);}

}
