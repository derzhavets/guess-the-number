package com.michaniks.gtn.web.controllers;

import javax.ejb.EJB;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.michaniks.gtn.services.game.GameDAO;
import com.michaniks.gtn.services.game.GameService;

@Path("/game")
public class GameController {
	
	@EJB
	private GameService gameService;
	
	@EJB
	private GameDAO gameDao;
	
	@Path("/new/{name}")
	@GET
	public Integer createNewGame(@PathParam("playerName") String playerName) {
		return gameService.createGame(playerName);
	}
}
