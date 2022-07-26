package com.travel.travel.configuration;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyMateObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject){
        //插入公共值示例
        //metaObject.setValue("字段名","字段的值");
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("flag",1);
    }
    @Override
    public void updateFill(MetaObject metaObject){
        //update操作
    }
}