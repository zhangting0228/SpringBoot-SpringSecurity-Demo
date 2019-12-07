package com.zhangting.service;

import com.zhangting.dao.UserDao;
import com.zhangting.model.UserDO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 张挺（zhangting@binfo-tech.com）
 * @Description
 * @Date 2019/12/7 17:54
 */
@Service
public class UserService implements UserDetailsService {

    @Resource
    private UserDao userDao;

    /**
     * 通过用户名查找用户信息
     * 用于登录
     * @param userName
     * @return
     */
    public UserDO getUserByUserName(String userName) {
        UserDO userDO = new UserDO();
        userDO.setUsername(userName);
        return userDao.selectOne(userDO);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO userDO = getUserByUserName(username);
        if (userDO == null){
            throw new UsernameNotFoundException("账号不存在");
        }
        return userDO;
    }
}
