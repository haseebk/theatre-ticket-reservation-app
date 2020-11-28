package domain;

import java.util.ArrayList;
import java.util.Iterator;

public class Financial_Institution {
	private String name;
	private ArrayList<BankingInfo> bankAccounts;
	
	public Financial_Institution(String n) {
		setName(n);
		setBankAccounts(new ArrayList<BankingInfo>());		
	}
	
	// This method adds a bank account to the list of accounts for the institution
	public void addAccount(BankingInfo ba) {
		bankAccounts.add(ba);
	}
	
	public void removeAccount(BankingInfo ba) {
		Iterator<BankingInfo> it = bankAccounts.iterator(); 
        while (it.hasNext()) {
        	BankingInfo currentAccount = (BankingInfo)it.next();
            if(ba.getAccountId() == currentAccount.getAccountId()) {
            	it.remove();
            	return;
            }
        }
        return;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<BankingInfo> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(ArrayList<BankingInfo> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	

}
