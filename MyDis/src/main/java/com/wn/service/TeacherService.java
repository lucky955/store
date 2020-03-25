package com.wn.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.wn.model.Pages;
import com.wn.model.Teacher;

@Service
public interface TeacherService {
	List<Teacher> find(Pages page);
	Teacher findSomeOne(Teacher t);
	int updateTeacher(Teacher t);
	int insertTeacher(Teacher t);
	//总条数
	Integer totalCount(String type);
	List<Teacher> all(String type);
	List<Teacher> getrota();
	//教学方向的所有老师
	List<Teacher> findTypeTeacher(String type,Pages page);
	
	void DeleteTeacher(int id);
	
	Teacher QueryOne(int id);
}
