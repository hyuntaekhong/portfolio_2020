package kr.ac.kopo.account.ui;

public class DeleteUI extends BaseAccUI {

	
	/// 삭제 if else 구문 작성
	@Override
	public void execute() throws Exception {

		String accountNo = scanStr("삭제할 계좌번호를 입력하세요 : ");
		accountService.deleteAccountByNo(accountNo);

		System.out.println("[" + accountNo + "]" + "계좌가 삭제되었습니다");
	}

}