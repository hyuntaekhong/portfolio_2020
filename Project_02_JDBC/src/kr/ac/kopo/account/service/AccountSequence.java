package kr.ac.kopo.account.service;

public class AccountSequence {

	private static int accountNo = 1;
	
	public static int getAccountSequence() {
		return accountNo++;
	}
}
