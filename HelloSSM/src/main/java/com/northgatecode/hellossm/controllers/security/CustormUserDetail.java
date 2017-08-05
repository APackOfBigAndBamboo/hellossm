package com.northgatecode.hellossm.controllers.security;

import com.northgatecode.hellossm.controllers.models.Role;
import com.northgatecode.hellossm.controllers.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by user on 2016/12/10.
 */
public class CustormUserDetail implements UserDetails {
    private User user;
    private List<SimpleGrantedAuthority> authorities = new ArrayList<>();

    public CustormUserDetail(){}
    public  CustormUserDetail(User user , List<Role> roles) {
        this.user = user;
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getCode()));
            System.out.println(user.getId() + " " + role.getCode());
        }
    }
    public String getName(){
        return user.getName();
    }
    public  User getUser(){
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getMobile();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {return user.getEnabled();}

    @Override
    public boolean isEnabled() {
        return user.getEnabled();
    }
}
