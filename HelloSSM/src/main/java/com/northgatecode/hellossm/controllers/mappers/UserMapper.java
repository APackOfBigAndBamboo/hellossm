package com.northgatecode.hellossm.controllers.mappers;

import com.northgatecode.hellossm.controllers.models.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by user on 2016/12/5.
 */
public interface UserMapper {
    @SelectProvider(type = DynamicSQLProvider.class, method = "getUsersByCriteria")
    List<User> getUsersByCriteria(String searchText, int offset, int limit);

    @Select("select * from user where id = #{id}")
    User getUserById(int id);

    @Select("select * from user where mobile = #{mobile}")
    User getUserMobile(String mobile);

    @Insert("INSERT INTO user (name, mobile, email, password, gender_id, is_enabled, register_date) " +
            "VALUES (#{name}, #{mobile}, #{email}, #{password}, #{genderId}, #{isEnabled}, #{registerDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(User user);

    @Update("UPDATE user SET name = #{name}, mobile = #{mobile}, email = #{email} WHERE id = #{id}")
    void updateUserBaseInfo(User user);

    @Update("UPDATE user SET password = #{password} WHERE id = #{id}")
    void updateUserPassword(User user);

}
