package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.domain.Team;

@Mapper
public interface TeamDao {

	List<Team> findAllTeam();
	
	Team findOneTeam(Long id);
	
    void saveTeam(Team team);

    void updateTeam(Team team);

    void deleteTeam(Long id);
	
}
