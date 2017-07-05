package chapter_2;

import chapter_1.*;

public class PredatoryCreditCard extends CreditCard{
	private double apr;
	private int monthlyCharges;
	private double minimumPaymentDue;
	
	public PredatoryCreditCard(String cust, String bk, String acnt, int lim,
			double initialBal, double rate){
		super(cust, bk, acnt, lim, initialBal);
		apr = rate;
		monthlyCharges = 0;
		minimumPaymentDue = 0;
	}
	
	public void processMonth(){
		if(getBalance() > 0){
			double monthlyFactor = Math.pow(1 + apr, 1.0/12);
			setBalance(getBalance() * monthlyFactor);
		}
		monthlyCharges = 0;
		
		// check minimum due. if not zero then charge penelty
		if(minimumPaymentDue != 0)
			super.charge(30.0D);
		
		minimumPaymentDue = getBalance() * 0.1;
	}
	
	public boolean charge(double price){
		
		monthlyCharges++;
		boolean isSuccess = super.charge(price);
		if(!isSuccess)
			super.charge(5);
		if(monthlyCharges > 10)
			super.charge(1);
		return isSuccess;
	}
	
	public void makePayment(double amount) throws IllegalArgumentException{
		super.makePayment(amount);

		if(amount >= minimumPaymentDue)
			minimumPaymentDue = 0;
		else {
			minimumPaymentDue -= amount;
		}
	}
	
	public static void main(String args[]){
		PredatoryCreditCard card = new PredatoryCreditCard("Amr", "ABC bank","123",
				300, 200, 9.5);
		System.out.println(card);
		card.charge(50);
		System.out.println(card);
		card.charge(60);
		System.out.println(card);
	}
}
