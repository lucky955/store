package com.wn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wn.model.Classes;
import com.wn.model.Pages;
import com.wn.model.Teacher;


@Mapper
public interface ClassesMapper {
	List<Classes> all();
	List<Classes> find(@Param("type") String type,@Param("page")Pages page);
	Classes findByCondition(Classes c);
	int updateClasses(Classes c);
	int insertClasses(Classes c);
	Integer totalCount(@Param("type") String type);
	
	List<Teacher> AllClass(@Param("type") String type);
}

