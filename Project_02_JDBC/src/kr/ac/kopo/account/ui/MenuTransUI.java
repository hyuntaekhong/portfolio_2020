package kr.ac.kopo.account.ui;

public class MenuTransUI extends MenuAccUI{

		private int choiceMenu3() {
			System.out.println("=======================================================================");
			System.out.println("\t<입출금/이체>");
			System.out.println("=======================================================================");
			System.out.println("\t1. 입금");
			System.out.println("\t2. 출금");
			System.out.println("\t3. 이체");
			System.out.println("\t4. 상위메뉴로 이동");
			System.out.println("\t0. 종료");
			System.out.println("=======================================================================");
			int type = scanInt("\t번호를 선택하세요 : ");
			return type;
		}

		@Override
		public void execute() throws Exception {
			while (true) {
				int type = choiceMenu3();
				IAccountUI ui = null; // IAccountUI 인터페이스 초기화
				switch (type) {
				case 1: // 3-1. 입금
					ui = new DepositUI();
					break;
				case 2: // 3-2. 출금
						ui = new WithdrowUI();
					break;
				case 3: // 3-3. 이체
					ui = new TransferUI();
					break;
				case 4: // 3-4.상위 메뉴로 이동
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

