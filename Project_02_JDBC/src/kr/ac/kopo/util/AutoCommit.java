package kr.ac.kopo.util;

import java.sql.Connection;

public class AutoCommit {
	public static void setAutoCommit(Connection conn) {
		if(conn != null) {
			try {
				conn.setAutoCommit(true);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void connRollback(Connection conn) {
		if(conn != null) {
			try {
				conn.rollback();
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("예기치 못한 에러가 발생했습니다");
			}
		}
	}
}
