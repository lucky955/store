package com.wn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wn.mapper.ActivityImgMapper;
import com.wn.model.ActivityImg;
import com.wn.model.Pages;
import com.wn.service.ActivityImgService;

@Service
@Transactional
public class ActivityImgServiceImpl implements ActivityImgService {

	@Autowired
	private ActivityImgMapper activityImgMapper;

	@Override
	public List<ActivityImg> all() {
		// TODO Auto-generated method stub
		return activityImgMapper.all();
	}

	@Override
	public int insertActivity(ActivityImg activityImg) {
		return activityImgMapper.insertActivity(activityImg);
	}

	//删除图片
	@Override
	public void DeletePhoto(int id) {
		// TODO Auto-generated method stub
		activityImgMapper.DeletePhoto(id);
	}


	@Override
	public List<ActivityImg> find(Pages page) {
		// TODO Auto-generated method stub
		return activityImgMapper.find(page);
	}

	@Override
	public Integer totalCount() {
		// TODO Auto-generated method stub
		return activityImgMapper.totalCount();
	}


	@Override
	public ActivityImg findActivityImg(ActivityImg activityImg) {
		return activityImgMapper.findByCondition(activityImg);
	}

	
	
}
