package domain.model;

public class Voucher {
	private String voucherCode;
	private boolean used;

	public Voucher() {
	}

	// This method sets the voucher as used = true
	// If the voucher is already used returns false
	// to indicate failure, otherwise returns true
	public boolean redeem() {
		if (!isUsed()) {
			setUsed(true);
			return true;
		}
		return false;
	}

	// This method sends the voucher code to the
	// email id in the argument
	public void emailCode(String email) {
		// Needs to be implemented still
	}

	// Getters and Setters
	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
}
