package kr.ac.kopo.account.ui;

import java.util.Scanner;

import kr.ac.kopo.account.service.AccountService;
import kr.ac.kopo.account.service.AccountServiceFactory;
import kr.ac.kopo.account.ui.IAccountUI;
import kr.ac.kopo.user.vo.UserVO;


// BaseUI는 scanner로 입력받는 동작과 속성들을 정의해주기 위한 class
public abstract class BaseAccUI implements IAccountUI {
	// 멤버 변수
	private Scanner sc;
	protected AccountService accountService;
	protected String userId;
	protected String userName;
	
	public BaseAccUI() {
		sc = new Scanner(System.in);
		accountService = AccountServiceFactory.getAccountService();  //service가 존재하는지 검증
		
		UserVO user = new UserVO();
		userId = user.getId();
	}
	
	// 각 ui별 메뉴 선택을 위한 int값을 입력받는다
	protected int scanInt(String msg) {
		System.out.print(msg);
		return Integer.parseInt(sc.nextLine());
	}
	
	
	// 계좌 등록(이름, 별칭), 수정(별칭), 계좌번호로 조회(계좌번호 입력), 이체시 상대방 계좌번호 입력 등
	protected String scanStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
}




