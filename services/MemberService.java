package com.bitcamp.services;
import java.lang.reflect.Member;

import com.bitcamp.domains.MemberBean;;
public class MemberService {
	
	private MemberBean[] members;
	private int count;
	private String[] arr =null;
	public MemberService() {
		members = new MemberBean[6];
		count =0;
	}
	public String join(MemberBean param) {
		String msg ="가입완료";
		members[count] = param;
		count ++;
		return msg;
	}
	public String Mypage(MemberBean param) {
		return param.toString();
	}
	
	public String changePw(MemberBean param) {
		String msg="다시입력";
		String pw = param.getPw();
		String[]pws= pw.split(",");
		String currPw = pws[0];
		String newPw = pws[1];
		for(int i=0; i<count; i++) {
			if(param.getId().equals(members[i].getId())&&
					currPw.equals(members[i].getPw())) {
				msg ="변경완료";
				members[i].setPw(newPw);
				break;
			}
		}
		return msg;
	}
	
	public String availability(String id) {
		String msg ="아이디 사용 가능";
		for(int i=0; i<count; i++) {
			if(id.equals(members[i].getId())) {
				msg ="아이디 사용 불가능";
				break;
			}
		}
		return msg;
	}
	
	public String login(MemberBean param) {
		String msg="로그인 실패";
		for(int i=0; i<count; i++) {
			if(param.getId().equals(members[i].getId())
					&& param.getPw().equals(members[i].getPw())) {
				msg ="로그인 성공";
				break;
			}
		}
		return msg;
	}
	//관리자-----------------------------------------
	//1.회원목록
	public String list() {
		String msg="";
		for(int i=0; i<count; i++) {
			msg += members[i].toString()+"\n";
		}
		return msg; 
	}
	//2.아이디검색
	public String searchbyId(String id) {
		String msg="검색하는 아이디가 없습니다.";
		for(int i=0; i<count; i++) {
			if(id.equals(members[i].getId())) {
				msg = members[i].toString();
				break;
			}
		}
		return msg;
	}
	//3.이름검색
	public MemberBean[] searchbyName(String name) {
		int num =0;
		for(int i=0; i<count; i++) {
			if(name.equals(this.members[i].getName())) {
				num ++;
			}
		}
		MemberBean[] members = new MemberBean[num];
		num =0;
		for(int i=0; i<count; i++) {
			if(name.equals(this.members[i].getName())) {
				members[i] = this.members[i];
				num++;
				if(members.length == num) {
					break;
				}
			}
		}
		
		return members;
	}
	//4.전체 회원수
	public String allMember() {
		return "전체회원:"+count;
	}
	
	
	
}
