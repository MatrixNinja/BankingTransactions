package com.egarduno.Banking;

/*__________________________________

	Emilio Garduno
	08/14/2013
	Banking Transactions
__________________________________*/

public interface I_Trans {
	
	public void Credit(double amount);
	
	public void Debit(double amount);

	public double Balance();
}
