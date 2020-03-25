package com.wn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wn.mapper.JobMapper;
import com.wn.model.Job;
import com.wn.model.Pages;
import com.wn.service.JobService;

@Controller
public class JobServiceImpl implements JobService {

	@Autowired
	private JobMapper jobMapper;

//	添加就业信息
	@Override
	public void addJob(Job job) {
		// TODO Auto-generated method stub
		jobMapper.addJob(job);
	}

//	删除所有信息
	@Override
	public void DeleteJobInfor() {
		// TODO Auto-generated method stub
		jobMapper.DeleteJobInfor();
	}

//	查找所有信息
	@Override
	public List<Job> queryJob(Pages page) {
		// TODO Auto-generated method stub
		return jobMapper.queryJob(page);
	}

//	通过s_id找出信息
	@Override
	public List<Job> queryJobByS_id(int id) {
		// TODO Auto-generated method stub
		return jobMapper.queryJobByS_id(id);
	}

	//	更新就业信息
	@Override
	public void updateJob(Job job) {
		// TODO Auto-generated method stub
		jobMapper.updateJob(job);
	}

	@Override
	public Integer totalCount() {
		return  jobMapper.totalCount();
	}

	@Override
	public List<Job> all() {
		// TODO Auto-generated method stub
		return jobMapper.all();
	}


	
}
