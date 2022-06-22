package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	// 필드
	@Autowired
	private BoardDao boardDao;

	// 리스트
	public List<BoardVo> getList(){
		System.out.println("BoardService > getList");
		
		List<BoardVo> boardList = boardDao.getBoardList();
		System.out.println(boardList);
		return boardList;
	}
	
	// 글쓰기
	public int write(BoardVo boardVo) {

		System.out.println("BoardService>write()");
		int count = boardDao.write(boardVo);
		
		return count;
	}
	
	//읽기
	public BoardVo read(int no) {

		System.out.println("BoardService>read()");
		return boardDao.read(no);
	}
	
	//조회수
	public int hitUp(int no) {
		
		System.out.println("BoardService>hitUp()");
		
		return boardDao.hitUp(no);
	}
	
	//수정
	public int modify(BoardVo boardVo) {

		System.out.println("BoardService>modify()");
		int count = boardDao.modify(boardVo);
		
		return count;
	
	}
	
	// 삭제
	public int delete(int no) {
		
		System.out.println("BoardService>delete()");
		int count = boardDao.delete(no);
		
		return count;
	}
}
