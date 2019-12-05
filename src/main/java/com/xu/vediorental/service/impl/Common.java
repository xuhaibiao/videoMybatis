package com.xu.vediorental.service.impl;

import com.xu.vediorental.doMain.table.UserInfo;
import com.xu.vediorental.util.GetDaoUtil;

/**
 * @author HaibiaoXu
 * @date Create in 10:47 2019/11/29
 * @modified By
 */
public class Common{
    public boolean login(String username,String password,long role) {
        UserInfo user = GetDaoUtil.getUserDao().findByName(username);
        return  user != null && user.getPassword().equals(password) && user.getRole() == role;
    }

    public boolean register(UserInfo userInfo) {
        try {
            return GetDaoUtil.getUserDao().add(userInfo) == 1;
        } catch (Exception e) {
            return false;
        }

    }

}
