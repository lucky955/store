package com.wn.util;

import java.util.List;

import com.wn.model.Teacher;
import com.wn.model.TeacherRota;

public class TeacherRoteUtil {

	public static boolean GetBoo(String date,Teacher queryType,Teacher queryType2,List<TeacherRota> queryOne) {
		boolean state = true;
		if(!"6".equals(date)) {
			int length = queryOne.size();
			System.out.println("length : " + length);
			if(length == 1) {
				if(queryType.getT_type().equals(queryType2.getT_type())) {
					state = false;
				}else {
					state = true;
				}
			}else if (length == 2) {
				state = false;
			}else {
				state = true;
			}
		}else {
			state = true;
		}
		return state;
	}
}
