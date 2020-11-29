package domain.model;

public class Payment {
	private int paymentID;
	private int amount;
	BankingInfo card;
	
	// Getters and Setters
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
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
