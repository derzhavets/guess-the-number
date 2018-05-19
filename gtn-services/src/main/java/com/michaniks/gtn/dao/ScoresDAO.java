package com.michaniks.gtn.dao;

import java.util.List;

import javax.ejb.Local;

import com.michaniks.gtn.entities.Score;

@Local
public interface ScoresDAO {

	void save(Score s);

	List<Score> getAll();

}