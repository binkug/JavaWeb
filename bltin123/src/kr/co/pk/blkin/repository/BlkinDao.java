package kr.co.pk.blkin.repository;


public class BlkinDao {
	//싱글톤 패턴으로 만들기 위한 코드
	private BlkinDao() {}
	private static BlkinDao blkinDao;
	public static BlkinDao sharedInstance() {
		if(blkinDao == null) {
			blkinDao = new BlkinDao();
		}
		return blkinDao;
	}
	
	public void create() {
		System.out.println("dao에서 데이터 저장");
	}
	public void read() {
		
		System.out.println("dao에서 데이터 가져오기");
	}
	public void update() {
		System.out.println("dao에서 업데이터 수정");
	}
	public void delete() {
		System.out.println("dao에서 데이터 삭제");
	}
	


}
