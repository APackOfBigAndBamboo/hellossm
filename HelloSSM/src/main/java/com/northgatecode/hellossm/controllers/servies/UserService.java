package com.northgatecode.hellossm.controllers.servies;
import com.northgatecode.hellossm.controllers.mappers.GenderMapper;
import com.northgatecode.hellossm.controllers.mappers.RoleMapper;
import com.northgatecode.hellossm.controllers.mappers.UserMapper;
import com.northgatecode.hellossm.controllers.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import java.util.Date;
/**
 * Created by qianl on 12/26/2016.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Transactional
    public void createUser(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex("1234".getBytes()));
        user.setEnabled(true);
        user.setRegisterDate(new Date());
        userMapper.insertUser(user);
        roleMapper.insertUserRoleRoleByUserIdAndRoleId(user.getId(), 1); //ROLE_USER
    }
}