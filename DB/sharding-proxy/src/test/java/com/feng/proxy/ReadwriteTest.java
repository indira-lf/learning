package com.feng.proxy;

import com.feng.proxy.bean.User;
import com.feng.proxy.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author
 * @time 2022/9/14 22:40
 * @Description- TODO
 */
@SpringBootTest
class ReadwriteTest {

    @Autowired
    private UserMapper userMapper;


    /**
     * 读数据测试
     */
    @Test
    public void testSelectAll(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}