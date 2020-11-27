package domain;

public class Receipt {
	private int receiptID;
	private Payment payment;
	private Date date;
	private Ticket ticket;

	public Receipt() {
	}

	// This method will print the receipt to the screen?
	public void printReceipt() {
		System.out.println(receiptToString());
	}

	// This method emails the receipt created
	public void emailReceipt(String email) {
		// to be implemented
	}

	public String receiptToString() {
		return "Receipt:\n" + "Customer: " + "\n" + "Movie: " + "\n" + "Theatre: " + "\n" + "Seat: " + "\n" + "Date: "
				+ "\n";
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

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
