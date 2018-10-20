package com.itheima.assemable;

import com.itheima.instance.constructor.Bean1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanAssemableTest {
    public static void main(String[] args) {
        // 定义配置文件路径
        String  xmlPath = "bean5.xml";
        // 加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(xmlPath);
        // 构造方式输出结果
        System.out.println(applicationContext.getBean("user1"));
        // 设值方式输出结果
        System.out.println(applicationContext.getBean("user2"));
    }
}
