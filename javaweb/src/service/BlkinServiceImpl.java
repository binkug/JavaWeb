package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlkinDao;
import domain.Blkin;

public class BlkinServiceImpl implements BlkinService {
	private BlkinDao blkinDao;
	
	private BlkinServiceImpl() {
		blkinDao = BlkinDao.sharedInstance();
	}
	
	private static BlkinService blkinService;
	
	public static BlkinService sharedInstance() {
		if(blkinService == null) {
			blkinService = new BlkinServiceImpl();
		}
		return blkinService;
	}

	@Override
	public void list(HttpServletRequest request, HttpServletResponse response) {
		//1.파라미터 읽기
		
		//페이지 번호와 페이지당 데이터 개수를 저장할 변수를 생성
		int pageno = 1;
		int perpagecnt = 3;
		//파라미터로 페이지 번호와 페이지 당 데이터 개수가 넘어오면 페이지 번호와 페이지 당 데이터 개수 변경
		String no = request.getParameter("no");
		String pagecnt = request.getParameter("pagecnt");
		
		if(no !=null) {
			pageno = Integer.parseInt(no);
		}
		if(pagecnt != null) {
			perpagecnt = Integer.parseInt(pagecnt);
		}
		//2.파라미터 변환 작업이나 알고리즘 처리
		
		//3.호출한 Dao 메소드의 매개변수를 생성
		
		//4.Dao의 메소드를 호출해서 결과를 저장
		List<Blkin> list = blkinDao.list(pageno,perpagecnt);
		System.out.println(list);
		
		//전체 데이터 개수를 가져오기
		int totalCount = blkinDao.getCount();
		//데이터 출력 화면에 표시할 마지막 페이지 번호 와 시작 페이지 번호를 생성
		//하나의 페이지에 페이지 번호를 3개씩 출력
		//종료 페이지 번호를 임시로 계산
		// 1 - 3, 2 - 3 , 12- 4 
		int endPage = (int)(Math.ceil(pageno/3.0)*3.0);
		int startPage = endPage - 2; 
		
		//전체 페이지 개수 구하기
		int tempEndPage = (int)(Math.ceil(totalCount/(double)perpagecnt));
			//끝나는 페이지 번호가 전체 페이지 개수보다 크면 끝나는 페이지 번호 수정
			if(endPage > tempEndPage) {
				endPage = tempEndPage;
			}
		
		//이전과 다음 출력 여부 생성
		boolean prev = startPage == 1 ? false : true;
		boolean next = endPage * perpagecnt >= totalCount ? false : true;
		//5.Dao 메소드 호출 결과를 View로 전달하기 위해서 request나 session에 저장
		
		//포워딩 할거면 request
		//리다이렉트 할 거면 session
		request.setAttribute("list", list);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageno", pageno);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		//전체 데이터 개수
		request.setAttribute("totalCount", totalCount);

	}

	@Override
	public void insert(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch(Exception e) {}
		//1.파라미터 읽기
		String member_email = request.getParameter("member_email");
		String member_name = request.getParameter("member_name");
		String member_password = request.getParameter("member_password");
		String member_gender = request.getParameter("member_gender");
		
		//2.파라미터를 가지고 필요한 작업 수행
		//가장큰 num을 찾아서 +1을 해서 member_num에 대입
		int member_num = blkinDao.maxNum()+1;
		//3.호출할 Dao 메소드의 매개변수를 생성
		Blkin blkin = new Blkin();
		blkin.setMember_num(member_num);
		blkin.setMember_email(member_email);
		blkin.setMember_name(member_name);
		blkin.setMember_password(member_password);
		blkin.setMember_gender(member_gender);
		
		//4.DAO 메소드를 호출
		int result = blkinDao.insert(blkin);
		System.out.println("serviceImpl : "+result);
		//5.결과를 저장
		request.getSession().setAttribute("result", result);
	}

	@Override
	public void detail(HttpServletRequest request, HttpServletResponse response) {
		//서비스를 호출하는지 확인
		//이 코드가 호출하지 않으면 Controller에서 메소드 잘못 호출
		System.out.println("3: "+ "서비스 호출");
		//1.파라미터 읽기
		/*
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		String member_num = request.getParameter("member_num").trim(); */
		
		//2.파라미터를 가지고 일반적인 처리
		
		//URL에서 가장 마지막 부분 가져오기
		//http://localhost:8080/javaweb/blkin/detail/7
		String [] ar = request.getRequestURI().split("/");
		String member_num = ar[ar.length-1];
		//3.호출한 Dao 메소드의 매개변수를 생성
		int c = Integer.parseInt(member_num);
		//이 코드가 제대로 호출되지 않으면
		//파라미터를 읽는 부분이나 비지니스 로직 처리에 문제가 발생
		System.out.println("4:" + "파라미터 확인");
		//4.Dao의 메소드를 호출해서 결과를 저장
		Blkin blkin = blkinDao.detail(c);
		//DAO가 결과를 제대로 리턴하는지 확인
		System.out.println("8:"+blkin);
		//5.이동 방법에 따라 사용할 데이터를 저장
		request.setAttribute("blkin", blkin);
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch(Exception e) {}
		//1.파라미터 읽기
		String member_name = request.getParameter("member_name");
		String member_content = request.getParameter("member_content");
		String member_num = request.getParameter("member_num");
		
		Blkin blkin = new Blkin();
		blkin.setMember_num(Integer.parseInt(member_num));
		blkin.setMember_name(member_name);
		blkin.setMember_content(member_content);
		
		int result = blkinDao.update(blkin);
		//웹 사이트만 고려하면 저장할 필요가 없습니다.
		request.getSession().setAttribute("result", result);
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String [] ar = request.getRequestURI().split("/");
		String member_num = ar[ar.length-1];
		
		int result = blkinDao.delete(Integer.parseInt(member_num));
		
		request.getSession().setAttribute("result", result);
	}
}
