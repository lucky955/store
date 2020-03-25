package com.wn.service;

import java.util.List;

import com.wn.model.Pages;
import com.wn.model.StudentHomework;

public interface StudentHomeworkService {
	/*新增*/
	int insertStudentHomework(StudentHomework sh);
	/*查询*/
	List<StudentHomework> findAll(Pages page);
	/*每一个总行数*/
	int totalCont();
	/*姓名模糊查询总行数*/
	int totalLikeCont(String serchName,String serchClass);
	/*姓名模糊历史行数查询总行数*/
	int totalAllLikeCont(String serchName,String searchClass);
	
	/*姓名模糊查询*/
	List<StudentHomework> findByName(String serchName,String serchClass,Pages page);
	/*查询总行数*/
	List<StudentHomework> findAllLine(Pages page);
	/*姓名总行数模糊查询*/
	List<StudentHomework> findAllLineByName(String serchName,String searchClass ,Pages page);
	int findAllLineCount();
}
