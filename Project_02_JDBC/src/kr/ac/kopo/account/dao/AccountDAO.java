package kr.ac.kopo.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.util.AutoCommit;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class AccountDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private PreparedStatement pstmt2;

	//////////////////////////////////////////////////////////////////////////////////////
	// 계좌등록
	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	public void insertAccount(AccountVO newAccount) {

		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append(" insert into account(id, bank_code, bank_name, account_number, nickname, balance ) ");
			sql.append(" values(?, ?, ?, ?, ?, ?) "); // 선택한 컬럼에 데이터 입력

			pstmt = conn.prepareStatement(sql.toString());

			String id = newAccount.getId(); // id 값 가져오기
			String bankCode = newAccount.getBankCode();
			String bankName = newAccount.getBankName();
			String accountNo = newAccount.getAccountNo(); // 계좌번호 가져오기
			String nickname = newAccount.getAccountNickname();
			int balance = 0;

			pstmt.setString(1, id);
			pstmt.setString(2, bankCode);
			pstmt.setString(3, bankName);
			pstmt.setString(4, accountNo);
			pstmt.setString(5, nickname);
			pstmt.setInt(6, balance);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 전체계좌 조회
	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	public List<AccountVO> selectAllAccountById(String userId) {

		List<AccountVO> list = new ArrayList<>();

		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT A.ID, U.NAME, BANK_CODE, BANK_NAME, ACCOUNT_NUMBER, NICKNAME, BALANCE    ");
			sql.append("		FROM ACCOUNT A 															");
			sql.append("		INNER JOIN USER_LIST U ON U.ID = A.ID  									");
			sql.append("			WHERE A.ID = ?														");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, userId);

			ResultSet rs = pstmt.executeQuery(); // resultset 형태로 리턴

			while (rs.next()) { // 다음행의 실행위치로 이동

				String id = rs.getString("id");
				String name = rs.getString("name");
				String bankCode = rs.getString("bank_code");
				String bankName = rs.getString("bank_name");
				String accountNo = rs.getString("account_number");
				int balance = rs.getInt("balance");
				String accountNickname = rs.getString("nickname");

				AccountVO account = new AccountVO(id, name, bankCode, bankName, accountNo, balance, accountNickname);

				list.add(account);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return list;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 은행으로 조회
	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////

	public List<AccountVO> selectAccountByBank(String userId, String bankName) {
		List<AccountVO> list = new ArrayList<>();

		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT A.ID, U.NAME, BANK_CODE, BANK_NAME, ACCOUNT_NUMBER, NICKNAME, BALANCE    ");
			sql.append("		FROM ACCOUNT A 															");
			sql.append("		INNER JOIN USER_LIST U ON U.ID = A.ID  									");
			sql.append("			WHERE A.ID = ? AND BANK_NAME = ?									");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, userId);
			pstmt.setString(2, bankName);

			ResultSet rs = pstmt.executeQuery(); // resultset 형태로 리턴

			while (rs.next()) { // 다음행의 실행위치로 이동

				String id = rs.getString("id");
				String name = rs.getString("name");
				String bankCode = rs.getString("bank_code");
				String bankName1 = rs.getString("bank_name");
				String accountNo = rs.getString("account_number");
				int balance = rs.getInt("balance");
				String accountNickname = rs.getString("nickname");

				AccountVO account = new AccountVO(id, name, bankCode, bankName1, accountNo, balance, accountNickname);

				list.add(account);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return list;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 계좌번호로 조회
	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////

	public AccountVO selectAccountByNo(String no) {

		AccountVO account = null;

		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();

			sql.append("SELECT A.ID, U.NAME, BANK_CODE, BANK_NAME, ACCOUNT_NUMBER, NICKNAME, BALANCE    ");
			sql.append("		FROM ACCOUNT A 															");
			sql.append("		INNER JOIN USER_LIST U ON U.ID = A.ID  									");
			sql.append("			WHERE A.ACCOUNT_NUMBER = ? 											");
			sql.append("  			OR A.ACCOUNT_NUMBER = SUBSTR(?, 0, 4)||'-'||SUBSTR(?, 5, 4)		    ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, no);
			pstmt.setString(2, no);
			pstmt.setString(3, no);

			ResultSet rs = pstmt.executeQuery(); // resultset 형태로 리턴

			if (rs.next()) { // 다음행의 실행위치로 이동

				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String bankCode = rs.getString("BANK_CODE");
				String bankName = rs.getString("BANK_NAME");
				String accountNo1 = rs.getString("ACCOUNT_NUMBER");
				String accountNickname = rs.getString("NICKNAME");
				int balance = rs.getInt("BALANCE");

				account = new AccountVO(id, name, bankCode, bankName, accountNo1, balance, accountNickname);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return account;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 해당 계좌번호에 해당하는 계좌 수정(별칭만 수정 가능한 것으로 설정)
	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////

	public void modifyAccount(String accountNo, String accountNickname) {
		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE ACCOUNT ");
			sql.append(" 		SET NICKNAME = ? "); // 수정후 새로운 recode
			sql.append(" 		WHERE ACCOUNT_NUMBER = ? "); // 수정전 원래 recode
			sql.append("  			OR ACCOUNT_NUMBER = SUBSTR(?, 0, 4)||'-'||SUBSTR(?, 5, 4)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, accountNickname);
			pstmt.setString(2, accountNo);
			pstmt.setString(3, accountNo);
			pstmt.setString(4, accountNo);

			pstmt.executeUpdate(); // 처리된 recode의 수를 반환

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 번호에 해당하는 게시물을 삭제하는 기능
	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////

	public void deleteAccount(String accountNo) {
		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM ACCOUNT ");
			sql.append("		WHERE ACCOUNT_NUMBER = ?");
			sql.append("  		OR ACCOUNT_NUMBER = SUBSTR(?, 0, 4)||'-'||SUBSTR(?, 5, 4)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, accountNo);
			pstmt.setString(2, accountNo);
			pstmt.setString(3, accountNo);

			pstmt.executeUpdate(); // 처리된 recode의 수를 반환

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 입금
	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////

	public void depositAccount(String accountNo, int deposit) {
		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE ACCOUNT 							");
			sql.append("		SET BALANCE = BALANCE + ?	 		");
			sql.append("		WHERE ACCOUNT_NUMBER = ?			");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, deposit);
			pstmt.setString(2, accountNo);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////
	// 출금////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////

	public void withdrowAccount(String accountNo, int withdraw) {
		try {
			conn = new ConnectionFactory().getConnection();
			conn.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE ACCOUNT 													");
			sql.append("		SET BALANCE = (BALANCE - ?)									");
			sql.append("		WHERE ACCOUNT_NUMBER = ? 									");
			sql.append("  		OR ACCOUNT_NUMBER = SUBSTR(?, 0, 4)||'-'||SUBSTR(?, 5, 4)   ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, withdraw);
			pstmt.setString(2, accountNo);
			pstmt.setString(3, accountNo);
			pstmt.setString(4, accountNo);

			pstmt.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException se) {
			System.out.println("잔액이 부족합니다");
		} catch (Exception e) {
			AutoCommit.connRollback(conn);
		} finally {
			AutoCommit.setAutoCommit(conn);
			JDBCClose.close(conn, pstmt);
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 이체////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////

	public void transferAccount(String oppAccountNo, String myAccountNo, int money) {

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" UPDATE ACCOUNT 													");
			sql.append("		SET BALANCE = (BALANCE - ?)									");
			sql.append("		WHERE ACCOUNT_NUMBER = ? 									");
			sql.append("  		OR ACCOUNT_NUMBER = SUBSTR(?, 0, 4)||'-'||SUBSTR(?, 5, 4)   ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, money);
			pstmt.setString(2, myAccountNo);
			pstmt.setString(3, myAccountNo);
			pstmt.setString(4, myAccountNo);
			pstmt.executeUpdate();

			StringBuilder sql2 = new StringBuilder();

			sql2.append(" UPDATE ACCOUNT 													");
			sql2.append("		SET BALANCE = (BALANCE + ?)									");
			sql2.append("		WHERE ACCOUNT_NUMBER = ? 									");
			sql2.append("  		OR ACCOUNT_NUMBER = SUBSTR(?, 0, 4)||'-'||SUBSTR(?, 5, 4)   ");

			pstmt2 = conn.prepareStatement(sql2.toString());
			pstmt2.setInt(1, money);
			pstmt2.setString(2, oppAccountNo);
			pstmt2.setString(3, oppAccountNo);
			pstmt2.setString(4, oppAccountNo);
			pstmt2.executeUpdate();

			System.out.println("송금을 완료했습니다");
		} catch (SQLIntegrityConstraintViolationException se) {
			System.out.println("잔액이 부족합니다");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);

		}
	}
}
