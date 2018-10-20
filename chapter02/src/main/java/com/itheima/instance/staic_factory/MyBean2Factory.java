package com.itheima.instance.staic_factory;

public class MyBean2Factory {
    // 使用自己的工厂创建bean2实例
    public static Bean2 creatBean(){
        return new Bean2();
    }
}
