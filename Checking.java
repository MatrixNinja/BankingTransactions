package com.egarduno.Banking;
import java.io.IOException;

/*__________________________________

	Emilio Garduno
	08/14/2013
	Banking Transactions
__________________________________*/

@SuppressWarnings("unused")
public class Checking extends AcctTrans implements I_Trans{
	//==========Constants
	private double checkFee = .02;
	private double overdraft = 25;
	private double balance = 0;
	
	private WriteLog write;
	//Constructor initialize the class (must be the same name as the Class)
	public Checking() throws IOException{
		write = new WriteLog("TransactionLog.txt");
	}

	@Override
	public void Credit(double amount){
		balance += amount;
		write.addText("Checking credit " + amount + " balance: " + balance);
		write.closeFile();
	}

	@Override
	public void Debit(double amount){
		balance -= (amount + checkFee);
		
		if(amount < 0){
			overdraft -= amount;
		}
		
		write.addText("Checking debit " + amount + " balance: " + balance);
		write.closeFile();
	}

	@Override
	public double Balance(){
		return balance;
	}
	
	public void setBalance(double amount){
		balance = amount;
	}

}
