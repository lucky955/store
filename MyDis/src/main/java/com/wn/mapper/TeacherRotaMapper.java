package com.wn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wn.model.Pages;
import com.wn.model.Teacher;
import com.wn.model.TeacherRota;
@Mapper
public interface TeacherRotaMapper {
	List<TeacherRota> find(Pages page);
	TeacherRota findByElement(TeacherRota tr);
	int updateTeacherRota(TeacherRota tr);
	int insertTeacherRota(TeacherRota tr);
	int deleteTeacherRota(TeacherRota tr);
	List<TeacherRota> FindInfor(@Param("id")int id);
	void UpdateInfor(TeacherRota teacherRota);
	void DeleteInfor(@Param("id")int id);
	Integer totalCount();
	
	List<TeacherRota> QueryOne(@Param("t_day")String date);
	
	Teacher QueryType(@Param("t_name")String name);
}
