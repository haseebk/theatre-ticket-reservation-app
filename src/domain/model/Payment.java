package domain.model;

public class Payment {
	private int paymentID;
	private double amount;
	BankingInfo card;
	
	public Payment(int pId, double a, BankingInfo c) {
		paymentID = pId;
		amount = a;
		card = c;
	}
	
	// Getters and Setters
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public BankingInfo getCard() {
		return this.card;
	}
	public void setCard(BankingInfo card){
		this.card = card;
	}

}
