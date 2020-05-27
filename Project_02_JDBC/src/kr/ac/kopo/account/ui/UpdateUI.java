package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.vo.AccountVO;

public class UpdateUI extends BaseAccUI {

	@Override
	public void execute() throws Exception {

		String accountNo = scanStr("수정할 계좌 번호를 입력하세요 : ");
		String accountNickname = scanStr("새로운 별칭을 입력하세요 : ");
		System.out.println();

		AccountVO account = accountService.selectAccountByNo(accountNo);

		if (account == null) {
			System.out.println("입력하신 [" + accountNo + "] 계좌는 존재하지 않습니다.");
			System.out.println();
		} else {
			accountService.modifyAccount(accountNo, accountNickname);
			System.out.println("[" + accountNo + "] 계좌의 별칭을 [" + accountNickname + "] 으로 수정합니다");
			System.out.println();
		}
	}

}
