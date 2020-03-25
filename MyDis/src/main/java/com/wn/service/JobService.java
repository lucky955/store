package com.wn.service;

import java.util.List;

import com.wn.model.Job;
import com.wn.model.Pages;

public interface JobService {

//	添加就业信息
	void addJob(Job job);
	
//	删除所有信息
	void DeleteJobInfor();
	
//	查找所有信息
	List<Job> queryJob(Pages page);
	List<Job> all();
//	通过s_id找出信息
	List<Job> queryJobByS_id(int id);
	
//	更新就业信息
	void updateJob(Job job);
	Integer totalCount();
}
