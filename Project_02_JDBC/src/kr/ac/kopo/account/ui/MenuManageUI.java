package kr.ac.kopo.account.ui;

public class MenuManageUI extends MenuAccUI{
	private int choiceMenu2() {
		System.out.println("=======================================================================");
		System.out.println("\t\t<계좌 조회>");
		System.out.println("=======================================================================");
		System.out.println("\t1. 계좌 등록");
		System.out.println("\t2. 계좌 수정");
		System.out.println("\t3. 계좌 삭제");
		System.out.println("\t4. 상위메뉴로 이동");
		System.out.println("\t0. 종료");
		System.out.println("=======================================================================");
		int type = scanInt("\t번호를 선택하세요 : ");
		System.out.println();
		return type;
	}

	@Override
	public void execute() throws Exception {
		IAccountUI ui = null; // IAccountUI 인터페이스 초기화
		while (true) {
			int type = choiceMenu2();
			switch (type) {
			case 1: // 2-1. 계좌 등록
				ui = new CareateAccountUI();
				break;
			case 2: // 2-2. 계좌 수정
				ui = new UpdateUI();
				break;
			case 3: // 2-3. 계좌 삭제
				ui = new DeleteUI();
				break;
			case 4: // 2-4.상위 메뉴로 이동
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
