package com.xu.videorental.service.impl;

import com.xu.videorental.dao.UserDao;
import com.xu.videorental.dao.VideoDao;
import com.xu.videorental.doMain.table.FileInfo;
import com.xu.videorental.doMain.table.RecordInfo;
import com.xu.videorental.doMain.table.UserInfo;
import com.xu.videorental.doMain.table.VideoInfo;

import com.xu.videorental.doMain.view.AllFile;
import com.xu.videorental.doMain.vo.BackInfo;
import com.xu.videorental.doMain.vo.LendInfo;
import com.xu.videorental.service.ManagerService;
import com.xu.videorental.util.GetDaoUtil;

import java.sql.Date;
import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 10:56 2019/11/29
 * @modified By
 */
public class ManagerServiceImpl extends Common implements ManagerService {
    private VideoDao videoDao = GetDaoUtil.getVideoDao();
    private UserDao userDao = GetDaoUtil.getUserDao();


    public List<VideoInfo> findAllVideoInfo() {
        return videoDao.findAllVideoInfo();
    }

    public List<UserInfo> findAllUser() {
        return userDao.findAll();
    }

    public List<AllFile> findAllFile() {
        return videoDao.findAllFile();
    }

    public boolean addvideo(String videoname, double price) {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setName(videoname);
        videoInfo.setPrice(price);
        videoInfo.setInventory(0);
        try {
            return videoDao.addvideo(videoInfo) == 1;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean addFile(long vid) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setVid(vid);
        fileInfo.setStatus(1);
        try {
            if (videoDao.addFile(fileInfo) == 1) {
                videoDao.changeInventoryById(vid, 1);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public List<RecordInfo> findAllRecording() {
        return videoDao.findAllRecording();
    }

    public void deleteVideo(long id) {
        videoDao.deletevideoById(id);
    }

    public void deleteFile(long id) {
        videoDao.deleteFileById(id);
    }


    public void deleteUser(String username) {
        userDao.deleteByName(username);
    }

    public String[] findAllUsername() {
        List<UserInfo> all = userDao.findAll();
        String[] usernames = new String[all.size()];
        for (int i = 0; i < all.size(); i++) {
            usernames[i] = all.get(i).getUsername();
        }
        return usernames;
    }

    public void rentVideo(String username,String videoname, long fid, long deposit) {
        LendInfo lendInfo = new LendInfo();
        lendInfo.setFid(fid);
        lendInfo.setUsername(username);
        lendInfo.setDeposit(deposit);
        Date date = new Date(new java.util.Date().getTime());
        lendInfo.setLend(date);
        videoDao.addRecording(lendInfo);
        videoDao.changeStatus(fid, -1);
        videoDao.changeInventoryByName(videoname, -1);
    }


    public void retrunVideo(String username, String videoname, long fid,double amount) {
        BackInfo backInfo = new BackInfo();
        backInfo.setUsername(username);
        backInfo.setFid(fid);
        Date date = new Date(new java.util.Date().getTime());
        backInfo.setBack(date);
        backInfo.setAmount(amount);
        videoDao.updateRecording(backInfo);
        videoDao.changeStatus(fid, 1);
        videoDao.changeInventoryByName(videoname, 1);

    }

    public boolean updateVideoName(long id, String newName) {
        return videoDao.updatevideoNameById(id, newName)==1;

    }

    public boolean updateVideoPrice(long id, double newPrice) {
        return videoDao.updatevideoPriceById(id, newPrice)==1;
    }
}
