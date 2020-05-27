package kr.ac.kopo.account.ui;

import kr.ac.kopo.user.ui.BaseUI;

public class ExitUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		System.out.println();
		System.out.println("=======================================================================");
		System.out.println("\n\t통합계좌관리 서비스를 종료합니다\n");
		System.out.println("=======================================================================");
		System.exit(0);
	}
}
