package kr.ac.kopo.account.ui;

// exception 처리를 위한 것. 
// 각 객체별로 예외처리를 매번 해주는 번거로움 덜기 위해 다중 상속을 지원하는 interface로 만들어준다
public interface IAccountUI {
	
	void execute() throws Exception;
}
