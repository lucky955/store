package com.wn.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wn.model.JobImg;
import com.wn.model.Pages;

public interface JobImgServerice {
	/*删除*/
	int deleJobImg(@Param("id") Integer id);
	/*查询所有未分页*/
	List<JobImg> findAll(Pages pages);
	/*新增就业*/
	int insertJobImg(JobImg jobImg);
	/*修改*/
	int updateJobImg(JobImg jobImg);
	/*总条数*/
	int totalCount();
}
