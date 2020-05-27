package kr.ac.kopo.user.service;

import kr.ac.kopo.user.dao.UserDAO;
import kr.ac.kopo.user.vo.UserVO;

public class UserService {
	private UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	// id, pw 맞는지 검증
	public UserVO checkUserInfo(UserVO user) {
		UserVO user1 = userDAO.checkUser(user);
		return user1;
	}	
}
