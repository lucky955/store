package com.wn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wn.mapper.DesrSchoolMapper;
import com.wn.model.DesrSchool;
import com.wn.service.DesrShoolService;

@Service
@Transactional
public class DesrSchoolServiceImpl implements DesrShoolService {

	@Autowired
	private DesrSchoolMapper desrSchoolMapper;
	
//	查出描述信息
	@Override
	public DesrSchool QueryDesr() {
		// TODO Auto-generated method stub
		return desrSchoolMapper.QueryDesr();
	}

//	修改描述信息
	@Override
	public void UpdateDesr(String desr, int id) {
		// TODO Auto-generated method stub
		desrSchoolMapper.UpdateDesr(desr, id);
	}

//	修改之前回显 
	@Override
	public DesrSchool ShowValue(int id) {
		// TODO Auto-generated method stub
		return desrSchoolMapper.ShowValue(id);
	}

	
}
