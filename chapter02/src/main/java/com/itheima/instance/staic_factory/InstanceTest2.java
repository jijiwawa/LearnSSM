package com.itheima.instance.staic_factory;

import com.itheima.instance.staic_factory.Bean2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest2 {
    public static void main(String[] args) {
        // 定义配置文件路径
        String  xmlPath = "bean2.xml";
        // ApplicationContext 在加载配置文件时，对Bean进行实例化
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(xmlPath);
        Bean2 bean = (Bean2) applicationContext.getBean("bean2");
        System.out.println(bean);
    }
}
