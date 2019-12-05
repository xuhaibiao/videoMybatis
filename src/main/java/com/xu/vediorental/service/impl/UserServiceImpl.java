package com.xu.vediorental.service.impl;

import com.xu.vediorental.dao.VedioDao;
import com.xu.vediorental.doMain.view.UserRentalHistory;
import com.xu.vediorental.doMain.view.VacantFile;
import com.xu.vediorental.doMain.view.VedioRecording;
import com.xu.vediorental.doMain.vo.BackInfo;
import com.xu.vediorental.doMain.vo.LendInfo;
import com.xu.vediorental.doMain.vo.NoReturnInfo;
import com.xu.vediorental.service.UserService;
import com.xu.vediorental.util.GetDaoUtil;

import java.sql.Date;
import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 10:13 2019/11/29
 * @modified By
 */
public class UserServiceImpl extends Common implements UserService {
    private VedioDao vedioDao = GetDaoUtil.getVedioDao();

    public List<VedioRecording> findAllVedioRecording() {
        return vedioDao.findAllVedioRecording();
    }

    public List<VacantFile> findAllVacantFile() {
        return vedioDao.findAllVacantFile();
    }

    public List<NoReturnInfo> findAllNoReturn(String username) {
        return vedioDao.findAllNoReturn(username);
    }

    public List<UserRentalHistory> findAllRecording(String username) {
        return vedioDao.findAllRecordingByUsername(username);
    }


}

