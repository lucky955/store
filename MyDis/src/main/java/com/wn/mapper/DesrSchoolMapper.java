package com.wn.mapper;

import org.apache.ibatis.annotations.Param;

import com.wn.model.DesrSchool;

public interface DesrSchoolMapper {

//	查出描述信息
	DesrSchool QueryDesr();
	
//	修改描述信息
	void UpdateDesr(@Param("desr")String desr,@Param("id")int id);
	
//	修改之前回显 
	DesrSchool ShowValue(@Param("id")int id);
}
