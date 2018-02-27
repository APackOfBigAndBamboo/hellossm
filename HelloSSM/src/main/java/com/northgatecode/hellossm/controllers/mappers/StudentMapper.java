package com.northgatecode.hellossm.controllers.mappers;

import com.northgatecode.hellossm.controllers.models.Student;
import com.sun.istack.internal.Interned;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by user on 2016/11/22.
 */
public interface StudentMapper {


    @Select("SELECT  *FROM student WHERE email=#{email}")
    List<Student> getStudentsByEmail(String email);

    @SelectProvider(type = DynamicSQLProvider.class,method = "getsearch")
    @Results(
            {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "mobile", property = "mobile"),
                    @Result(column = "birthday", property = "birthday"),
                    @Result(column = "gender_id", property = "genderId"),
                    @Result( column = "gender_id",property = "gender",
                            one = @One(select = "com.northgatecode.hellossm.controllers.mappers.GenderMapper.getGenderById"))
            }
    )
    List<Student> getsearch(String name , Integer genderId ,int offest, int limit);

    @Select("SELECT * FROM student")
    @Results(
            {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "mobile", property = "mobile"),
                    @Result(column = "birthday", property = "birthday"),
                    @Result(column = "gender_id", property = "genderId"),
                    @Result( column = "gender_id",property = "gender",
                            one = @One(select = "com.northgatecode.hellossm.controllers.mappers.GenderMapper.getGenderById"))
            }
    )
    List<Student> getAll();

    @Select("SELECT student.id , student.name , student.mobile , student.email , student.birthday,student.gender_id, gender.name AS gender_name FROM student\n" +
            "LEFT JOIN gender ON student.gender_id = gender.id ORDER BY student.id")

    @Results(
            {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "mobile", property = "mobile"),
                    @Result(column = "email", property = "email"),
                    @Result(column = "birthday", property = "birthday"),
                    @Result(column = "gender_id", property = "genderId"),
                    @Result(column = "gender_id", property = "gender.id"),
                    @Result(column = "gender_name", property = "gender.name")


            }
    )
    List<Student> getstudnetsAll();


    @Select("SELECT *FROM student WHERE id = #{id}")
//    @ResultMap("studentResult")
    Student getStudentById(int id);

    @Delete("DELETE FROM student WHERE id = #{id}")
//    @ResultMap("studentResult")
    void delete(int id);

    @Update("UPDATE student SET name = #{name} , mobile = #{mobile}, birthday = #{birthday},email = #{email}, gender_id = #{genderId} WHERE id = #{id}")
        //@ResultMap("studentResult")
    int update(Student student);

    @Insert("INSERT INTO student (name, mobile, birthday,  email,gender_id)VALUES (#{name}, #{mobile}, #{birthday},#{email}, #{genderId})")
//    @ResultMap("studentResult")
    int insert(Student student);

}
