package com.example.monappli.children;

import java.util.List;

import com.example.monappli.players.Player;

public class Child {
	
	private Long id;
	private String name;
	
	private Long idplayer;
	
	private List<Player> Lp;
	
	public Long getIdplayer() {
		return idplayer;
	}
	public void setIdplayer(Long idplayer) {
		this.idplayer = idplayer;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Player> getLp() {
		return Lp;
	}
	public void setLp(List<Player> lp) {
		Lp = lp;
	}	

}
