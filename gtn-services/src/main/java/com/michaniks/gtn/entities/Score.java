package com.michaniks.gtn.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "scores")
public class Score {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "score_id")
	private Long id;
	
	private String player_name;
	private int player_score;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	public int getPlayer_score() {
		return player_score;
	}
	public void setPlayer_score(int player_score) {
		this.player_score = player_score;
	}
	
}
