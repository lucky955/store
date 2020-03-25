package com.wn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wn.model.ActivityImg;
import com.wn.model.Pages;

@Mapper
public interface ActivityImgMapper {
	List<ActivityImg> all();
	List<ActivityImg> find(Pages page);
	ActivityImg findByCondition(ActivityImg activityImg);
	int updateActive(ActivityImg activityImg);
	int insertActivity(ActivityImg activityImg);
	Integer totalCount();
	
	//删除图片
	void DeletePhoto(@Param("id")int id);
}
