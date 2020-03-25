package com.wn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wn.mapper.ClassesMapper;
import com.wn.model.Classes;
import com.wn.model.Pages;
import com.wn.model.Teacher;
import com.wn.service.ClassesService;

@Service
@Transactional
public class ClassesServiceImpl  implements ClassesService{
	@Autowired
	private ClassesMapper mapper;

	@Override
	public List<Classes> find(String type,Pages page) {
		return mapper.find(type,page);
	}

	@Override
	public Classes findSomeOne(Classes c) {
		return mapper.findByCondition(c);
	}

	@Override
	public int updateClasses(Classes c) {
		return mapper.updateClasses(c);
	}

	@Override
	public int insertClasses(Classes c) {
		return mapper.insertClasses(c);
	}

	@Override
	public Integer totalCount(String type) {
		return mapper.totalCount(type);
	}

	@Override
	public List<Classes> all() {
		return mapper.all();
	}

	@Override
	public List<Teacher> AllClass(String type) {
		// TODO Auto-generated method stub
		return mapper.AllClass(type);
	}
}
