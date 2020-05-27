package kr.ac.kopo.account.service;

import java.util.List;

import kr.ac.kopo.account.dao.AccountDAO;
import kr.ac.kopo.account.vo.AccountVO;

/*
       --->         ---> 
	UI      SERVICE      DAO
	   <---         <---
*/
public class AccountService {
	private AccountDAO accountDAO;

	public AccountService() {
		accountDAO = new AccountDAO();
	}

	// 모든 계좌 조회
	public List<AccountVO> selectAllAccountById(String id) {
		List<AccountVO> list = accountDAO.selectAllAccountById(id);
		return list;
	}

	// 은행으로 조회
	public List<AccountVO> selectAccountByBank(String id, String bankName) {
		List<AccountVO> list = accountDAO.selectAccountByBank(id, bankName);
		return list;
	}

	// 계좌번호로 조회
	public AccountVO selectAccountByNo(String accontNo) {
		AccountVO account = accountDAO.selectAccountByNo(accontNo);
		return account;
	}

	// 계좌 등록
	public void insertAccount(AccountVO newAccount) {
		accountDAO.insertAccount(newAccount);
	}

	// 계좌수정
	public void modifyAccount(String accountNo, String accountNickname) {
		accountDAO.modifyAccount(accountNo, accountNickname);
	}

	// 계좌 번호로 삭제
	public void deleteAccountByNo(String accountNo) {
		accountDAO.deleteAccount(accountNo);
	}

	// 입금
	public void depositAccount(String accountNo, int deposit) throws BalanceInsufficientException {
		if (deposit < 0) {
			throw new BalanceInsufficientException("잘못된 금액  [" + deposit + "] 이 입력되었습니다.");
		}
		accountDAO.depositAccount(accountNo, deposit);
	}

	// 출금
	public void withdrowAccount(String accountNo, int withdraw) throws BalanceInsufficientException{
		accountDAO.withdrowAccount(accountNo, withdraw);
	}

	// 이체
	public void transferAccount(String oppAccount, String myAccountNo, int money) throws BalanceInsufficientException{
		accountDAO.transferAccount(oppAccount, myAccountNo, money);
	}

}
