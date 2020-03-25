package com.wn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wn.mapper.StudentHomeworkMapper;
import com.wn.model.Pages;
import com.wn.model.StudentHomework;
import com.wn.service.StudentHomeworkService;
@Service
@Transactional
public class StudentHomeworkServiceImpl implements StudentHomeworkService{
	@Autowired
	private StudentHomeworkMapper mapper;
	@Override
	public int insertStudentHomework(StudentHomework sh) {
		return mapper.insertStudentHomework(sh);
	}

	@Override
	public List<StudentHomework> findAll(Pages page) {
		return mapper.findAll( page);
	}

	@Override
	public int totalCont() {
		return mapper.totalCont();
	}

	@Override
	public List<StudentHomework> findByName(String serchName,String serchClass,Pages page) {
		return mapper.findLikeName(serchName,serchClass,page);
	}

	@Override
	public List<StudentHomework> findAllLine(Pages page) {
		return mapper.findAllLine(page);
	}

	@Override
	public List<StudentHomework> findAllLineByName(String serchName,String searchClass,Pages page) {
		return mapper.findAllLineLikeName(serchName,searchClass,page);
	}

	@Override
	public int totalLikeCont(String serchName,String serchClass) {
		return mapper.totalContLike(serchName,serchClass);
	}

	@Override
	public int totalAllLikeCont(String serchName,String searchClass) {
		return mapper.totalAllContLike(serchName, searchClass);
	}

	@Override
	public int findAllLineCount() {
		return mapper.findAllLineCount();
	}
	
}
