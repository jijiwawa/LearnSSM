package com.itheima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import javax.annotation.Resource;
import java.io.Reader;
import java.sql.Connection;

public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;
    //初始化SQLSessionFactory对象
    static{
        try{
            //使用MyBatis提供的Resources类加载MyBatis的配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //构建SqlSessionFactory工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //获取SqlSession对象的静态方法
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}
