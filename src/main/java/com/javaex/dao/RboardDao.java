package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.RboardVo;

@Repository
public class RboardDao {

	@Autowired
	private SqlSession sqlSession;

	// 리스트
	public List<RboardVo> getRboardList() {
		System.out.println("RboardDao>list()");

		List<RboardVo> rboardList = sqlSession.selectList("board.selectList");
		System.out.println(rboardList);

		return rboardList;
	}

	// 글쓰기
	public int write(RboardVo rboardVo) {
		System.out.println("RboardDao>write()");

		return sqlSession.insert("board.insert", rboardVo);

	}

	// 읽기
	public RboardVo read(int no) {
		System.out.println("RboardDao>read()");

		return sqlSession.selectOne("board.read", no);
	}

	// 조회수
	public int hitUp(int no) {

		return sqlSession.update("board.hit", no);

	}

	// 수정
	public int modify(RboardVo rboardVo) {
		System.out.println("RboardDao>modify()");

		return sqlSession.update("board.modify", rboardVo);

	}

	// 삭제
	public int delete(int no) {
		System.out.println("RboardDao>delete()");

		int count = sqlSession.delete("board.delete", no);

		return count;
	}
	
	// 댓글
		public int  commentWrite(RboardVo rboardVo) {
			System.out.println("RboardDao> commentWrite()");

			return sqlSession.insert("board.insert", rboardVo);

		}
}