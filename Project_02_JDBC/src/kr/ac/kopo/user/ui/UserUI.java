package kr.ac.kopo.user.ui;

import kr.ac.kopo.account.ui.ExitUI;
import kr.ac.kopo.account.ui.IAccountUI;
import kr.ac.kopo.account.ui.LoginUI;

public class UserUI extends BaseUI {
// 로그인 관련 ui
	private int userMenu() {
		System.out.println("=======================================================================");
		System.out.println("\t\t<통합계좌관리 프로그램>");
		System.out.println("=======================================================================");
		System.out.println("\t1. 로그인");
		System.out.println("\t0. 프로그램 종료");
		System.out.println("=======================================================================");
		int type = scanInt("\t번호를 선택하세요 : ");
		return type;
	}

	@Override
	public void execute() throws Exception {
		while (true) {

			int type = userMenu();
			IAccountUI ui = null; // IAccountUI 인터페이스 초기화

			switch (type) {
			case 1: // 1.로그인
				ui = new LoginUI();
				break;
			case 0:
				ui = new ExitUI();
				break;
			}
			if (ui != null) {
				ui.execute();
			}
		}
	}
}
