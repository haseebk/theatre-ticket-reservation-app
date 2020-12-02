package domain.model;

public class Payment {
	private int paymentID;
	private double amount;
	private BankingInfo card;
	
<<<<<<< HEAD
<<<<<<< HEAD
	private static int pCounter = 5000;
=======
	private static int pCounter = 0;
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb
=======
	private static int pCounter = 9000;
>>>>>>> e3e4d5158eb76a3968573acf864f4c378adcc8a3

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
