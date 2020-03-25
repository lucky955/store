package com.wn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wn.model.Activity;
import com.wn.model.Pages;

@Service
public interface ActivityService {
	//新增活动
	int insertactivity(Activity activity);
	//修改活动
	int updateActive(Activity activity);
	// 查询一条活动
	Activity findByCondition(Activity activity);
	//查询所有活动
	List<Activity> find(Pages page);
	List<Activity> all();
	Integer totalCount();
}
