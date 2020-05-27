package kr.ac.kopo.account.service;

//service를 시작하기 위한 것???? ///////////////////////////////////////////////????
public class AccountServiceFactory {

	private static AccountService service = null;

	public static AccountService getAccountService() {

		if (service == null) {
			service = new AccountService();
		}

		return service;
	}
}
