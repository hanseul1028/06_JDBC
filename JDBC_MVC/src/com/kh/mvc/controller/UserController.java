package com.kh.mvc.controller;

import java.util.List;

import com.kh.mvc.model.dao.UserDAO;
import com.kh.mvc.model.dto.UserDTO;
import com.kh.mvc.model.service.MemberService;

/*
 * VIEW에서 온 요청을 처리해주는 클래스
 * 메소드로 전달된 데이터 값을 가공처리 한 후 DAO로 전달
 * DAO로부터 반환받은 결과를 사용자가 보게 될 View (응답화면)에 반환
 */
public class UserController {

	private UserDAO userDAO = new UserDAO();
	private MemberService userService = new MemberService(); 
		
		public List<UserDTO> findAll(){
			 //List<UserDTO> list = userDAO.findAll();
	    // 들고온 이유? view에 보내주기 위함

	    // 컨트롤럴와 DAO 사이에 중간다리를 만들어 주겠다
			return userService.findAll();
		
	}
	
	public int insertUser(String userId, String userPw, String userName) {
		 // requestParameter 매개변수
    // userView에 있는 insertUser에 담은 주소값을 담는 변수
		UserDTO user = new UserDTO();
		user.setUserId(userId);
		user.setUserPw(userPw);
		user.setUserName(userName);
		
		int result =  userDAO.insertUser(user);
		user = null;
		return result;
	}
	
	public int updatePassword(String userId, String userPw, String newUserPw) {
		
		UserDTO user = new UserDTO();
		user.setUserId(userId);
		user.setUserPw(newUserPw);
		
		int result = userDAO.updatePassword(user);
		return result;
		
	}
	
}
























