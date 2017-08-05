package com.northgatecode.hellossm.controllers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * Created by user on 2016/12/10.
 */
@Component
public class CustormAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustormUserDetailService userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        System.out.println("***********************"+username + " " + password);

        //通过用户名判断是否存在此用户名
        UserDetails userDetails = userDetailService.loadUserByUsername(username);

        System.out.println(userDetails.getAuthorities());

        String md5pwd = DigestUtils.md5DigestAsHex(password.getBytes());
        if (userDetails.getPassword().equals(md5pwd)) {
            return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

        } else {
            throw new BadCredentialsException("密码错误");
        }

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
