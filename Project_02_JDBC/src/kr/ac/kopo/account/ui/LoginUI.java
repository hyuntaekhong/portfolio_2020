package kr.ac.kopo.account.ui;


import kr.ac.kopo.user.ui.UserUI;
import kr.ac.kopo.user.vo.UserVO;

public class LoginUI extends UserUI {
	@Override
	public void execute() throws Exception {
		System.out.println("=======================================================================");
		System.out.println("\t\t      <로그인>");
		System.out.println("-----------------------------------------------------------------------");
		String userId = scanStr("\n\t아이디  입력 : ");
		String userPassword = scanStr("\t비밀번호  입력 : ");
		System.out.println();

		UserVO user = new UserVO(userId, userPassword);
		UserVO newUser = userService.checkUserInfo(user);
		
		if(newUser != null) {
			System.out.println("\t로그인을 하였습니다.\n");
			MenuAccUI au = new MenuAccUI();
			au.execute();
		} else {
			System.out.println("\t로그인을 실패하였습니다. 아이디와 비밀번호를 확인해주세요.\n");
		}	
	}
}
