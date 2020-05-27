package kr.ac.kopo.account.vo;

public class AccountVO {

	private String id;				// id
	private String name;			// 이름
	private String bankCode;		// 은행코드
	private String bankName;		// 은행명
	private String accountNo;		// 계좌번호
	private String accountNickname; //계좌별명
	private int    balance;			// 잔액
	
	
	public AccountVO() {
		super();
	}
	
	public AccountVO(String id, String name, String bankCode, String bankName, String accountNo, int balance, String accountNickname) {
		super();
		this.id = id;
		this.name = name;
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.accountNo = accountNo;
		this.balance = balance;
		this.accountNickname = accountNickname;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountNickname() {
		return accountNickname;
	}

	public void setAccountNickname(String accountNickname) {
		this.accountNickname = accountNickname;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "AccountVO [id=" + id + ", name=" + name + ", bankCode=" + bankCode + ", bankName=" + bankName
				+ ", accountNo=" + accountNo + ", balance=" + balance + "]";
	}
}
