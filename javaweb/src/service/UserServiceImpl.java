package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import dao.UserDao;
import domain.User;
import sun.net.www.protocol.http.HttpURLConnection;

public class UserServiceImpl implements UserService {
	
	//Service에서 사용할 UserDao 변수
	private UserDao userDao;

	
	private UserServiceImpl() {
		userDao = UserDao.sharedInstance();
	}

	private static UserService userService;

	public static UserService sharedInstance() {
		if (userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}

	@Override
	public void emailCheck(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("서비스까지 요청 도달");
		//1. 파라미터 읽기
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("service : "+e.getMessage());
			e.printStackTrace();
		}
		String userEmail = request.getParameter("useremail");
		//2.별도의 작업을 수행해야 하면 처리
		//암호화 , 파일 업로드 , 파라미터를 다른 자료형으로 변환
		//업무처리에 필요한 알고리즘
		
		//3.dao 작업이 필요하면 호출할 DAO 메소드의 매개변수를 생성
		
		//4.DAO의 메소드를 호출해서 결과를 변수에 저장
		boolean result = userDao.emailCheck(userEmail);
		//5.단순 웹페이지를 위한 서버의 경우는 결과들을 REQUEST 나 session에 저장
		//rest API 서버의 경우는 JSONObject 클래스의 객체를 만들어서 저장한 후  request에 저장한다.
		//웹페이지를 위한 로그인의 경우에만 session에 저장하던지 데이터베이스에 로그인 여부를 저장해 놓습니다.
		JSONObject object = new JSONObject();
		object.put("result", result);
		
		//request에 저장
		request.setAttribute("result", object);
		
		//기억해야 할 것은 파라미터 이름 (userEmail)
		//결과를 저장할 때 사용한 속성이름과 데이터
		//request 나 session에 저장한 이름
		
	}

	@Override
	public void nameCheck(HttpServletRequest request, HttpServletResponse response) {

		//1. 파라미터 읽기
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("service : "+e.getMessage());
			e.printStackTrace();
		}
		String userName = request.getParameter("username");
		//2.별도의 작업을 수행해야 하면 처리
		//암호화 , 파일 업로드 , 파라미터를 다른 자료형으로 변환
		//업무처리에 필요한 알고리즘
		
		//3.dao 작업이 필요하면 호출할 DAO 메소드의 매개변수를 생성
		
		//4.DAO의 메소드를 호출해서 결과를 변수에 저장
		boolean result = userDao.emailCheck(userName);
		//5.단순 웹페이지를 위한 서버의 경우는 결과들을 REQUEST 나 session에 저장
		//rest API 서버의 경우는 JSONObject 클래스의 객체를 만들어서 저장한 후  request에 저장한다.
		//웹페이지를 위한 로그인의 경우에만 session에 저장하던지 데이터베이스에 로그인 여부를 저장해 놓습니다.
		JSONObject object = new JSONObject();
		object.put("result", result);
		
		//request에 저장
		request.setAttribute("result", object);
		
