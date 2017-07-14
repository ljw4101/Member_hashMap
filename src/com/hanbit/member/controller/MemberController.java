//admin의 member관리

package com.hanbit.member.controller;

import java.util.List;
import javax.swing.JOptionPane;

import com.hanbit.member.constants.Butt;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;
import com.hanbit.member.serviceImpl.MemberServiceImpl;

public class MemberController {
	public static void main(String[] args){
		MemberBean member = null; //선언만
		MemberService service = new MemberServiceImpl();
		Butt[] buttons = {Butt.EXIT, Butt.ADD, Butt.LIST, Butt.FIND_NAME, Butt.FIND_ID, Butt.COUNT, Butt.UPDATE, Butt.DEL};

		do{
			flag:
			switch((Butt)JOptionPane.showInputDialog(
					null, 				//frame
					"MEMBER ADMIN",		//frame title
					"SELECT MENU",		//order
					JOptionPane.QUESTION_MESSAGE,	//type
					null,				//icon
					buttons,			//Array of choices
					buttons[1])){		//default
				case EXIT:
					JOptionPane.showMessageDialog(null, "Stop");
					return;
				case ADD:
					member = new MemberBean(); //초기화
					String[] arr = JOptionPane.showInputDialog("Id/Password/Name/SSN").split("/");
					member.setId(arr[0]);
					member.setPw(arr[1]);
					member.setName(arr[2]);
					member.setSSN(arr[3]);
					
					service.addMember(member);
					JOptionPane.showMessageDialog(null, "회원가입 성공");
					break flag;
				case COUNT:
					JOptionPane.showMessageDialog(null, service.countMembers());
					break flag;
				case LIST:
					JOptionPane.showMessageDialog(null, "리스트\n"+service.getMembers());
					break flag;
				case FIND_ID:
					JOptionPane.showMessageDialog(null, "회원정보\n"+service.findByID(JOptionPane.showInputDialog("Id를 입력하세요")));
					break flag;
				case FIND_NAME:
					JOptionPane.showMessageDialog(null, "리스트\n"+service.findByName(JOptionPane.showInputDialog("이름 입력하세요")));
					break flag;
				case UPDATE: 
					member = new MemberBean();
					String[] updateArr = JOptionPane.showInputDialog("Id/Password/Name/SSN").split("/"); 
					member.setId(updateArr[0]);
					member.setPw(updateArr[1]);
					member.setName(updateArr[2]);
					member.setSSN(updateArr[3]);
					
					service.upadtePw(member);
					JOptionPane.showMessageDialog(null, "비밀번호 변경 완료");
					break flag;
				case DEL:
					String id = JOptionPane.showInputDialog("삭제할 ID를 입력하세요");
					service.delMember(id);
					
					JOptionPane.showMessageDialog(null, "회원 삭제 완료");
					break flag;
			}
		} while(true);
	}
}
