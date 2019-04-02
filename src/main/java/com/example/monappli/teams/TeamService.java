package com.example.monappli.teams;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.monappli.exceptions.NullIDException;
import com.example.monappli.teams.Team;

@Service
public class TeamService {

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
	public int save(Team team) {
		return teamRepository.save(team);
	}

	@Transactional
	public int update(Team team) {
		return teamRepository.update(team);
	}
	
	@Transactional
	public int delete(Long id) throws NullIDException {		
		if (id == null) 
			throw new NullIDException("ID null non valide");		
		return teamRepository.delete(id);
	}


}
