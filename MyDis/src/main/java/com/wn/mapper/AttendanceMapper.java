package com.wn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wn.model.Attendance;
import com.wn.model.Pages;

@Mapper
public interface AttendanceMapper {
	List<Attendance> find(Pages page);
	List<Attendance> findSomeOne(Attendance a);
	List<Attendance> findSome();
	int updateTeacher(Attendance a);
	int insertTeacher(Attendance a);
	Integer totalCount();
}

