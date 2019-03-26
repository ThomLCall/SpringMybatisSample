package com.example.monappli.children;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.example.monappli.players.Player;

@Component
@Mapper
public interface ChildRepository {
	
	 @Select("SELECT * FROM child")
	    List<Child> findAll();
	    
	 @Select("SELECT * FROM child WHERE id = #{id}")
	 	Child findOne(Long id);
	 
	 @Insert("INSERT INTO child (name) VALUES (#{name})")
	 @Options(useGeneratedKeys = true, keyProperty = "id")
	 	void save(Child child);
	 
	 @Update("UPDATE child SET name = #{name} WHERE id = #{id}") 
	 	void update(Child child);
	 
	 @Delete("DELETE FROM child WHERE id = #{id}")
	 	void delete(Long id);
	 
	 // Particular SQL for Children
	 @Select("SELECT * FROM child c JOIN famille f ON c.id = f.id_c JOIN player p ON f.id_p = p.id WHERE p.id = #{id};")
	 	List<Child> findAllPlayerChild(Long id);
	 
	 @Select("SELECT * FROM player p JOIN famille f ON p.id = f.id_p JOIN child c ON f.id_c = c.id WHERE c.id = #{id};")
	 	List<Player> findAllChildsPlayer(Long id);
	 
	 // Family Part	 
	 @Insert("INSERT INTO famille (id_p, id_c) VALUES (#{idplayer}, #{idchild})")
	 	void saveF(@Param("idplayer") Long idplayer, @Param("idchild") Long idchild);
	 
	 /*@Update("UPDATE famille SET id_p = #{idnewp} WHERE id_c = #{id} AND id_p = #{idoldp}") 
	 	void updateF(Child child, Long idoldp, Long idnewp );*/
	 
	 @Delete("DELETE FROM famille WHERE id_c = #{id}")
	 	void deleteF(Long id);
	 
	 @Select("SELECT MAX(id) FROM child")
	  	Long maxid();

}
