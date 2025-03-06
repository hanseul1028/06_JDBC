package com.kh.mvc.run;

import com.kh.mvc.view.UserView;

public class Run {
	
	public static void main(String[] args) {
		
			/* Model			: 데이터 관련된 모든 작업
			 * View 			: 화면 상 입/출력
			 * Controller : View에서의 요청을 받아서 처리해주는 역할
			 */
		
		/* [MVC]
	    * Model : 데이터와 관련된 모든 작업
	    * View : 화면 입 / 출력(얘는 아직 힘 안줄 것, html로 바껴야할 부분이니)
	    * Controller : View 에서의 요청을 받아서 처리해주는 역할
	    * */
			
		new UserView().mainMenu();
		
		
	}
}
