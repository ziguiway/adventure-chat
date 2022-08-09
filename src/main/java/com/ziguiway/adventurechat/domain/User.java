package com.ziguiway.adventurechat.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId
    private Long id;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String sex;

    /**
     * 最后一次登录地址
     */
    private String address;

    /**
     * 最后一次登录ip
     */
    private String ip;

    /**
     * 注册时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新用户信息时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 用户密码
     */
    private String password;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}