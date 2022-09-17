package com.feng.proxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.proxy.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author
 * @time 2022/9/14 22:31
 * @Description- TODO
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
