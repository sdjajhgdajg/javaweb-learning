package top.soft.bookline.dao.impl;

import org.junit.jupiter.api.Test;
import top.soft.bookonline.dao.UserDao;
import top.soft.bookonline.dao.impl.UserDaoImpl;
import top.soft.bookonline.entity.User;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    @Test
    void insertUser(){
        UserDao userdao = new UserDaoImpl();
        User user= User.builder()
                .account("zwl")
                .nickname("zwl").password("123456").address("江苏南京").avatar("https://img1.baidu.com/it/u=1418424246,135884815&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=500").build();
        userdao.insertUser(user);
    }

}