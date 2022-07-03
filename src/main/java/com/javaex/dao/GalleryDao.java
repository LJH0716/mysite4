package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {

	@Autowired
	private SqlSession sqlSession;

	// 리스트
	public List<GalleryVo> getgalleryList() {
		System.out.println("GalleryDao>list()");

		List<GalleryVo> galleryList = sqlSession.selectList("gallery.selectList");
		System.out.println(galleryList);

		return galleryList;
	}

	// 파일 저장
	public int save(GalleryVo galleryVo) {

		System.out.println("GalleryDao>save()");

		return sqlSession.insert("gallery.insert", galleryVo);

	}

	// 사진 삭제
	public int delete(GalleryVo galleryVo) {
		System.out.println("GalleryDao>delete()");

		return sqlSession.delete("gallery.delete", galleryVo);
	}

}
