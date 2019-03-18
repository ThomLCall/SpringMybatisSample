package com.example.monappli.teams;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.monappli.teams.Team;

@Service
public class TeamService {

	@Autowired
	private TeamMapper teamMapper;

	@Autowired
	private TeamRepository teamRepository;

	@Transactional
	public List<Team> findAll() {
		return teamRepository.findAll();
	}

	@Transactional
	public Team findOne(Long id) {
		return teamRepository.findOne(id);
	}

	@Transactional
	public void save(Team team) {
		teamRepository.save(team);
	}

	@Transactional
	public void update(Team team) {
		teamRepository.update(team);
	}

	@Transactional
	public void delete(Long id) {
		teamRepository.delete(id);
	}

}
