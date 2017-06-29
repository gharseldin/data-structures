package chapter_1;

public class CreditCard {
	private String customer;
	private String bank;
	private String account;
	private int limit;
	protected double balance;
	
	// constructors
	public CreditCard(String cust, String bk, String acnt, int lim, double initialBal){
		customer = cust;
		bank = bk;
		account = acnt;
		limit = lim;
		balance = initialBal;
	}
	
	public CreditCard(String cust, String bk, String acnt, int lim){
		this(cust, bk, acnt, lim, 0.0);
	}
	
	// Accessor methods
	public String getCustomer(){ return customer;}
	public String getBank(){ return bank;}
	public String getAccount(){return account;}
	public int getLimit(){return limit;}
	public double getBalance(){return balance;}
	
	// Update methods
	// adjusted for question 12
	public boolean charge(double price){
		if (!(price<0) && price + balance > limit){
			System.out.println("Limit reached! Transaction denied." + this.account);
			return false;
		}
		balance += price;
		return true;
	}
	public void makePayment(double amount){
		balance -=amount;
	}
	
	// Question 11
	public void updateLimit(int newLimit){
		this.limit = newLimit;
	}
	
	// Utility method to print card's information
	public String toString(){
		return "Customer = " + this.customer + "\n" +
				"Bank = " + this.bank + "\n" +
				"Account = " + this.account+ "\n" +
				"Balance = " + this.balance+ "\n" +
				"Limit = " + this.limit;
	}
	
	public static void main(String args[]){
		CreditCard[] wallet = new CreditCard[3];
		wallet[0] = new CreditCard("Amr Gharseldin", "California Savings",
				"555 666 777 888", 5000);
		wallet[1] = new CreditCard("Amr Gharseldin", "California Bank",
				"111 222 333 444", 3500);
		wallet[2] = new CreditCard("Amr Gharseldin", "Some Bank",
				"123 234 345 456", 2500 , 300);
		
		for (int val = 1; val <=16; val++){
			wallet[0].charge(3*val);
			wallet[1].charge(2*val);
			wallet[2].charge(val);
		}
		
		for(CreditCard card: wallet){
			System.out.println(card);
			while(card.getBalance()>200.0){
				card.makePayment(200);
				System.out.println("New balance = "+ card.getBalance());
				System.out.println("--------------------------");
			}
		}
	}
}
