<<<<<<< HEAD
package domain.model;

import java.util.ArrayList;
import java.util.Iterator;

public class FinancialInstitution {
	private String name;
	private ArrayList<BankingInfo> bankAccounts;

	public FinancialInstitution(String n) {
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
			BankingInfo currentAccount = (BankingInfo) it.next();
			if (ba.getCustomerName() == currentAccount.getCustomerName()) {
				it.remove();
				return;
			}
		}
		return;
	}
	
	public boolean verifyCardInfo(String name, String type, String num, String svs, String exp) {
		Iterator<BankingInfo> it = bankAccounts.iterator();
		System.out.println("Verifying Card: " +  bankAccounts.size());
        while (it.hasNext()) {
        	BankingInfo currentAccount = (BankingInfo)it.next();
        	System.out.println("\nVerifying...");
        	System.out.println(name.compareTo(currentAccount.getCustomerName())+ ", " + type.compareTo(currentAccount.getCardType())
					+ ", " + num.compareTo(currentAccount.getCardNumber())+ ", " + svs.compareTo(currentAccount.getCardSVS() )
					+ ", " + exp.compareTo(currentAccount.getCardExpirationDate()));
            if(name.compareTo(currentAccount.getCustomerName()) == 0 && type.compareTo(currentAccount.getCardType()) == 0
					&& num.compareTo(currentAccount.getCardNumber()) == 0 && svs.compareTo(currentAccount.getCardSVS() ) == 0
					&& exp.compareTo(currentAccount.getCardExpirationDate()) == 0) {
            	return true;
            }
        }
		return false;
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

=======
package domain.model;

import java.util.ArrayList;
import java.util.Iterator;

public class FinancialInstitution {
	private String name;
	private ArrayList<BankingInfo> bankAccounts;

	public FinancialInstitution(String n) {
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
			BankingInfo currentAccount = (BankingInfo) it.next();
			if (ba.getCustomerName() == currentAccount.getCustomerName()) {
				it.remove();
				return;
			}
		}
		return;
	}
	
	public boolean verifyCardInfo(String name, String type, String num, String svs, String exp) {
		Iterator<BankingInfo> it = bankAccounts.iterator();
		System.out.println("Verifying Card: " +  bankAccounts.size());
        while (it.hasNext()) {
        	BankingInfo currentAccount = (BankingInfo)it.next();
        	System.out.println("\nVerifying...");
        	System.out.println(name.compareTo(currentAccount.getCustomerName())+ ", " + type.compareTo(currentAccount.getCardType())
					+ ", " + num.compareTo(currentAccount.getCardNumber())+ ", " + svs.compareTo(currentAccount.getCardSVS() )
					+ ", " + exp.compareTo(currentAccount.getCardExpirationDate()));
            if(name.compareTo(currentAccount.getCustomerName()) == 0 && type.compareTo(currentAccount.getCardType()) == 0
					&& num.compareTo(currentAccount.getCardNumber()) == 0 && svs.compareTo(currentAccount.getCardSVS() ) == 0
					&& exp.compareTo(currentAccount.getCardExpirationDate()) == 0) {
            	return true;
            }
        }
		return false;
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

>>>>>>> 4b3d80a2f2c340ab295fc82f6486f3218da4aa2b
}