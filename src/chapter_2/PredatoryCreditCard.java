package chapter_2;

import chapter_1.*;

public class PredatoryCreditCard extends CreditCard{
	private double apr;
	
	public PredatoryCreditCard(String cust, String bk, String acnt, int lim,
			double initialBal, double rate){
		super(cust, bk, acnt, lim, initialBal);
		apr = rate;
	}
	
//	public void processMonth(){
//		if(balance > 0){
//			double monthlyFactor = Math.pow(1 + apr, 1.0/12);
//			balance *= monthlyFactor;
//		}
//	}
	
	public boolean charge(double price){
		boolean isSuccess = super.charge(price);
		if(!isSuccess)
			super.charge(5);
		return isSuccess;
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
