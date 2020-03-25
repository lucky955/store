package com.wn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wn.model.Pages;
import com.wn.model.StudentHomework;

@Mapper
public interface StudentHomeworkMapper {
	/*新增*/
	int insertStudentHomework(StudentHomework sh);
	/*查询*/
	List<StudentHomework> findAll(@Param("page") Pages page);
	/*通过学生ID查找学生*/
	List<StudentHomework> findAccountBySid(@Param("sid") String sid);
	/*姓名模糊查找*/
	List<StudentHomework> findLikeName(@Param("username") String username,@Param("serchClass")String serchClass,@Param("page") Pages page);
	/*总行数*/
	int totalCont();
	/*姓名模糊查找总行数*/
	int totalContLike(@Param("username") String username,@Param("serchClass")String serchClass);
	/*姓名模糊历史行数查找总行数*/
	int totalAllContLike(@Param("username") String username,@Param("serchClass")String searchClass);
	/*学生写代码的总行数*/
	List<StudentHomework> findAllLine(@Param("page") Pages page);
	/*姓名总行数模糊查找*/	
	List<StudentHomework> findAllLineLikeName(@Param("username") String username,@Param("serchClass")String searchClass,@Param("page") Pages page);
	/*姓名总行数模糊查找*/
	int findAllLineCount();
	
}
