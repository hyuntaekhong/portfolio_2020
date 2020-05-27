package kr.ac.kopo.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.user.vo.UserVO;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class UserDAO {

	public static UserVO usvo;
	private Connection conn;
	private PreparedStatement pstmt;

	// 로그인 - id, pw 맞는지 확인

	public UserVO checkUser(UserVO newUser) {
		UserVO user = null;
	

		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();

			sql.append("select id, password ");
			sql.append("   from user_list ");
			sql.append("   where id = ? and password = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			String id = newUser.getId();
			String password = newUser.getPassword();

			pstmt.setString(1, id);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				
				
				id = rs.getString("id");
				
				String password2 = rs.getString("password");
				usvo = new UserVO(id, password2);
				user = new UserVO(id, password2);
				
//				System.out.println(user.getId());
//				System.out.println(user.getPassword());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return user;

	}

}
// VO = NULL값 초기화 => SQL문에서 리턴된 ID, PW값을 받아서
// VO객체에 넣어주고 if(vo != null)이면 로그인 다음과정 진행
// 로그인이 성공되면 id는 static으로 받아서 이후 account 조회 과정에 활용
// VO == NULL 이면 로그인 실패
//			if (!rs.next()) {
//				System.out.println("잘못된 ID, Password를 입력했습니다.");
//				LoginUI lui = new LoginUI();
//				lui.execute();
//			} else {
//				System.out.println("로그인을 성공했습니다.");
//				AccountUI au = new AccountUI();
//
//				au.execute();
//			}
