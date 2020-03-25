package com.wn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wn.mapper.TeacherMapper;
import com.wn.model.Pages;
import com.wn.model.Teacher;
import com.wn.service.TeacherService;

@Service
@Transactional
public class TeacherServiceImpl  implements TeacherService{
	@Autowired
	private TeacherMapper mapper;
	/*所有教师信息*/
	@Override
	public List<Teacher> find(Pages page) {
		return mapper.find(page);
	}
	/*查询一条*/
	@Override
	public Teacher findSomeOne(Teacher t) {
		return mapper.findSomeOne(t);
	}
	/*修改老师信息*/
	@Override
	public int updateTeacher(Teacher t) {
		return mapper.updateTeacher(t);
	}
	/*新增老师信息*/
	@Override
	public int insertTeacher(Teacher t) {
		return mapper.insertTeacher(t);
	}
	@Override
	public Integer totalCount(String type) {
		return mapper.totalCount(type);
	}
	@Override
	public List<Teacher> all(String type) {
		// TODO Auto-generated method stub
		return mapper.all(type);
	}
	
	//链表查询
	@Override
	public List<Teacher> getrota() {
		return mapper.getrota();
	}
	/*教学方向*/
	@Override
	public List<Teacher> findTypeTeacher(String type,Pages page) {
		return mapper.findSome(type, page);
	}
	//删除教师信息
	@Override
	public void DeleteTeacher(int id) {
		// TODO Auto-generated method stub
		mapper.DeleteTeacher(id);
	}
	@Override
	public Teacher QueryOne(int id) {
		// TODO Auto-generated method stub
		return mapper.QueryOne(id);
	}

}
