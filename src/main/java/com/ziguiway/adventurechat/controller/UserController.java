package com.ziguiway.adventurechat.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ziguiway.adventurechat.bean.vo.ResultVo;
import com.ziguiway.adventurechat.comon.ResultCode;
import com.ziguiway.adventurechat.domain.User;
import com.ziguiway.adventurechat.service.UserService;
import com.ziguiway.adventurechat.utils.IpAddressUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhengshuang
 * @Date: 2022/8/8
 * @Time: 14:27
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final String slot = "ziguiway";

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public ResultVo<String> login(@RequestBody User user, HttpServletRequest request) {

        request.getSession().setAttribute("user", user.getId());
        return ResultVo.success("登录成功");
    }

    /**
     * 注册
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/register")
    public ResultVo<String> register(@RequestBody User user, HttpServletRequest request) {
        String email = user.getEmail();
        String password = user.getPassword();
        String passwordMD5 = DigestUtils.md5DigestAsHex(password.getBytes());
        if (checkUserExists(email,password)) {
            return ResultVo.error("用户已存在", ResultCode.FAILED);
        }
        String ipAddress = IpAddressUtil.getIpAddress(request);
        user.setIp(ipAddress);
        String address = IpAddressUtil.getAddress(ipAddress);
        user.setAddress(address);
        user.setPassword(passwordMD5+slot);
        userService.save(user);
        return ResultVo.success("注册成功");
    }


    /**
     * 检查用户是否存在
     *
     * @param email
     * @param password
     * @return
     */
    public Boolean checkUserExists(String email, String password) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(!StringUtils.isEmpty(email), User::getEmail, email).eq(!StringUtils.isEmpty(password), User::getPassword, password);
        return userService.count(lambdaQueryWrapper) > 0;
    }
}
