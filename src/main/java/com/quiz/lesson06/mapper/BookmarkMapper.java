package com.quiz.lesson06.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkMapper {

	public void insertBookmark (
			@Param("name")String name
			,@Param("url") String url);
}
