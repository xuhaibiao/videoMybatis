package com.xu.vediorental.service.impl;

import com.xu.vediorental.dao.UserDao;
import com.xu.vediorental.dao.VedioDao;
import com.xu.vediorental.doMain.table.FileInfo;
import com.xu.vediorental.doMain.table.RecordInfo;
import com.xu.vediorental.doMain.table.UserInfo;
import com.xu.vediorental.doMain.table.VedioInfo;
import com.xu.vediorental.doMain.view.AllFile;
import com.xu.vediorental.doMain.vo.BackInfo;
import com.xu.vediorental.doMain.vo.LendInfo;
import com.xu.vediorental.service.ManagerService;
import com.xu.vediorental.util.GetDaoUtil;

import java.sql.Date;
import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 10:56 2019/11/29
 * @modified By
 */
public class ManagerServiceImpl extends Common implements ManagerService {
    private VedioDao vedioDao = GetDaoUtil.getVedioDao();
    private UserDao userDao = GetDaoUtil.getUserDao();


    public List<VedioInfo> findAllVedioInfo() {
        return vedioDao.findAllVedioInfo();
    }

    public List<UserInfo> findAllUser() {
        return userDao.findAll();
    }

    public List<AllFile> findAllFile() {
        return vedioDao.findAllFile();
    }

    public boolean addVedio(String vedioname, double price) {
        VedioInfo vedioInfo = new VedioInfo();
        vedioInfo.setName(vedioname);
        vedioInfo.setPrice(price);
        vedioInfo.setInventory(0);
        try {
            return vedioDao.addVedio(vedioInfo) == 1;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean addFile(long vid) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setVid(vid);
        fileInfo.setStatus(1);
        try {
            if (vedioDao.addFile(fileInfo) == 1) {
                vedioDao.changeInventoryById(vid, 1);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public List<RecordInfo> findAllRecording() {
        return vedioDao.findAllRecording();
    }

    public void deleteVedio(long id) {
        vedioDao.deleteVedioById(id);
    }

    public void deleteFile(long id) {
        vedioDao.deleteFileById(id);
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

    public void rentVedio(String username,String vedioname, long fid) {
        LendInfo lendInfo = new LendInfo();
        lendInfo.setFid(fid);
        lendInfo.setUsername(username);
        Date date = new Date(new java.util.Date().getTime());
        lendInfo.setLend(date);
        vedioDao.addRecording(lendInfo);
        vedioDao.changeStatus(fid, -1);
        vedioDao.changeInventoryByName(vedioname, -1);
    }


    public void retrunVedio(String username, String vedioname, long fid,double amount) {
        BackInfo backInfo = new BackInfo();
        backInfo.setUsername(username);
        backInfo.setFid(fid);
        Date date = new Date(new java.util.Date().getTime());
        backInfo.setBack(date);
        backInfo.setAmount(amount);
        vedioDao.updateRecording(backInfo);
        vedioDao.changeStatus(fid, 1);
        vedioDao.changeInventoryByName(vedioname, 1);

    }
}
