package com.naver.binkug.service;

import com.naver.binkug.dao.BoardDao;

public class BoardServiceImpl implements BoardService {
	//service에서 사용할 boardDao 변수
	private BoardDao boardDao;
	
	private BoardServiceImpl() {
		boardDao = BoardDao.sharedInstance();
	}
	
	private static BoardService boardService;
	
	public static BoardService sharedInstance(){
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		return boardService;
	}
	
	
}
