package com.example.monappli.teams;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface TeamRepository {

	 @Select("SELECT * FROM team")
	    List<Team> findAll();
	    
	 @Select("SELECT * FROM team WHERE id = #{id}")
	 	Team findOne(Long id);
	 
	 @Insert("INSERT INTO team (name) VALUES (#{name})")
	 	int save(Team team);
	 
	 @Update("UPDATE team SET name = #{name} WHERE id = #{id}") 
	 	int update(Team team);
	 
	 @Delete("DELETE FROM team WHERE id = #{id}")
	 	int delete(Long id);
	 
	 /**@Delete("DELETE FROM player WHERE id_team = #{id}")
	 	int deleteP(Long id);*/
}
