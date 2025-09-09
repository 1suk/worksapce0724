package com.object.ex2;

public class Run {

	public static void main(String[] args) {
		//생성자 선언
		BankAccount ac1 = new BankAccount(); 
		BankAccount ac2 = ac1;
		
		ac1.deposit(5000);
		ac2.withdraw(1000);
		ac1.checkMyBalance();
		
		
		//ac2 = new BankAccount();
		//ac2.deposit(2000);
		
		ac2 = new BankAccount(2000);
		
		ac1.transfer(ac2, 1000);
		ac1.transfer(ac2, 1000);
		ac2.transfer(ac1, 1000);
		
		ac1.checkMyBalance(); 
	    ac2.checkMyBalance();
	}
}
