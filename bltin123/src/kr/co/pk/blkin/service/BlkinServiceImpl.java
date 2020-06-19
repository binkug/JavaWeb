package kr.co.pk.blkin.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pk.blkin.repository.BlkinDao;

public class BlkinServiceImpl implements BlkinService {
	
	private BlkinDao blinDao;
	private BlkinServiceImpl() {
		//Dao 인스턴스를 생성
		blinDao = BlkinDao.sharedInstance();
	}

	
	private static BlkinService blikinService;
	//인터페이스를 implements 한 경우 변수는 인터페이스 자료형으로 선언
	public static BlkinService sharedInstance() {
		if(blikinService == null) {
			blikinService = new BlkinServiceImpl();
		}
		return blikinService;
	}
	
	@Override
	public void create() {
		System.out.println("dao에서 데이터 저장");
		blinDao.create();
	}

	@Override
	public void read() {
		System.out.println("dao에서 데이터 가져오기");
		blinDao.read();
	}

	@Override
	public void update() {
		System.out.println("dao에서 업데이터 수정");
		blinDao.update();
	}

	@Override
	public void delete() {
		System.out.println("dao에서 데이터 삭제");
		blinDao.delete();
	}
	
	
	@Override
	public void login(HttpServletRequest request,HttpServletResponse response) {
		//1.파라미터 읽어오기
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		//2.필요한 작업이 있으면 수행
		
		//3.Dao 메소드를 호출해야 하는 경우 Dao 메소드의 
		//파라미터를 만들고 Dao 메소드를 호출 - 결과를 받기
		
		//4.결과를 사용 - 로그인 같은 경우는 성공했을 때 세션에
		//유저 정보를 저장
		System.out.println(email);
		request.getSession().setAttribute("email", email);
		request.getSession().setAttribute("nickname",
				"관리자");
	}
}
