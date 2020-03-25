package com.wn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wn.mapper.StudentMapper;
import com.wn.model.Pages;
import com.wn.model.Student;
import com.wn.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentMapper mapper;

	@Override
	public Integer count() {
		return mapper.count();
	}

	@Override
	public List<Student> findStudent(Pages page) {
		return mapper.findStudent(page);
	}

	@Override
	public Student findStudentBtyElemen(Student stu) {
		return mapper.findStudentBtyElemen(stu);
	}

	@Override
	public int deleteStu(Student stu) {
		return mapper.deleteStu(stu);
	}

	@Override
	public int updateStu(Student stu) {
		return mapper.updateStu(stu);
	}

	@Override
	public int addtStudent(Student stu) {
		return mapper.addtStudent(stu);
	}

	@Override
	public Integer totalCount() {
		return mapper.totalCount();
	}

	@Override
	public Integer expelled() {
		return mapper.expelled();
	}
	
	
	
}
