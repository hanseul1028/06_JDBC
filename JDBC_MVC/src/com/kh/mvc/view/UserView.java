package com.kh.mvc.view;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Properties;

import com.kh.mvc.controller.UserController;
import com.kh.mvc.model.dto.UserDTO;

/**
 * MemberView 클래스는 JDBC 실습을 위해 생성하였으며, 
 * 사용자에게 입력 및 출력을 수행하는 메서드를 제공합니다.
 * 
 * @author	: 종로 c 강의장
 * @version : 0.1
 * @date 		: 2025-03-04
 * 
 */

public class UserView {
	
	private Scanner sc = new Scanner(System.in);
	private UserController userController = new UserController();
	
	
	/*
	 *  프로그램 시작 시 사용자에게 보여불 메인화면을 출력해주는 메서드입니다.
	 */
	public void mainMenu() {
		
		while(true) {
		System.out.println("--- USER 테이블 관리 프로그램 ---");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 추가");
		System.out.println("3. 비밀번호 수정");
		System.out.println("4. 회원 삭제");
		System.out.println("5. 회원번호로 단일 회원 조회");
		System.out.println("6. 회원 아이디 검색으로 조회");
		
		System.out.println("9. 프로그램 종료");
		System.out.print("이용할 메뉴를 선택해주세요");
		
		int menuNo = 0;
		
		 try{
       menuNo = sc.nextInt();
     } catch(InputMismatchException e){
       sc.nextLine();
       continue;
     }
		
		sc.nextLine();
		
		switch(menuNo) {
		case 1 : findAll(); break;
		case 2 : insertUser(); break;
		case 3 : updatePassword(); break;
		case 9 : System.out.println("프로그램 종료"); return;
		default : System.out.println("잘못된 메뉴 선택입니다.");

		  }
		}
	}
	
	// 1. 회원 전체 정보를 조회해주는 기능
	private void findAll() {
		
		System.out.println("\n --- 회원 전체 목록 ---");
		// Controller가 DB에서 회원 전체 목록을 가져옴
		List<UserDTO> list = userController.findAll();
		
		System.out.println("\n조회된 총 회원의 수는 " + list.size() + " 명 입니다.");
		
	
		/*조건식 사용법*/
	  if(!(list.isEmpty())){ // == list.size()
	
	    System.out.println("================================");
	    for(UserDTO user : list){
	      System.out.print(user.getUserName() + "님의 정보 !");
	      System.out.print("\n아이디 : " + user.getUserId());
	      System.out.print("\t가입일 : " + user.getEnrollDate());
	      System.out.println();
	    }
	    System.out.println("================================");
	
	  } else{
	    System.out.println("회원이 존재하지 않습니다.");
	  }

}
	
	/*
	 * 2. TB_USER에 INSERT할 값을 사용자에게 입력받도록 유도하는 화면
	 */
	private void insertUser() {
		
		System.out.println("---  회원 추가 페이지입니다. ---");
		
		System.out.print("아이디를입력하세요 ");
		String userId = sc.nextLine();
		
		// UNIQUE했다고 치고 입력받은 아이디 가지고 DB가서 WHERE 조건절에다가 사용자가 입력한
		// 아이디 넣어서 조회결과 확인
		
		
		System.out.print("비밀번호를 입력하세요");
		String userPw = sc.nextLine();
		
		System.out.print("이름을 입력하세요");
		String userName = sc.nextLine();
		
		int result = userController.insertUser(userId, userPw, userName);
		
		if(result > 0 ) {
			System.out.println(userName + "님 가입에 성공하셨습니다");
		}else {
			System.out.println("회원 추가에 실패했습니다. 다시 시도해주세요");
		}
	}
	
	/*
	 * 3. 비밀번호 수정
	 */
	
	private void updatePassword() {
		
		System.out.println("--- 비밀번호 변경 페이지입니다 ---");
		
		System.out.print("아이디를입력하세요 ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호를 입력하세요");
		String userPw = sc.nextLine();
		
		int result = userController.updatePassword(userId, userPw);

		if (result > 0) {
			
			System.out.print("새 비밀번호를 입력하세요");
			String newUserPw = sc.nextLine();
		}else {
			System.out.println("회원 정보가 틀렸습니다. 다시 시도해주세요");
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}






























