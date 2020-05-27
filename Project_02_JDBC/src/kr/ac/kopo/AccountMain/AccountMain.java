package kr.ac.kopo.AccountMain;


import kr.ac.kopo.user.ui.UserUI;

public class AccountMain {

	public static void main(String[] args) {
		UserUI ui = new UserUI();
		try {
			ui.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
