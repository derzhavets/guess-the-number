package com.michaniks.gtn.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.michaniks.gtn.dao.ScoresDAO;
import com.michaniks.gtn.entities.Score;

@Stateless
public class ScoreServiceImpl implements ScoreService {
	
	@EJB
	private ScoresDAO scoresDao;
	
	@Override
	public List<Score> getTopTen() {
		return scoresDao.getAll().stream()
				.sorted(Comparator.comparing(Score::getPlayer_score))
				.collect(Collectors.toList());
	}
}
