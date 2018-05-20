package com.michaniks.gtn.services;

import java.util.List;

import javax.ejb.Local;

import com.michaniks.gtn.entities.Score;

@Local
public interface ScoreService {

	List<Score> getTopTen();

}