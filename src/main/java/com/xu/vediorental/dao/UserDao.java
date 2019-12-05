package com.xu.vediorental.dao;

import com.xu.vediorental.doMain.table.UserInfo;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 10:10 2019/11/29
 * @modified By
 */
public interface UserDao {
    /**
     * 查找所有用户信息
     * @return 用户列表
     */
    List<UserInfo> findAll();

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 对应用户信息
     */
    UserInfo findByName(String username);

    /**
     * 增添用户
     * @param userInfo 用户信息
     * @return 增添成功：1 失败：0
     */
    int add(UserInfo userInfo);

    /**
     * 根据用户名删除用户
     * @param username 用户名
     */
    void deleteByName(String username);

}
