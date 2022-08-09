package com.ziguiway.adventurechat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziguiway.adventurechat.domain.User;
import com.ziguiway.adventurechat.service.UserService;
import com.ziguiway.adventurechat.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author zhengshuang
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-08-08 14:24:13
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




