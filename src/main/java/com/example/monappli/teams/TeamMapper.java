package com.example.monappli.teams;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamMapper {
	
    List<Team> findAll();

    Team findOne(Long id);
    
    void save(Team team);
    
    void update(Team team);
    
    void delete(Long id);

}
