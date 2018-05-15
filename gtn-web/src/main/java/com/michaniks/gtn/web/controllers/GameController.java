package com.michaniks.gtn.web.controllers;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.michaniks.gtn.services.game.GameService;

@Path("/game")
public class GameController {
	
	@EJB
	private GameService gameService;
	
	@Path("/new/{playerName}")
	@GET
	public Integer createNewGame(@PathParam("playerName") String playerName) {
		return gameService.createGame(playerName).getId();
	}
}
