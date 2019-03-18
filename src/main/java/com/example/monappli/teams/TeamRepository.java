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
	 	void save(Team team);
	 
	 @Update("UPDATE team SET name = #{name} WHERE id = #{id}") 
	 	void update(Team team);
	 
	 @Delete("DELETE FROM team WHERE id = #{id}")
	 	void delete(Long id);
}
