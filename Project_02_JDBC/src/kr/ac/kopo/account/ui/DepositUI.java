package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.service.BalanceInsufficientException;
import kr.ac.kopo.account.vo.AccountVO;

public class DepositUI extends BaseAccUI {

	@Override
	public void execute() throws Exception {

		String accountNo = scanStr("입금할 계좌번호를 입력하세요 : ");
		int deposit = scanInt("입금할 금액을 입력하세요 : ");

		AccountVO account = accountService.selectAccountByNo(accountNo);

		try {
			if (account == null) {
				System.out.println("입력하신 [" + accountNo + "] 계좌는 존재하지 않습니다.");
			} else {
				accountService.depositAccount(accountNo, deposit);
				System.out.println("계좌 : [" + accountNo + "] 에 " + "[" + deposit + " 원" + "]을 입금했습니다.");
			}
		} catch (BalanceInsufficientException e) {
			String message = e.getMessage();
			System.out.println(message);
			e.printStackTrace();

		}
	}
}
