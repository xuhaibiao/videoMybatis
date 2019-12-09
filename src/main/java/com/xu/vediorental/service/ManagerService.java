package com.xu.vediorental.service;

import com.xu.vediorental.doMain.table.RecordInfo;
import com.xu.vediorental.doMain.table.UserInfo;
import com.xu.vediorental.doMain.table.VedioInfo;
import com.xu.vediorental.doMain.view.AllFile;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 10:56 2019/11/29
 * @modified By
 */
public interface ManagerService  {
    /**
     * 管理员登录
     * @param username 用户名
     * @param password 密码
     * @param role 角色
     * @return 登录成功：true 失败：false
     */
    boolean login(String username,String password,long role);

    /**
     * 添加用户
     * @param userInfo 用户信息
     * @return 添加成功：true 失败：false
     */
    boolean register(UserInfo userInfo);

    /**
     * 查看所有录像信息
     * @return 录像列表
     */
    List<VedioInfo> findAllVedioInfo();

    /**
     * 查看所有用户信息
     * @return 用户列表
     */
    List<UserInfo> findAllUser();

    /**
     * 查看所有文件信息
     * @return 文件列表
     */
    List<AllFile> findAllFile();

    /**
     * 添加录像
     * @param vedioname 录像名
     * @param price 价格
     * @return 添加成功true
     */
    boolean addVedio(String vedioname,double price);

    /**
     * 添加拷贝文件
     * @param vid 录像名
     * @return 添加成功true
     */
    boolean addFile(long vid);

    /**
     * 查看所有录像信息
     * @return 录像信息列表
     */
    List<RecordInfo> findAllRecording();

    /**
     * 删除录像
     * @param id 录像id
     */
    void deleteVedio(long id);

    /**
     * 删除文件
     * @param id 文件id
     */
    void deleteFile(long id);

    /**
     * 删除用户
     * @param username 用户名
     */
    void deleteUser(String username);

    /**
     * 查找所有用户名
     * @return 用户名数组
     */
    String[] findAllUsername();

    /**
     * 租借录像
     * @param username 用户名
     * @param vedioname 录像名
     * @param fid 文件名
     * @param deposit 押金
     */
    void rentVedio(String username,String vedioname, long fid,long deposit);

    /**
     * 归还录像
     * @param username 用户名
     * @param vedioname 录像名
     * @param fid 文件名
     * @param amount 金额
     */
    void retrunVedio(String username, String vedioname, long fid, double amount);
}
