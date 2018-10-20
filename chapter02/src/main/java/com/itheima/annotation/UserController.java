package com.itheima.annotation;

import org.springframework.stereotype.Controller;
import javax.annotation.Resource;

@Controller("userController")
public class UserController {
    @Resource(name="userService")
    private UserServiceImpl userService;
    public void save(){
        this.userService.save();
        System.out.println("userController...save...");
    }
}
