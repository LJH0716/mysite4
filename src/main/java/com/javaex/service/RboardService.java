package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.RboardDao;
import com.javaex.vo.BoardVo;
import com.javaex.vo.RboardVo;

@Service
public class RboardService {

	// 필드
	@Autowired
	private RboardDao rboardDao;

	// 리스트
	public List<RboardVo> getList() {
		System.out.println("RboardService > getList");

		List<RboardVo> rboardList = rboardDao.getRboardList();
		System.out.println(rboardList);
		return rboardList;
	}

	// 글쓰기
	public int write(RboardVo rboardVo) {

		System.out.println("RboardService>write()");
		int count = rboardDao.write(rboardVo);

		return count;
	}

	// 읽기
	public RboardVo read(int no) {

		System.out.println("RboardService>read()");
		return rboardDao.read(no);
	}

	// 조회수
	public int hitUp(int no) {

		System.out.println("RboardService>hitUp()");

		return rboardDao.hitUp(no);
	}

	// 수정
	public int modify(RboardVo rboardVo) {

		System.out.println("RboardService>modify()");
		int count = rboardDao.modify(rboardVo);

		return count;

	}

	// 삭제
	public int delete(int no) {

		System.out.println("RboardService>delete()");
		int count = rboardDao.delete(no);

		return count;
	}
	
	// 댓글
		public int commentWrite(RboardVo rboardVo) {

			System.out.println("RboardService> commentWrite()");
			int count = rboardDao.commentWrite(rboardVo);

			return count;

		}
}
