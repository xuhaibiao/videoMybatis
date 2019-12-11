package com.xu.videorental.test;

import com.xu.videorental.doMain.table.VideoInfo;
import com.xu.videorental.service.ManagerService;
import com.xu.videorental.service.impl.ManagerServiceImpl;
import org.junit.Test;

import java.util.List;


/**
 * @author HaibiaoXu
 * @date Create in 11:09 2019/11/29
 * @modified By
 */

public class ManagerServiceTest {
    private ManagerService managerService = new ManagerServiceImpl();
    @Test
    public void testFindAllvideo() {
        List<VideoInfo> all = managerService.findAllVideoInfo();
        for (VideoInfo videoInfo : all) {
            System.out.println(videoInfo.toString());
        }
    }

    @Test
    public void testAddvideo() {
        boolean rs = managerService.addvideo("aaaa",33);
        System.out.println(rs);
    }
}

