package com.example.monappli.players;

public class Player {
    private Long id;
    private String name;
    private Long team;
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
    public Long getTeam() {
        return team;
    }
    public void setTeam(Long team) {
        this.team = team;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}
