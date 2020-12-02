package domain.model;

public class Payment {
	private int paymentID;
	private double amount;
	private BankingInfo card;
	
	private static int pCounter = 9000;

	public Payment(double a, BankingInfo c) {
		paymentID = pCounter++;
		amount = a;
		card = c;
	}

	public Payment(int i, double a, BankingInfo c) {
		paymentID = i;
		amount = a;
		card = c;
		pCounter++;
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

	public void setCard(BankingInfo card) {
		this.card = card;
	}

}
