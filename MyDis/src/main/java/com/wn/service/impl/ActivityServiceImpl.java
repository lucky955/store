package com.wn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wn.mapper.ActivityMapper;
import com.wn.model.Activity;
import com.wn.model.Pages;
import com.wn.service.ActivityService;

@Service
@Transactional
public class ActivityServiceImpl  implements ActivityService{
	@Autowired
	private ActivityMapper mapper;
	@Override
	public int insertactivity(Activity activity) {
		return mapper.insertactivity(activity);
	}

	@Override
	public int updateActive(Activity activity) {
		return mapper.updateActive(activity);
	}

	@Override
	public Activity findByCondition(Activity activity) {
		return mapper.findByCondition(activity);
	}

	@Override
	public List<Activity> find(Pages page) {
		return mapper.find(page);
	}

	@Override
	public Integer totalCount() {
		return mapper.totalCount();
	}

	@Override
	public List<Activity> all() {
		// TODO Auto-generated method stub
		return mapper.all();
	}

}
