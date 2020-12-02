package domain.model;

public class Payment {
	private int paymentID;
	private double amount;
	private BankingInfo card;
	
<<<<<<< HEAD
	private static int pCounter = 5000;
=======
	private static int pCounter = 0;
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb

	public Payment(double a, BankingInfo c) {
		paymentID = pCounter++;
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

	public void setCard(BankingInfo card) {
		this.card = card;
	}

}
