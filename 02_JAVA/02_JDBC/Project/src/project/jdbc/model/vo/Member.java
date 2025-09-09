package project.jdbc.model.vo;

public class Member {
	private String userId;
	private String userPwd;
	private String userName;
	private String myTeam;
	
	public Member() {
		super();
	}
	
	public Member(String userId, String userPwd, String userName, String myTeam) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.myTeam = myTeam;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(String myTeam) {
		this.myTeam = myTeam;
	}

	@Override
	public String toString() {
		return "회원정보 : "  + "userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", myTeam=" + myTeam;
	}
	
}
