package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.vo.AccountVO;

public class SelectByNoUI extends BaseAccUI {

	@Override
	public void execute() throws Exception {

		String accountNo = scanStr("\t조회할 계좌번호를 입력하세요 : ");

		AccountVO account = accountService.selectAccountByNo(accountNo);

		if (account == null) {
			System.out.println("입력하신 [" + accountNo + "]계좌는 존재하지 않습니다");
		} else {
			System.out.println();
			System.out.println("=======================================================================");
			System.out.println("고객이름\t고객명\t계좌번호\t\t별칭\t잔액\t");
			System.out.println("=======================================================================");
			System.out.println(account.getName() + "\t" + account.getBankName() + "\t" + account.getAccountNo() + "\t"
					+ account.getAccountNickname() + "\t" + account.getBalance());
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("계좌번호로 계좌조회 완료!!");
			System.out.println("");
		}

	}
}