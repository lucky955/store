package com.wn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wn.model.Classes;
import com.wn.model.Pages;
import com.wn.model.Teacher;

@Service
public interface ClassesService {
	List<Classes> all();
	List<Classes> find(String type,Pages page);
	Classes findSomeOne(Classes c);
	int updateClasses(Classes c);
	int insertClasses(Classes c);
	Integer totalCount(String type);
	
	List<Teacher> AllClass(String type);
}
