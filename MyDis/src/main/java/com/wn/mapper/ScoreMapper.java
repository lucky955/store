package com.wn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wn.model.Pages;
import com.wn.model.Score;

@Mapper
public interface ScoreMapper {
	
	public int addScore(Score score);
	
	public int updateScore(Score score);
	
	public List<Score> queryScore(Pages page);
	
	public Score queryScoreByElement(Score sc);
	Integer totalCount();
}
