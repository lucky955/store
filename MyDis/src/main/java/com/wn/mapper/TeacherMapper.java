package com.wn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wn.model.Pages;
import com.wn.model.Teacher;

@Mapper
public interface TeacherMapper {
	List<Teacher> all(@Param("type") String type);
	List<Teacher> find(Pages page);
	Teacher findSomeOne(Teacher t);
	int updateTeacher(Teacher t);
	int insertTeacher(Teacher t);
	//查询条数
	Integer totalCount(@Param("type") String type);
	//链表查询
	List<Teacher> getrota();
	//查询教师教学方向 
	List<Teacher> findSome(@Param("type") String type,@Param("page")Pages page);
	
	void DeleteTeacher(@Param("id")int id);
	
	Teacher QueryOne(@Param("id")int id);
}

