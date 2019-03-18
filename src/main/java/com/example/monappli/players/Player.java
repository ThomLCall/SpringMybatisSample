package com.example.monappli.players;

public class Player {
    private Long id;
    private String name;
    private Long id_team;
    private String position;
    private String diet;

    public Long getId() {
        return id;
    }
    public String getDiet() {
		return diet;
	}
	public void setDiet(String diet) {
		this.diet = diet;
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
    
    public Long getId_team() {
		return id_team;
	}
	public void setId_team(Long id_team) {
		this.id_team = id_team;
	}
	public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}
