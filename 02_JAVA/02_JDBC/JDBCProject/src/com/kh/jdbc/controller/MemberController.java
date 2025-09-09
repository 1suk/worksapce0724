package com.kh.jdbc.controller;

import java.util.List;
import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.view.MemberMenu;

public class MemberController {
   private MemberDao md = new MemberDao();

   public MemberController() {
      super();
      this.md = new MemberDao();
   }

   // 회원 추가
   public void insertMember(String userId, String userPwd, String userName, String gender, int age, 
                            String email, String phone, String address, String hobby) {

      Member m = new Member(userId, userPwd, userName, gender, age, email, phone, address, hobby);

      int result = md.insertMember(m);

      if(result > 0) {
         // View 호출
         new MemberMenu().displaySuccess("성공적으로 회원이 추가되었습니다.");
      } else {
         new MemberMenu().displayFail("회원 추가에 실패하였습니다.");
      }
   }

   // 전체 회원 조회
   public void selectMemberAll() {
      List<Member> list = md.selectMemberList();

      if(list.isEmpty()) {
         new MemberMenu().displayNoData("회원 목록 조회 결과가 없습니다.");
      } else {
         new MemberMenu().displayList(list, "회원 목록");
      }
   }

   // 회원 정보 수정
   public void updateMember(String userId, String email, String phone, String address, String hobby) {
      Member m = new Member();
      m.setUserId(userId);
      m.setEmail(email);
      m.setPhone(phone);
      m.setAddress(address);
      m.setHobby(hobby);

      int result = md.updateMember(m);

      if(result > 0) {
         new MemberMenu().displaySuccess("성공적으로 회원정보를 수정하였습니다.");
      } else {
         new MemberMenu().displayFail("회원정보 수정에 실패하였습니다.");
      }
   }
   
   public void deleteMember(String userId, String userPwd) {
	   Member m = new Member();
	   m.setUserId(userId);
	   m.setUserPwd(userPwd);
	   
	   int result = md.deleteMember(m);

	      if(result > 0) {
	         new MemberMenu().displaySuccess("성공적으로 회원정보를 삭제하였습니다.");
	      } else {
	         new MemberMenu().displayFail("회원정보 삭제에 실패하였습니다.");
	      }
	   }
}
