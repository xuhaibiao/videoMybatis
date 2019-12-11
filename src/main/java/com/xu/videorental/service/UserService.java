package com.xu.videorental.service;

import com.xu.videorental.doMain.table.UserInfo;
import com.xu.videorental.doMain.view.UserRentalHistory;
import com.xu.videorental.doMain.view.VacantFile;
import com.xu.videorental.doMain.view.VideoRecording;

import com.xu.videorental.doMain.vo.NoReturnInfo;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 10:13 2019/11/29
 * @modified By
 */
public interface UserService {
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @param role 角色
     * @return 登录成功：true 失败：false
     */
    boolean login(String username,String password,long role);

    /**
     * 用户注册
     * @param userInfo 用户信息
     * @return 注册成功：true 失败：false
     */
    boolean register(UserInfo userInfo);

    /**
     * 查看录像信息
     * @return 录像信息列表
     */
    List<VideoRecording> findAllVideoRecording();

    /**
     * 查看可借录像文件信息
     * @return 可借录像文件信息列表
     */
    List<VacantFile> findAllVacantFile();

    /**
     * 查看未归还录像文件信息
     * @param username 用户名
     * @return 未归还录像文件信息列表
     */
    List<NoReturnInfo> findAllNoReturn(String username);




    /**
     * 该用户的租赁信息
     * @param username 用户名
     * @return 租赁信息列表
     */
    List<UserRentalHistory> findAllRecording(String username);

}
