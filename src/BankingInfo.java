package domain;

public class BankingInfo {
	
	/**
	 * Name of the customer
	 */
	private String customerName;
	
	/**
	 * Type of card used for payment
	 */
	private String cardType;
	
	/**
	 * The card number
	 */
	private String cardNumber;
	
	/**
	 * SVS of the card
	 */
	private String cardSVS;
	
	/**
	 * Expiration of the card
	 */
	private String cardExpirationDate;
	
	// Getters and Setters
	public String getCardExpirationDate() {
		return cardExpirationDate;
	}
	public void setCardExpirationDate(String cardExpirationDate) {
		this.cardExpirationDate = cardExpirationDate;
	}
	public String getCardSVS() {
		return cardSVS;
	}
	public void setCardSVS(String cardSVS) {
		this.cardSVS = cardSVS;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
