package com.bjpowernode.crm.workbench.service.impl;

import com.bjpowernode.crm.utils.SqlSessionUtil;
import com.bjpowernode.crm.workbench.dao.ActivityDao;
import com.bjpowernode.crm.workbench.doMain.Activity;
import com.bjpowernode.crm.workbench.service.ActivityService;

/**
 * Author:徐志伟
 * 2019/6/29
 */
public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao= SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);

    @Override
    public Boolean save(Activity activity) {
        int count=activityDao.save(activity);
        Boolean flag=true;
        if(count!=1){
            flag=false;
        }
        return flag;
    }
}
