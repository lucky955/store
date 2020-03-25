package com.wn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wn.mapper.ScoreMapper;
import com.wn.model.Pages;
import com.wn.model.Score;
import com.wn.service.ScoreService;
@Transactional
@Service
public class ScoreServiceImpl	implements ScoreService {
	@Autowired
	private ScoreMapper mapper;
	@Override
	public int addScore(Score score) {
		return mapper.addScore(score);
		
	}

	@Override
	public int updateScore(Score score) {
		return mapper.updateScore(score);
	}

	@Override
	public List<Score> queryScore(Pages page) {
		return mapper.queryScore(page);
	}

	@Override
	public Score queryScoreByElement(Score sc) {
		return mapper.queryScoreByElement(sc);
	}

	@Override
	public Integer totalCount() {
		return mapper.totalCount();
	}

}
