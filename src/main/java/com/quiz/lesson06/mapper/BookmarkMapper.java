package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.Bookmark;

@Mapper
public interface BookmarkMapper {

	public void insertBookmark (
			@Param("name")String name
			,@Param("url") String url);
	
	public List<Bookmark> selectBookmark();
		
	// input:url  output:List<Bookmark>
	public List<Bookmark> selectBookmarkListByUrl(String url);
	
	public int deleteBookmarkById(int id);
}
