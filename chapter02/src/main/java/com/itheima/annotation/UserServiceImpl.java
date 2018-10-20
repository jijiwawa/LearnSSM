package com.itheima.annotation;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl {
    @Resource(name="userDao")
    private UserDao userDao;
    public void save(){
        // 调用userDao中的save方法
        this.userDao.save();
        System.out.println("userservice...save...");
    }
}
