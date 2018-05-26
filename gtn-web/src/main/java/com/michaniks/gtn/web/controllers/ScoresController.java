package com.michaniks.gtn.web.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.michaniks.gtn.entities.Score;
import com.michaniks.gtn.services.ScoreService;

@Path("/scores")
public class ScoresController {
	
	@EJB
	private ScoreService scoreService;
	
	@Path("/getBest")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Score> getTopTen() {
		return scoreService.getTopTen();
	}
	
}
