package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.settings.dao.UserDao;
import com.bjpowernode.crm.settings.doMain.User;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.utils.DateTimeUtil;
import com.bjpowernode.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Author:徐志伟
 * 2019/6/28
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao= SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginException {
        Map<String,Object> map=new HashMap<>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);
        User user=userDao.login(map);
        if(user==null){
          throw new LoginException("账号密码不正确");
        }
        String expireTime = user.getExpireTime();
        if(expireTime.compareTo(DateTimeUtil.getSysTime())<0){
            throw new LoginException("账号已失效");
        }
        String lockState = user.getLockState();
        if ("0".equals(lockState)) {
            throw new LoginException("账号已冻结");
        }
        String ips = user.getAllowIps();
        if(!ips.contains(ip)){
            throw new LoginException("ip地址受限");
        }
        return user;

    }

    @Override
    public List<User> getUserList() {
        List<User> uList=userDao.getUserList();
        return uList;
    }
}
