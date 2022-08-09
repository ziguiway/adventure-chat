package com.ziguiway.adventurechat.comon;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhengshuang
 * @Date: 2022/8/3
 * @Time: 15:38
 * @Description:
 */

/**
 * 元数据对象处理器
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

        log.info(metaObject.toString());
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        long id = Thread.currentThread().getId();
        metaObject.setValue("updateTime", LocalDateTime.now());
//        metaObject.setValue("updateUser", BaseContext.getCurrentId());
        log.info(metaObject.toString());
    }
}
