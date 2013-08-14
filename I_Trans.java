package com.egarduno.Banking;

public interface I_Trans {
	
	public void Credit(double amount);
	
	public void Debit(double amount);

	public double Balance();
}
