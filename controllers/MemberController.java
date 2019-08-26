package com.bitcamp.controllers;
import javax.swing.JOptionPane;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;
public class MemberController {
	public static void main(String[] args) {
		String temp ="";
		String[] arr = null;
		MemberBean member = null;
		MemberService service = new MemberService();
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료\n"
					+ "1.회원가입\n"
					+ "2.마이페이지\n"
					+ "3.비번수정\n"
					+ "4.회원탈퇴\n"
					+ "5.아이디가능여부\n"
					+ "6.로그인\n"
					+ "7.회원목록\n"
					+ "8.아이디검색\n")) {
			case "0": JOptionPane.showMessageDialog(null, "종료");
				return;
			case "1": //회원가입 id, pw, name, ssn, blood, height, weight
				temp = JOptionPane.showInputDialog("아이디,비번,이름,주민등록앞자리,혈액형,키,몸무게");
				arr = temp.split(",");
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPw(arr[1]);
				member.setName(arr[2]);
				member.setSsn(arr[3]);
				member.setBlood(arr[4]);
				member.setHeight(Double.parseDouble(arr[5]));
				member.setWeight(Double.parseDouble(arr[6]));
				JOptionPane.showMessageDialog(null,service.join(member));
				break;
			case "2": //마이페이지
				JOptionPane.showMessageDialog(null, service.Mypage(member));
				break;
			case "3": //비번수정
				temp = JOptionPane.showInputDialog("아이디, 현재비번, 새로운비번 입력");
				arr = temp.split(",");
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPw(arr[1]+","+arr[2]);
				JOptionPane.showMessageDialog(null,service.changePw(member));
				
				
				break;
			case "4": //회원탈퇴
				temp = JOptionPane.showInputDialog("비밀번호입력 하시면 회원탈퇴");
				member.setPw(temp);
				JOptionPane.showMessageDialog(null, service.deleteAcc(member));
				break;
			case "5": //아이디가능여부
				String id =JOptionPane.showInputDialog("아이디입력");
				JOptionPane.showMessageDialog(null, service.availability(id));
				break;
			case "6": //로그인 
				temp = JOptionPane.showInputDialog("아이디,비번 입력");
				arr = temp.split(",");
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPw(arr[1]);
				JOptionPane.showMessageDialog(null, service.login(member));
				break;
			case "7"://회원목록
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case "8"://아이디검색
				temp = JOptionPane.showInputDialog("찾고싶은 아이디 입력");
				JOptionPane.showMessageDialog(null, service.searchbyId(temp));
				break;
			case "9"://이름검색
				temp = JOptionPane.showInputDialog("이름 검색");
				JOptionPane.showMessageDialog(null, service.searchbyName(temp));
				break;
			case "10"://전체회원
				JOptionPane.showMessageDialog(null, service.allMember());
				break;
			}
		}
	}
}
