package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;
	// 생성자- 디폴트 생성자

	// 메소드 gs

	// 메소드 일반

	// 1명 정보 가져오기(회원 정보 수정용)
	public UserVo getUserOne(int no) {
		System.out.println("UserDao.getUserOne()");

		UserVo authUser = sqlSession.selectOne("users.getUserOne", no);

		return authUser;
	}
	
	// 회원정보 수정
	public int userModify(UserVo userVo) {
		System.out.println("UserDao.userModify()");

		int count = sqlSession.update("users.modify", userVo);

		return count;
	}
	
	// 회원 정보 가져오기(로그인용)
	public UserVo getUser(UserVo userVo) {
		System.out.println("UserDao.getUser()");

		UserVo authUser = sqlSession.selectOne("users.getUser", userVo);

		return authUser;
	}

	// 회원정보 저장(회원가입)
	public int userInsert(UserVo userVo) {
		System.out.println("UserDao.userInsert()");

		int count = sqlSession.insert("users.insert", userVo);

		return count;
	}

}