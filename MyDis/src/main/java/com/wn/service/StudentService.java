package com.wn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wn.model.Pages;
import com.wn.model.Student;

@Service
public interface StudentService {
	//学生总人数
	Integer count();
	//劝退人数
	Integer expelled();
	//所有学生信息
	List<Student> findStudent(Pages page);
	//查找学生
	Student findStudentBtyElemen(Student stu);
	//删除学生信息
	int deleteStu(Student stu);
	//修改学生信息
	int updateStu(Student stu);
	// 新增学生信息
	int addtStudent(Student stu);
	Integer totalCount();
}
