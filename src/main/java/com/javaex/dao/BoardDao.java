package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;

	// 리스트
	public List<BoardVo> getBoardList() {
		System.out.println("BoardDao>list()");

		List<BoardVo> boardList = sqlSession.selectList("board.selectList");
		System.out.println(boardList);

		return boardList;
	}

	// 글쓰기
	public int write(BoardVo boardVo) {
		System.out.println("BoardDao>write()");
		
		return sqlSession.insert("board.insert", boardVo);

	}
	
	// 읽기
	public BoardVo read(int no) {
		System.out.println("BoardDao>read()");
		
		return sqlSession.selectOne("board.read", no);
	}
	
	//조회수
	public int hitUp(int no) {

		return sqlSession.update("board.hit", no);

	}
	
	// 수정
	public int modify(BoardVo boardVo) {
		System.out.println("BoardDao>modify()");

		return sqlSession.update("board.modify", boardVo);

	}
	
	// 삭제
	public int delete(int no) {
		System.out.println("BoardDao>delete()");
		
		int count = sqlSession.delete("board.delete", no);

		return count;
	}
}