package com.wn.service;

import java.util.List;

import com.wn.model.ActivityImg;
import com.wn.model.Pages;

public interface ActivityImgService {

	List<ActivityImg> all();
	
	int insertActivity(ActivityImg activityImg);
	
	//删除图片
	void DeletePhoto(int id);

	
	List<ActivityImg> find(Pages page);
	
	Integer totalCount();

	//找图片
	ActivityImg findActivityImg(ActivityImg activityImg);

}
