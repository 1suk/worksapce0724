package project.jdbc.controller;

import java.util.List;

import project.jdbc.model.vo.Match;
import project.jdbc.model.vo.Member;
import project.jdbc.service.MatchService;
import project.jdbc.service.MemberService;

public class MemberController {
	private MemberService ms;
	private MatchService mts;
	
	public MemberController() {
		super();
		this.ms = new MemberService();
		this.mts = new MatchService();
	}
	
	public void joinMember(String userId, String userPwd, String userName, String myTeam) {
		Member m = new Member(userId, userPwd,userName,myTeam);
		
		int result = ms.joinMember(m);
		 
		 if(result > 0) {
	            System.out.println("회원가입 성공!!");
	        } else {
	            System.out.println("회원가입 실패!!");
	        }
	}
	
	 public List<Match> getMyTeamMatches(Member m) {
	        String myTeam = m.getMyTeam();
	        return mts.selectMatchesByTeam(myTeam);
	 }

	public Member login(String userId, String userPwd) {
		return ms.login(userId, userPwd);
	}
}
