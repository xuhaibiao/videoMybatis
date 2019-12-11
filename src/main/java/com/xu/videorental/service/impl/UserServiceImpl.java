package com.xu.videorental.service.impl;

import com.xu.videorental.dao.VideoDao;
import com.xu.videorental.doMain.view.UserRentalHistory;
import com.xu.videorental.doMain.view.VacantFile;
import com.xu.videorental.doMain.view.VideoRecording;
import com.xu.videorental.doMain.vo.NoReturnInfo;
import com.xu.videorental.service.UserService;
import com.xu.videorental.util.GetDaoUtil;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 10:13 2019/11/29
 * @modified By
 */
public class UserServiceImpl extends Common implements UserService {
    private VideoDao videoDao = GetDaoUtil.getVideoDao();

    public List<VideoRecording> findAllVideoRecording() {
        return videoDao.findAllVideoRecording();
    }

    public List<VacantFile> findAllVacantFile() {
        return videoDao.findAllVacantFile();
    }

    public List<NoReturnInfo> findAllNoReturn(String username) {
        return videoDao.findAllNoReturn(username);
    }

    public List<UserRentalHistory> findAllRecording(String username) {
        return videoDao.findAllRecordingByUsername(username);
    }


}

