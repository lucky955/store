package com.wn.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.wn.model.Pages;
import com.wn.model.Teacher;
import com.wn.model.TeacherRota;

@Service
public interface TeacherRotaService {
	//所有值班信息
	List<TeacherRota> find(Pages page);
	//某个老师的值班信息
	TeacherRota findSomeOne(TeacherRota tr);
	//修改值班信息
	int updateTeacher(TeacherRota tr);
	//新增值班信息
	int insertTeacher(TeacherRota tr);
	//删除值班信息
	int deleteTeacherRota(TeacherRota tr);
	
	List<TeacherRota> FindInfor(int id);
	
	void UpdateInfor(TeacherRota teacherRota);
	
	void DeleteInfor(int id);
	
	Integer totalCount();
	
	List<TeacherRota> QueryOne(String date);
	
	Teacher QueryType(String name);
}
