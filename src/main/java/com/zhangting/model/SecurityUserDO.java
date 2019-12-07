package com.zhangting.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author 张挺（zhangting@binfo-tech.com）
 * @Description
 * @Date 2019/12/7 21:34
 */
public class SecurityUserDO extends UserDO implements UserDetails {

    private static final long serialVersionUID = 1L;

    public SecurityUserDO(UserDO userDO) {
        if (userDO != null) {
            this.setUsername(userDO.getUsername());
            this.setId(userDO.getId());
            this.setPassword(userDO.getPassword());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        String userName = this.getUsername();
        if (userName != null) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userName);
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
