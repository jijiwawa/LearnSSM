package com.itheima.jdk;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("添加用户");
        //int i =10/0;
    }
    @Override
    public void deleteUser() {
        System.out.println("删除用户 ");
    }
}
