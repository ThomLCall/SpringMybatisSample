package com.example.monappli.children;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface ChildRepository {
	
	 @Select("SELECT * FROM child")
	    List<Child> findAll();
	    
	 @Select("SELECT * FROM child WHERE id = #{id}")
	 	Child findOne(Long id);
	 
	 @Insert("INSERT INTO child (name) VALUES (#{name})")
	 	void save(Child child);
	 
	 @Update("UPDATE child SET name = #{name} WHERE id = #{id}") 
	 	void update(Child child);
	 
	 @Delete("DELETE FROM child WHERE id = #{id}")
	 	void delete(Long id);
	 
	 // Particular SQL for Children
	 @Select("SELECT * FROM child c JOIN famille f ON c.id = f.id_c JOIN player p ON f.id_p = p.id WHERE p.id = #{id};")
	 	List<Child> findAllPlayerChild(Long id);

}
