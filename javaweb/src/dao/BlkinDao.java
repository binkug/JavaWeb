package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import domain.Blkin;

public class BlkinDao {

	// 데이터베이스 연동에 필요한 변수
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BlkinDao() {
		// 드라이버 클래스 로드
		// 한번만 수행하면 되기 때문에 생성자에 작성

		  try { 
			  
			  Class.forName("com.mysql.jdbc.Driver"); 
		  } catch (Exception e) {
			  
			  System.out.println(e.getMessage()); 
			  e.printStackTrace(); }

	}

	private static BlkinDao blkinDao;

	public static BlkinDao sharedInstance() {
		if (blkinDao == null) {
			blkinDao = new BlkinDao();
		}
		return blkinDao;
	}

	// 연결 메소드와 해제 메소드
	// 연결과 해제는 모든 곳에서 사용 되는 부분이므로 중복해서 코딩하지 않으려고 별도의 메소드로 작성
	// 이 메소드는 코드의 중복을 회피 하려고 만든 메소드 이므로 private,으로 생성해서 외부에서 호출되지 못하도록 생성
	private void connect() {
		/*try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/baek?userUnicode=true&characterEncoding=utf8", "root", "123456789");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}*/
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/DBConn");
			con = ds.getConnection();

			} catch (Exception e) {
			System.out.println(e.getMessage());

			}
	}

	// 데이터베이스 연결 객체를 정리 해주는 메소드
	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("데이터베이스 종료 실패");
			System.err.println(e.getMessage());

		}
	}
	public List<Blkin> list(){
		System.out.println("3");
		List<Blkin> list = new ArrayList<Blkin>();
		connect();
		//예외 처리를 하지 않아도 되는 구문이더라도 개발을 할 때는 하는 것이 좋습니다.
		//예외가 발생 했을 때 발생한 지점이나 오류를 빨리 해석할 수 있기 때문입니다
		try {
			//sql을 작성 - 입력 받는 데이터는 ?로 작성
			pstmt = con.prepareStatement("select * from member");
			
			//필요한 파라미터 매핑 - ?가 있으면 매핑
			
			//sql 실행
			rs = pstmt.executeQuery();
			//여러 행이 리턴되면 while - 1개의 행이 리턴되면 if
			while (rs.next()) {
				//List에 한개의 행 객체 생성
				Blkin blkin = new Blkin();
				//값 채워넣기
				blkin.setMember_num(rs.getInt("Member_num"));
				blkin.setMember_name(rs.getString("member_name"));
				blkin.setMember_email(rs.getString("member_email"));
				blkin.setMember_birthday(rs.getDate("member_birthday"));
				blkin.setMember_gender(rs.getString("member_gender"));
				//리스트에 삽입
				list.add(blkin);
				System.out.println("dao: "+blkin);
				
			}
			//결과 사용
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		close();
		System.out.println("dao : "+list);
		return list;
	}
	//가장큰 글 번호
	public int maxNum() {
		int result = 0;
		connect();
		try {
			pstmt = con.prepareStatement("select max(member_num) from member ");
			//sql 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("max(member_num)");
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		close();
		return result;
	}
	public Blkin detail(int member_num){
		//이 구문이 안 보이면 메소드 호출을 잘못한 것 - Service에서
		//메소드 이름을 확인
		System.out.println("5:" + "DAO 호출");
		Blkin blkin = null;
		connect();
		try {
			//sql 생성
			pstmt = con.prepareStatement("select * from member where member_num = ?");
			//sql 실행 및  ?에 바인딩 하기
			pstmt.setInt(1, member_num);
			//이 구문이 나오지 않으면 예외가 발생
			//sql이 잘못되었거나 ?에 값을 제대로 바인딩하지 않음
			System.out.println("6 :"+"SQL 확인");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				blkin = new Blkin();
				blkin.setMember_num(rs.getInt("member_num"));
				blkin.setMember_email(rs.getString("member_email"));
				blkin.setMember_gender(rs.getString("member_gender"));
				blkin.setMember_name(rs.getString("member_name"));
				blkin.setMember_birthday(rs.getDate("member_birthday"));
				blkin.setMember_content(rs.getString("member_content"));
			}
			//이 구문이 안나오면 컬럼 이름이 틀렸거나 형 변환 실패
			//String으로 변환 하는 것은 무조건 가능
			System.out.println("7: SQL 결과 확인");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		close();
		return blkin;
		
	}
	
	public int insert(Blkin blkin) {
		//-1로 초기화 해서 -1이 리턴되면 작업 실패
		int result = -1;
		connect();
		try {
			pstmt = con.prepareStatement("insert into member(member_num, member_email, member_password,"
					+ " member_gender, member_name) values (?,?,?,?,?)");
			
			// ?에 값을 바인딩하기
			pstmt.setInt(1, blkin.getMember_num());
			pstmt.setString(2, blkin.getMember_email());
			pstmt.setString(3, blkin.getMember_password());
			pstmt.setString(4, blkin.getMember_gender());
			pstmt.setString(5, blkin.getMember_name());
			
			//sql 실행
			result = pstmt.executeUpdate();
			System.out.println("dao : "+result);
		}catch(Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		close();
		return result;
	}
	public int update(Blkin blkin) {
		int result = -1;
		connect();
		try {
			pstmt = con.prepareStatement("update member set member_name = ?,member_content = ? where member_num = ?");
			
			//?에 값을 바인딩 하기
			pstmt.setString(1, blkin.getMember_name());
			pstmt.setString(2, blkin.getMember_content());
			pstmt.setInt(3, blkin.getMember_num());
			
			//sql 실행
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		close();
		return result;
	}
	public int delete(int member_num) {
		int result = -1;
		connect();
		try {
			
			pstmt = con.prepareStatement("delete from member where member_num = ?");
			
			pstmt.setInt(1,member_num);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
		
	}
	public int getCount() {
		int result = 0;
		connect();
		try {
			//sql 생성
			pstmt = con.prepareStatement("select count(*) from member");
			//sql 실행
			rs = pstmt.executeQuery();
			//결과를 저장
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		close();
		return result;
		
	}
	
	//페이지 번호와 페이지당 데이터 개수를 입력 받아서 페이지 번호에 해당하는 데이터만 리턴해주는 메소드

	public List<Blkin> list(int pageno, int perpagecnt){
		List<Blkin> list = new ArrayList<Blkin>();
		connect();
		try {
			pstmt = con.prepareStatement("select * from user limit ?,?");
			//데이터 시작번호는 페이지번호-1 에 데이터개수를 곱한것
			pstmt.setInt(1, (pageno-1)*perpagecnt);
			//가져올 데이터 개수는 페이지당 출력 할 데이터 개수
			pstmt.setInt(2,  perpagecnt);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Blkin blkin = new Blkin();
				blkin.setMember_num(rs.getInt("member_num"));
				blkin.setMember_email(rs.getString("member_email"));
				blkin.setMember_gender(rs.getString("member_gender"));
				blkin.setMember_name(rs.getString("member_name"));
				blkin.setMember_birthday(rs.getDate("member_birthday"));
				blkin.setMember_content(rs.getString("member_content"));
				
				list.add(blkin);
				System.out.println(blkin);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		close();
		return list;
	}
	
}
