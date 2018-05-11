package com.zhanghuanfa.service;

import org.junit.Test;

import javax.annotation.Resource;

public class UserServiceImplTest extends BaseTest {

    @Resource
    private UserService userService;

    @Test
    public void getUserById() {
        userService.getUserById(1);
    }

    @Test
    public void getUserByUserCondition() throws Exception {
        userService.getUserByUserCondition(1);
    }

}