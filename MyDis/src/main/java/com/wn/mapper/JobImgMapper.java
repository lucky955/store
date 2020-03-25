package com.wn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wn.model.JobImg;
import com.wn.model.Pages;

@Mapper
public interface JobImgMapper {
	/*总条数*/
	int totalCount();
	/*删除*/
	int deleJobImg(@Param("id") Integer id);
	/*查询所有未分页*/
	List<JobImg> findAll(@Param("page") Pages pages);
	/*新增就业*/
	int insertJobImg(JobImg jobImg);
	/*修改*/
	int updateJobImg(JobImg jobImg);
}
