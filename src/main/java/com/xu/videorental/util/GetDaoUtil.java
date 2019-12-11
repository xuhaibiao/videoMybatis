package com.xu.videorental.util;

import com.xu.videorental.dao.UserDao;
import com.xu.videorental.dao.VideoDao;
import com.xu.videorental.doMain.table.VideoInfo;
import com.xu.videorental.doMain.view.VideoRecording;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 9:52 2019/11/29
 * @modified By
 */
public class GetDaoUtil {
    private static InputStream in;
    private static SqlSessionFactoryBuilder builder;
    private static SqlSessionFactory build;
    private static SqlSession sqlSession;
    static{
        //1.读取配置文件
        try {
            in = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.创建sqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();
        build = builder.build(in);
        //3.使用工厂生产sqlSession对象,true表示设置位自动提交
        sqlSession = build.openSession(true);

    }

    public static VideoDao getVideoDao() {
        //4.使用sqlSession创建dao接口的代理对象
        return sqlSession.getMapper(VideoDao.class);
    }

    public static UserDao getUserDao() {
        //4.使用sqlSession创建dao接口的代理对象
        return sqlSession.getMapper(UserDao.class);
    }

    /**
     * @author HaibiaoXu
     * @date Create in 16:52 2019/11/28
     * @modified By
     */

    public static class VideoDaoTest {
        @Test
        public void testFindAll() {
            List<VideoInfo> all = getVideoDao().findAllVideoInfo();
            for (VideoInfo videoInfo : all) {
                System.out.println(videoInfo.toString());
            }
        }

        @Test
        public void testFindAllInView() {
            List<VideoRecording> all = getVideoDao().findAllVideoRecording();
            for (VideoRecording videoRecording : all) {
                System.out.println(videoRecording.toString());
            }
        }
    }
}
