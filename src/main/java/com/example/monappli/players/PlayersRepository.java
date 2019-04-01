package com.example.monappli.players;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PlayersRepository {
	
	// My Functions
	 @Select("SELECT * FROM player")
	    List<Player> findAll();
	    
	 @Select("SELECT * FROM player WHERE id = #{id}")
	 	Player findOne(Long id);
	 
	 @Insert("INSERT INTO player (name, id_team, position, diet) VALUES (#{name}, #{id_team}, #{position}, #{diet})")
	 	int save(Player player);
	 
	 @Update("UPDATE player SET name = #{name}, id_team = #{id_team}, position = #{position}, diet=#{diet} WHERE id = #{id}") 
	 	int update(Player player);
	 
	 @Delete("DELETE FROM player WHERE id = #{id}")
	 	int delete(Long id);
	 
	// Examples Functions

    @Insert("INSERT into internal_data "
            + "(internal_id, web_printer_id, customization_id, lang_country, proof_sheet_url, created_by, created_when, uuid) "
            + " VALUES "
            + "(#{internalId}, #{webPrinterId}, #{customizationId}, #{langCountry}, #{proofSheetUrl}, #{createdBy}, current_timestamp, #{uuid})")
    int insertInternalData(@Param("internalId") final String internalId,
                       @Param("webPrinterId") final String webPrinterId,
                       @Param("customizationId") final String customizationId,
                       @Param("langCountry") final String langCountry,
                       @Param("proofSheetUrl") final String proofSheetUrl,
                       @Param("createdBy") final String createdBy,
                       @Param("uuid") final String uuid);   

   /* @Select("SELECT customization_id, lang_country, misc_data, proof_sheet_url, uuid " +
        " FROM internal_data where internal_id=#{internalId}")
    @Results({
        @Result(property = "customizationId", column = "customization_id"),
        @Result(property = "langCountry", column = "lang_country"),
        @Result(property = "miscData", column = "misc_data"),
        @Result(property = "proofSheetUrl", column = "proof_sheet_url"),
        @Result(property = "uuid", column = "uuid")
    })
    InternalDataDao retrieveData(String internalId);
    */

    @Update("update internal_data set used_when=current_timestamp, used_by=#{usedBy} where internal_id=#{internalId}")
    int updateUsed(@Param("usedBy") final String usedBy, @Param("internalId") final String internalId);

    @Select("SELECT internal_id FROM internal_data where customization_id=#{customizationId}")
    String retrieveInternalId(String customizationId);

    @Delete("DELETE FROM internal_data where created_when < #{currentDateMinusNMonths}")
    int deleteInternalDataAfterNMonths(LocalDate currentDateMinusNMonths);


}
