package com.feng.sharding;

import com.feng.sharding.bean.Order;
import com.feng.sharding.bean.User;
import com.feng.sharding.mapper.OrderMapper;
import com.feng.sharding.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
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
     * 写入数据的测试
     */
    @Test
    public void testInsert() {

        User user = new User();
        user.setUname("张三丰");
        userMapper.insert(user);
    }

    /**
     * 事务测试
     */
    @Transactional
    @Test
    public void testTrans(){

        User user = new User();
        user.setUname("铁锤");
        userMapper.insert(user);

        List<User> users = userMapper.selectList(null);

        for (User user1 : users) {
            System.out.println(user1.toString());
        }
    }

    /**
     * 读数据测试
     */
    @Test
    public void testSelectAll(){
        List<User> users = userMapper.selectList(null);
        List<User> users1 = userMapper.selectList(null);//执行第二次测试负载均衡
        users.forEach(System.out::println);
        users1.forEach(System.out::println);
    }
}