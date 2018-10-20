package com.itheima.instance.factory;

import com.itheima.instance.factory.Bean3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest3 {
    public static void main(String[] args) {
        // 定义配置文件路径
        String  xmlPath = "bean3.xml";
        // ApplicationContext 在加载配置文件时，对Bean进行实例化
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(xmlPath);
        Bean3 bean = (Bean3) applicationContext.getBean("bean3");
        System.out.println(bean);
    }
}
