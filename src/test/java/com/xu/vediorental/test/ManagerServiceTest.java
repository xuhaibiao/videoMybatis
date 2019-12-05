package com.xu.vediorental.test;

import com.xu.vediorental.doMain.table.VedioInfo;
import com.xu.vediorental.service.ManagerService;
import com.xu.vediorental.service.impl.ManagerServiceImpl;
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
    public void testFindAllVedio() {
        List<VedioInfo> all = managerService.findAllVedioInfo();
        for (VedioInfo vedioInfo : all) {
            System.out.println(vedioInfo.toString());
        }
    }

    @Test
    public void testAddVedio() {
        boolean rs = managerService.addVedio("aaaa",33);
        System.out.println(rs);
    }
}

