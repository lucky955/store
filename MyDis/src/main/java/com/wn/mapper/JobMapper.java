package com.wn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wn.model.Job;
import com.wn.model.Pages;


public interface JobMapper {
	
	public void addJob(Job job);
	
	void DeleteJobInfor();
	//	更新就业信息
	public void updateJob(Job job);
	public List<Job> all();
	public List<Job> queryJob(Pages page);
	
	public Job quertJobByElement(Job job);
	
	//	通过s_id找出信息
	List<Job> queryJobByS_id(@Param("id")int id);
	Integer totalCount();
}
