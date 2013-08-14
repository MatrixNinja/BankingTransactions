package com.egarduno.Banking;

import java.io.IOException;

public class Savings extends AcctTrans implements I_Trans{
	//==========Constants
	private double interest = .10;
	private double balance = 0;
	
	private WriteLog write;
	//Constructor initialize the class (must be the same name as the Class)
	public Savings() throws IOException{
		write = new WriteLog("TransactionLog.txt");
	}
	
	public void CalcInterest(){
		/*==================
		Calculate interest based on average total balance within (30) days
		   ==================*/
	}
		
	@Override
	public void Credit(double amount) {
		balance += (amount + interest);
		write.addText("Savings credit " + amount + " balance: " + balance);
		write.closeFile();
	}

	@Override
	public void Debit(double amount) {
		balance -= amount;
		write.addText("Savings debit " + amount + " balance: " + balance);
		write.closeFile();
	}

	@Override
	public double Balance() {
		return balance;
	}
	
}
