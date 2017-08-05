package com.northgatecode.hellossm.controllers.mappers;

import com.northgatecode.hellossm.controllers.models.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by user on 2016/12/19.
 */
public interface RoleMapper {
    @Select("SELECT * FROM role WHERE id = #{id}")
    Role getRoleById(int id);
@Select("SELECT * FROM role ORDER BY id")
List<Role> getRolesAll();
    @Select("SELECT  role.id, role.code,role.name FROM user_role LEFT JOIN role ON user_role.role_id = role.id WHERE user_role.user_id=#{id}")
    List<Role> getRolesByUserId(int id);
    @Delete("DELETE FROM user_role WHERE user_id=#{id}")
    void deleteUserRolesByUserId(int id);
@Insert("INSERT INTO user_role(user_id,role_id)VALUE (#{param1},#{param2})")
@Options(useGeneratedKeys = false)
    void insertUserRoleRoleByUserIdAndRoleId(int userId , int roleId);
}
