package kr.ac.kopo.account.ui;

import java.util.List;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.user.dao.UserDAO;

public class TransferUI extends BaseAccUI {

	@Override
	public void execute() throws Exception {

		String id = UserDAO.usvo.getId();
		List<AccountVO> list = accountService.selectAllAccountById(id);

		if (list.isEmpty()) {
			System.out.println("등록한 계좌가 없습니다");
		} else {
			System.out
					.println("=======================================================================================");
			System.out.println("ID\t이름\t은행코드\t은행명\t계좌번호\t\t별칭\t\t잔액");
			System.out
					.println("=======================================================================================");
			for (AccountVO account : list) {
				System.out.println(account.getId() + "\t" + account.getName() + "\t" + account.getBankCode() + "\t"
						+ account.getBankName() + "\t" + account.getAccountNo() + "\t" + account.getAccountNickname()
						+ "\t\t" + account.getBalance());
			}
			System.out
					.println("=======================================================================================");
			int money = 0;
			while (true) {
				money = scanInt("보낼 금액을 입력하세요 : ");
				if (money > 0) {
					break;
				}
				System.out.println("0원 이상의 금액을 입력하세요");
			}

			String myAccountNo = scanStr("출금할 계좌를 입력하세요 : ");
			String oppAccountNo2 = scanStr("받는분 계좌번호를 입력하세요 : ");

//			AccountVO oppAccount = accountService.selectAccountByNo(oppAccountNo2);
			if (myAccountNo == null) {
				System.out.println("=======================================================================");
				System.out.println("해당계좌가 존재하지 않습니다.");
				System.out.println("=======================================================================");
			} else {
				accountService.transferAccount(oppAccountNo2, myAccountNo, money);
			}
		}
	}
}
