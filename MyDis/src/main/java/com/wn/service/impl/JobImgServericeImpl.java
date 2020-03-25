package com.wn.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wn.mapper.JobImgMapper;
import com.wn.model.JobImg;
import com.wn.model.Pages;
import com.wn.service.JobImgServerice;
@Service
@Transactional
public class JobImgServericeImpl implements JobImgServerice {
	@Autowired
	private JobImgMapper mapper;
	@Override
	public int deleJobImg(Integer id) {
		return mapper.deleJobImg(id);
	}

	@Override
	public List<JobImg> findAll(Pages pages) {
		return mapper.findAll(pages);
	}

	@Override
	public int insertJobImg(JobImg jobImg) {
		return mapper.insertJobImg(jobImg);
	}

	@Override
	public int updateJobImg(JobImg jobImg) {
		return mapper.updateJobImg(jobImg);
	}

	@Override
	public int totalCount() {
		return mapper.totalCount();
	}
	
}
