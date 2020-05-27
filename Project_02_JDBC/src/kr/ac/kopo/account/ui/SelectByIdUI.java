package kr.ac.kopo.account.ui;

import java.util.List;
import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.user.dao.UserDAO;

public class SelectByIdUI extends BaseAccUI {

	@Override
	public void execute() throws Exception {
		String id = UserDAO.usvo.getId();

		List<AccountVO> list = accountService.selectAllAccountById(id);

		System.out.println("=======================================================================");
		System.out.println("ID\t이름\t은행코드\t은행명\t계좌번호\t\t별칭\t\t잔액");
		System.out.println("=======================================================================");
		if (list.isEmpty()) {
			System.out.println("\t등록된 계좌가 없습니다");
		} else {
			for (AccountVO account : list) {
				System.out.println(account.getId() + "\t" + account.getName() + "\t" + account.getBankCode() + "\t"
						+ account.getBankName() + "\t" + account.getAccountNo() + "\t" + account.getAccountNickname()
						+ "\t\t" + account.getBalance());
			}
		}
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\t전체 계좌조회 완료!!");
		System.out.println();
	}

}
