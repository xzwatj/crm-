package com.bjpowernode.crm.settings.dao;

import com.bjpowernode.crm.settings.doMain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    User login(Map<String, Object> map);

    List<User> getUserList();
}
