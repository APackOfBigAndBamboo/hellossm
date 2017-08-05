package com.northgatecode.hellossm.controllers.mappers;

import com.northgatecode.hellossm.controllers.models.Student;
import com.northgatecode.hellossm.controllers.models.Teacher;
import com.sun.istack.internal.Interned;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by user on 2016/11/22.
 */
public interface TeacherMapper {
    @Select("SELECT *FROM teacher")
    List<Teacher> getAll();

    @Select("SELECT *FROM teacher WHERE id = #{id}")
   Teacher getteacherById(int id);

    @Delete("DELETE FROM teacher WHERE id = #{id}")
    void delete(int id);

    @Update("UPDATE teacher SET name = #{name} ,mobile=#{mobile},email=#{email}, gender_id = #{genderId} WHERE id = #{id}")
    int update(Teacher teacher);

    @Insert("INSERT INTO teacher (name, mobile, email, gender_id) VALUES (#{name}, #{mobile}, #{email}, #{genderId})")
    int insert(Teacher teacher);

}