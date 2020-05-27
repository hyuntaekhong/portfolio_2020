package kr.ac.kopo.user.service;

//service를 시작하기 위한 것???? ///////////////////////////////////////////////????
public class UserServiceFactory {

	private static UserService user = null;

	public static UserService getUserService() {

		if (user == null) {
			user = new UserService();
		}

		return user;
	}
}
