package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.mapper.TeamDao;

@Service
public class TeamService {
	@Autowired
	private TeamDao teamDao;
	
	@Transactional
	public List<Team> findAllTeam(){
		return teamDao.findAllTeam();
	}
	
	@Transactional
	public Team findOneTeam(Long id) {
		return teamDao.findOneTeam(id);
	}
	
	@Transactional
	public void saveTeam(Team team) {
		teamDao.saveTeam(team);
    }

    @Transactional
    public void updateTeam(Team team) {
    	teamDao.updateTeam(team);
    }

    @Transactional
    public void deleteTeam(Long id) {
    	teamDao.deleteTeam(id);
    }

}
