package com.wn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wn.model.Pages;
import com.wn.model.Teacher;
import com.wn.model.TeacherRota;
@Mapper
public interface TeacherRotaSixMapper {
	List<TeacherRota> find(Pages page);
	Teacher findSomeOne(TeacherRota tr);
	int updateTeacher(TeacherRota tr);
	int insertTeacher(TeacherRota tr);
	Integer totalCount();
}
