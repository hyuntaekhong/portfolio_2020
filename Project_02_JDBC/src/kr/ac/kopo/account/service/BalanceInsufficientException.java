package kr.ac.kopo.account.service;

public class BalanceInsufficientException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 450035576276696236L;
	public BalanceInsufficientException() {}
	public BalanceInsufficientException(String message) {
		super(message);
	}
}
