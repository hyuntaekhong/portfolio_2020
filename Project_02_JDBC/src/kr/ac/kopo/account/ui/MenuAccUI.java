package kr.ac.kopo.account.ui;


public class MenuAccUI extends BaseAccUI{

	 int choiceMenu() {
		System.out.println("=======================================================================");
		System.out.println("\t\t<통합계좌관리>");
		System.out.println("=======================================================================");
		System.out.println("\t1. 계좌 조회");
		System.out.println("\t2. 계좌 관리");
		System.out.println("\t3. 입출금 및 계좌이체");
		System.out.println("\t0. 종료");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		int type = scanInt("\t번호를 선택하세요 : ");
		System.out.println();
		return type;
	}

	@Override
	public void execute() throws Exception {
		while (true) {
			int type = choiceMenu();
			IAccountUI ui = null; // IAccountUI 인터페이스 초기화
			switch (type) {
			case 1: // 1.계좌 조회
				ui = new SelectAccount();
				break;
			case 2: // 2.계좌 관리
				ui = new MenuManageUI();
				break;
			case 3: // 3.입출금 및 계좌 이체
				ui = new MenuTransUI();
				break;
			case 0:
				ui = new ExitUI();
				break;
			}

			if (ui != null) { // ui가 null이 아니라는 것은 예외가 발생했다는 의미
				ui.execute();
				System.out.println("잘못된 번호입니다.");
			}
		}
	}
}
