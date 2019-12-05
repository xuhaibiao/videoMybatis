package com.xu.vediorental.util;

import com.xu.vediorental.dao.UserDao;
import com.xu.vediorental.dao.VedioDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

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

    public static VedioDao getVedioDao() {
        //4.使用sqlSession创建dao接口的代理对象
        return sqlSession.getMapper(VedioDao.class);
    }

    public static UserDao getUserDao() {
        //4.使用sqlSession创建dao接口的代理对象
        return sqlSession.getMapper(UserDao.class);
    }
}
