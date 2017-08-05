package com.northgatecode.hellossm.controllers.mappers;

import com.northgatecode.hellossm.controllers.models.Gender;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by user on 2016/11/26.
 */
public interface GenderMapper {
    @Select("SELECT id, name FROM gender ORDER BY id")
    List<Gender> getGenderAll();

    @Select("SELECT * FROM gender WHERE id = #{id}")
    Gender getGenderById(int id);

}
