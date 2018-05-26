package com.michaniks.gtn.dao;

import com.michaniks.gtn.entities.Game;
import com.michaniks.gtn.helpers.GameNotFoundException;

public interface GameDAO {

	Game addGame(String name);
	
	Game getGame(Integer id) throws GameNotFoundException;

}