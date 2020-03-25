package com.wn.service;

import com.wn.model.DesrSchool;

public interface DesrShoolService {

//	查出描述信息
	DesrSchool QueryDesr();
	
//	修改描述信息
	void UpdateDesr(String desr,int id);
	
//	修改之前回显 
	DesrSchool ShowValue(int id);
}
