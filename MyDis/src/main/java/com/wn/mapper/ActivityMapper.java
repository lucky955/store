package com.wn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wn.model.Activity;
import com.wn.model.Pages;

@Mapper
public interface ActivityMapper {
	int insertactivity(Activity activity);
	int updateActive(Activity activity);
	Activity findByCondition(Activity activity);
	List<Activity> find(Pages page);
	List<Activity> all();
	Integer totalCount();
}
