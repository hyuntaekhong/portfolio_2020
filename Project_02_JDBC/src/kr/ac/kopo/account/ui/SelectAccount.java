package kr.ac.kopo.account.ui;

public class SelectAccount extends BaseAccUI {
	protected int choiceMenu2() {
		System.out.println("=======================================================================");
		System.out.println("\t\t<계좌 조회>");
		System.out.println("=======================================================================");
		System.out.println("\t1. 전체계좌 조회");
		System.out.println("\t2. 은행으로 조회");
		System.out.println("\t3. 계좌번호로 조회");
		System.out.println("\t4. 상위메뉴로 이동");
		System.out.println("\t0. 종료");
		System.out.println("-----------------------------------------------------------------------");
		int type = scanInt("\t번호를 선택하세요 : ");
		System.out.println();
		System.out.println();
		return type;
	}

	@Override
	public void execute() throws Exception {
		while (true) {
			int type = choiceMenu2();
			IAccountUI ui = null; // IAccountUI 인터페이스 초기화
			switch (type) {
			case 1: // 1-1. 전체계좌 조회
				ui = new SelectByIdUI();
				break;
			case 2: // 1-2. 은행별로 조회
				ui = new SelectByBankUI();
				break;
			case 3: // 1-3. 계좌번호로 조회
				ui = new SelectByNoUI();
				break;
			case 4: // 1-4.상위 메뉴로 이동
				ui = new MenuAccUI();
				break;
			case 0:
				ui = new ExitUI();
				break;
			}

			if (ui != null) { // ui가 null이 아니라는 것은 예외가 발생했다는 의미
				ui.execute();
			}
		}
	}
}
