package com.michaniks.gtn.web.controllers;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.michaniks.gtn.entities.Game;
import com.michaniks.gtn.entities.Guess;
import com.michaniks.gtn.services.GameService;

@Path("/game")
public class GameController {
	
	@EJB
	private GameService gameService;
	
	@Path("/new/{playerName}")
	@GET
	public Integer createNewGame(@PathParam("playerName") String playerName) {
		Game g = gameService.createGame(playerName);
		System.out.println(g);
		return g.getId();
	}
	
	@Path("/makeGuess")
	@POST
	@Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON)
	public Guess makeGuess(Guess guess) {
		return gameService.checkGuess(guess);
	}
}
