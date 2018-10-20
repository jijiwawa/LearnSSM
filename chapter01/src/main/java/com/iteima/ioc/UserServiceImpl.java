package com.iteima.ioc;

public class UserServiceImpl implements UserService{
    // 声明UserDao属性
    private UserDao userDao;
    // 添加UserDao属性的setter方法，用于实现依赖注入
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }
    // 实现的接口中的方法
    public void say(){
        // 调用接口中的方法
        this.userDao.say();
        System.out.println("userService say hello World!");
    }
}
