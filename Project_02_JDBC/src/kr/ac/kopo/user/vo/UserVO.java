package kr.ac.kopo.user.vo;

public class UserVO {

	private String id;
	private String password;
	private String name;

	public UserVO() {

	}

	public UserVO(String id2, String password2) {
		this.id = id2;
		this.password = password2;
	}

	public UserVO(String id2, String password2, String name2) {
		this.id = id2;
		this.password = password2;
		this.name = name2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id2) {
		this.id = id2;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password2) {
		this.password = password2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AccountVO [id=" + id + ", password=" + password + "]";
	}

}
