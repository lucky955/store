package com.wn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wn.mapper.TeacherRotaMapper;
import com.wn.model.Pages;
import com.wn.model.Teacher;
import com.wn.model.TeacherRota;
import com.wn.service.TeacherRotaService;

@Service
@Transactional
public class TeacherRotaServiceImpl  implements TeacherRotaService{
	@Autowired
	private TeacherRotaMapper mapper;

	@Override
	public List<TeacherRota> find(Pages page) {
		return mapper.find(page);
	}

	@Override
	public TeacherRota findSomeOne(TeacherRota tr) {
		return mapper.findByElement(tr);
	}

	@Override
	public int updateTeacher(TeacherRota tr) {
		return mapper.updateTeacherRota(tr);
	}

	@Override
	public int insertTeacher(TeacherRota tr) {
		return mapper.insertTeacherRota(tr);
	}

	@Override
	public int deleteTeacherRota(TeacherRota tr) {
		return mapper.deleteTeacherRota(tr);
	}

	@Override
	public List<TeacherRota> FindInfor(int id) {
		// TODO Auto-generated method stub
		return mapper.FindInfor(id);
	}

	@Override
	public void UpdateInfor(TeacherRota teacherRota) {
		// TODO Auto-generated method stub
		mapper.UpdateInfor(teacherRota);
	}

	@Override
	public void DeleteInfor(int id) {
		// TODO Auto-generated method stub
		mapper.DeleteInfor(id);
	}

	@Override
	public Integer totalCount() {
		return mapper.totalCount();
	}

	@Override
	public List<TeacherRota> QueryOne(String date) {
		// TODO Auto-generated method stub
		return mapper.QueryOne(date);
	}

	@Override
	public Teacher QueryType(String name) {
		// TODO Auto-generated method stub
		return mapper.QueryType(name);
	}
	

}
