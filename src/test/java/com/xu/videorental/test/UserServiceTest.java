package com.xu.videorental.test;

import com.xu.videorental.doMain.table.UserInfo;
import com.xu.videorental.doMain.vo.NoReturnInfo;
import com.xu.videorental.service.UserService;
import com.xu.videorental.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 10:24 2019/11/29
 * @modified By
 */


public class UserServiceTest {
    private UserService userService = new UserServiceImpl();
    @Test
    public void testLogin() {
        System.out.println(userService.login("xhb", "123",0));
    }

    @Test
    public void testRegister() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword("123");
        userInfo.setUsername("tom");
        userInfo.setRole(0);
        userInfo.setPhonenum("5555555");
        System.out.println(userService.register(userInfo));
    }

    @Test
    public void testNoRetrun() {
        List<NoReturnInfo> info = userService.findAllNoReturn("xhb");
        for (NoReturnInfo noReturnInfo : info) {
            System.out.println(noReturnInfo.toString());
        }
    }

    @Test
    public void testFindAllNoReturn(){
        List<NoReturnInfo> infos = userService.findAllNoReturn("xhb");
        for (NoReturnInfo info : infos) {
            System.out.println(info.toString());
        }
    }

}
