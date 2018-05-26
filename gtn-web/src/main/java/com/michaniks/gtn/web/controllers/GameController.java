package com.michaniks.gtn.web.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.validation.ValidateRequest;

import com.michaniks.gtn.entities.Game;
import com.michaniks.gtn.entities.Guess;
import com.michaniks.gtn.entities.Score;
import com.michaniks.gtn.services.GameService;
import com.michaniks.gtn.services.ScoreService;

@Path("/game")
public class GameController {
	
	@EJB
	private GameService gameService;
	
	@EJB
	private ScoreService scoreService;
	
	@Path("/new/{playerName}")
	@GET
	public Integer createNewGame(@PathParam("playerName") String playerName) {
		Game g = gameService.createGame(playerName);
		System.out.println(g);
		return g.getId();
	}
	
	@Path("/makeGuess")
	@POST
	@ValidateRequest
	@Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON)
	public Response makeGuess(@Valid Guess guess) {
		return Response
				.ok(gameService.checkGuess(guess))
				.header("Game-Status", gameService.getGameStatus(guess.getGameId()))
				.build();
	}
	
	@Path("/getAllGuesses/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Guess> getAllGuesses(@PathParam("id") int gameId) {
		return gameService.getGuessesForGame(gameId);
	}
	
	@Path("/getBestScores")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Score> getAllScores() {
		return scoreService.getTopTen();
	}
}