		//기억해야 할 것은 파라미터 이름 (userEmail)
		//결과를 저장할 때 사용한 속성이름과 데이터
		//request 나 session에 저장한 이름
		
	}
	
	@Override
	public void register(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			//파라미터 읽기
			request.setCharacterEncoding("utf-8");
			String userEmail = request.getParameter("useremail");
			String userPassword = request.getParameter("userpassword");
			String userName = request.getParameter("username");
			String userGender = request.getParameter("usergender");

			//파일은 Part로 읽어냅니다.
			Part part = request.getPart("userimage");
			//파일명 가져오기
			//content-disposition 이라는 헤더의 값 이용
			String contentDisposition = part.getHeader("content-disposition");
			//form-data;image;"파일명" 의 형태의 문자열에서
			//파일명만 가져오기
			
			//;으로 분리
			String [] splitStr = contentDisposition.split(";");
			//첫번째 " 와 마지막 "의 위치를 찾음
			int first = splitStr[2].indexOf("\"");
			int last = splitStr[2].lastIndexOf("\"");
			//위치를 가지고 부분 문자열을 가져오기
			String uploadFileName = 
				splitStr[2].substring(first+1, last);
			
			String userImage = null;
			//위의 파일명에 내용이 없으면 파일을 선택하지 않은 것입니다.
			if(uploadFileName != null && uploadFileName.length() !=0) {
				//확장자 추출하기
				String [] imsi = uploadFileName.split("\\.");
				String ext = imsi[imsi.length - 1];
				
				//새로운 파일명 만들기
				userImage = UUID.randomUUID() + "." + ext;
				//파일 업로드 
				File f = new File("C:\\Users\\30404\\Desktop\\upload"+userImage);
				
				part.write(userImage);
			}
			
			//DAO 파라미터 만들기
			User user = new User();
			user.setUserEmail(userEmail);
//			user.setUserPassword(userPassword);
			//암호화해서 저장
			user.setUserPassword(BCrypt.hashpw(userPassword, BCrypt.gensalt()));
			user.setUserName(userName);
			user.setUserGender(userGender);
			user.setUserImage(userImage);
			
			//DAO 메소드 호출
			int result = userDao.register(user);
			
			//결과물을 저장
			JSONObject object = new JSONObject();
			if(result > 0) {
				object.put("result", true);
			}else {
				object.put("result", false);
			}
			
			request.setAttribute("result", object);
			
		}catch(Exception e) {
			System.out.println("service:" + e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("유저 서비스");
		//1.파라미터 읽기
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("service login:" + e.getMessage());
			e.printStackTrace();
		}
		String userEmail = request.getParameter("useremail");
		String userPassword = request.getParameter("userpassword");
		//2.필요한 처리
		
		//3.DAO 메소드를 호출해야 하면 DAO 메소드의 매개변수를 생성
		
		//4.DAO 메소드를 호출해서 결과를 저장
		User user = userDao.login(userEmail);
		//5.결과를 가지고 필요한 처리를 수행
		if(user != null) {
			//비밀번호 확인
			if(BCrypt.checkpw(userPassword, user.getUserPassword())) {
				//비밀번호가 일치하는 경우 - 비밀번호는 삭제
				user.setUserPassword(null);
			}else {
				//비밀번호가 틀린 경우 user == null;
				user = null;
			}
		}
		
		JSONObject object = new JSONObject();
		if(user != null) {
			object.put("usernum", user.getUserNum());
			object.put("useremail", user.getUserEmail());
			object.put("userpassword", user.getUserPassword());
			object.put("username", user.getUserName());
			object.put("userimage", user.getUserImage());
			object.put("usergender", user.getUserGender());
		}else {
			object = null;
		}
		//6.요청 처리 결과를 저장
		//System.out.println("t서비스 : "+object);
		request.getSession().setAttribute("result", object);
	}

	@Override
	public void proxy(HttpServletRequest request, HttpServletResponse response) {
		//Java Application에서 구현할 때는 Thread 안에 구현하고
		//Android Application에 구현할 때는 Thead 안에 구현하고
		//화면에 표시할 때는 Handler를 이용하거나 Thead와 Handler의 조합인 AsyncTask를 이용
		try {
			//데이터를 가져올 URL을 생성
			System.out.println("서비스");
			URL url = new URL("http://www.weather.go.kr/weather/forecast/mid-term-xml.jsp?stnld=109");
			//연결 객체를 생성
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			//옵션을 설정
			conn.setConnectTimeout(30000);
			conn.setUseCaches(false);
			//헤더 설정을 해야 하는 경우에는
			//conn.setRequestProperty("헤더이름", "헤더 값");
			
			//post 전송이면
			//conn.setRequestMethod("POST");
			
			//데이터 읽어오기
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				sb.append(line + "\n");
				//System.out.println(sb);
			}
			
			br.close();
			conn.disconnect();
			request.setAttribute("result", sb.toString());
		} catch (Exception e) {
			System.out.println("service proxy:" + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
