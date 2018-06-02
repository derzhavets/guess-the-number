package com.michaniks.gtn.web.controllers;

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
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.spi.validation.ValidateRequest;

import com.michaniks.gtn.entities.Game;
import com.michaniks.gtn.entities.Guess;
import com.michaniks.gtn.helpers.GameNotFoundException;
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
	@ValidateRequest
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response makeGuess(@Valid Guess guess) {
		try {
			return Response.ok(gameService.checkGuess(guess))
					.header("Game-Status", gameService.getGameStatus(guess.getGameId()))
					.header("Access-Control-Expose-Headers", "Game-Status").build();
		} catch (GameNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@Path("/getAllGuesses/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllGuesses(@PathParam("id") int gameId) {
		try {
			return Response.ok(gameService.getGuessesForGame(gameId)).build();
		} catch (GameNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

}
