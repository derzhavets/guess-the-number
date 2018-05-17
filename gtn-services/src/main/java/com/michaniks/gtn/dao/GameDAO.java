package com.michaniks.gtn.dao;

import com.michaniks.gtn.entities.Game;

public interface GameDAO {

	Game addGame(String name);
	
	Game getGame(Integer id);

}