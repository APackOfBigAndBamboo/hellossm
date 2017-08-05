package com.northgatecode.hellossm.controllers.security;

import com.northgatecode.hellossm.controllers.mappers.RoleMapper;
import com.northgatecode.hellossm.controllers.mappers.UserMapper;
import com.northgatecode.hellossm.controllers.models.Role;
import com.northgatecode.hellossm.controllers.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2016/12/10.
 */
@Service
public class CustormUserDetailService implements UserDetailsService {
     @Autowired
    UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.getUserMobile(s);
        if (user != null) {
            List<Role> roles = roleMapper.getRolesByUserId(user.getId());
            if (roles.size()>0){
                return new CustormUserDetail(user , roles);
            }else {
                throw new BadCredentialsException("此用户没有任何授权");
            }
        }else {
            throw new UsernameNotFoundException("用户不存在");
        }

    }
}