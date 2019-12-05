package com.xu.vediorental.test;



import com.xu.vediorental.doMain.table.VedioInfo;
import com.xu.vediorental.doMain.view.VedioRecording;
import com.xu.vediorental.util.GetDaoUtil;
import org.junit.Test;

import java.util.List;


/**
 * @author HaibiaoXu
 * @date Create in 16:52 2019/11/28
 * @modified By
 */

public class VedioDaoTest {
    @Test
    public void testFindAll() {
        List<VedioInfo> all = GetDaoUtil.getVedioDao().findAllVedioInfo();
        for (VedioInfo vedioInfo : all) {
            System.out.println(vedioInfo.toString());
        }
    }

    @Test
    public void testFindAllInView() {
        List<VedioRecording> all = GetDaoUtil.getVedioDao().findAllVedioRecording();
        for (VedioRecording vedioRecording : all) {
            System.out.println(vedioRecording.toString());
        }
    }
}

