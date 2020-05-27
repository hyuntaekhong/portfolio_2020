package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.user.dao.UserDAO;

public class CareateAccountUI extends SelectAccount {
	private int choiseSubMenu() {
		System.out.println("------------------------------------------------------------------------");
		System.out.println(" 1. 하나은행  2. 국민은행  3. 신한은행  4. 우리은행  5. 기업은행 ");
		System.out.println("------------------------------------------------------------------------");
		int type = scanInt("계좌를 개설할 은행을 입력하세요 : ");
		System.out.println();
		return type;
	}

	@Override
	public void execute() throws Exception {

		int type = choiseSubMenu();
		String id = UserDAO.usvo.getId();
		String bankCode = null;
		String bankName = null;
		String nickName = null;
		String createAccountNo = "-" + (int) Math.floor(1000 + Math.random() * 9000 + 1);

		switch (type) {
		case 1:
			System.out.println("선택한 은행 : 하나은행");
			bankName = "하나은행";
			bankCode = "1001";
			nickName = scanStr("계좌의 별칭을 입력하세요 : ");
			break;
		case 2:
			System.out.println("선택한 은행 : 국민은행");
			bankName = "국민은행";
			bankCode = "1002";
			nickName = scanStr("계좌의 별칭을 입력하세요 : ");
			break;
		case 3:
			System.out.println("선택한 은행 : 신한은행");
			bankName = "신한은행";
			bankCode = "1003";
			nickName = scanStr("계좌의 별칭을 입력하세요 : ");
			break;
		case 4:
			System.out.println("선택한 은행 : 우리은행");
			bankName = "우리은행";
			bankCode = "1004";
			nickName = scanStr("계좌의 별칭을 입력하세요 : ");
			break;
		case 5:
			System.out.println("선택한 은행 : 기업은행");
			bankName = "기업은행";
			bankCode = "1005";
			nickName = scanStr("계좌의 별칭을 입력하세요 : ");
			break;
		default:
			System.out.println("잘못된 숫자를 입력했습니다");
		}
		
		if (type > 0 && type < 5) {
			System.out.println();
			System.out.println("------------------------------------------------------------------------");
			System.out.println("계좌 개설을 완료하였습니다");

			AccountVO newAccount = new AccountVO();

			newAccount.setId(id);
			newAccount.setBankCode(bankCode);
			newAccount.setBankName(bankName);
			newAccount.setAccountNickname(nickName);
			newAccount.setAccountNo(bankCode + createAccountNo);

			accountService.insertAccount(newAccount);
		}
	}

}
