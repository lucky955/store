package com.wn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wn.model.Pages;
import com.wn.model.Score;

@Service
public interface ScoreService {
	//添加成绩
	public int addScore(Score score);
	//修改成绩
	public int updateScore(Score score);
	//查询所有
	public List<Score> queryScore(Pages page);
	//单挑查询
	public Score queryScoreByElement(Score sc);
	Integer totalCount();
}
