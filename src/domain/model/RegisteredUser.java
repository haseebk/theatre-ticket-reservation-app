package domain.model;

public class RegisteredUser extends User {
	String username;
	String password;
	String f_name;
	String l_name;
	String email;
	BankingInfo bankInfo;
	Date adminFeeDate;

	public RegisteredUser() {
		super("Registered");
	}

	public RegisteredUser(String u, String p, String f, String l, String e, BankingInfo b, Date a) {
		super("Registered");
		username = u;
		password = p;
		f_name = f;
		l_name = l;
		email = e;
		bankInfo = b;
		adminFeeDate = a;
	}
	public RegisteredUser(int id,String u, String p, String f, String l, String e, BankingInfo b, Date a) {
		super(id,"Registered");
		username = u;
		password = p;
		f_name = f;
		l_name = l;
		email = e;
		bankInfo = b;
		adminFeeDate = a;
	}

	// Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String u) {
		this.username = u;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String p) {
		this.password = p;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f) {
		this.f_name = f;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l) {
		this.l_name = l;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String e) {
		this.email = e;
	}

	public BankingInfo getBankInfo() {
		return bankInfo;
	}

	public void setBankInfo(BankingInfo b) {
		this.bankInfo = b;
	}

	public Date getAdminFeeDate() {
		return adminFeeDate;
	}

	public void setAdminFeeDate(Date a) {
		this.adminFeeDate = a;
	}

	/**
	 * Checks if the user has paid the fee
	 * @return true if user has paid fee, false if user has not paid fee
	 */
	public boolean isFeePayed() {
		return adminFeeDate.beforeCurrentDate();
	}
}
