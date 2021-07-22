package com.xiaolv.stratifiedarchitectureproject.mybatis.entity;

import com.xiaolv.stratifiedarchitectureproject.mybatis.enums.ValidFlagEnum;
import lombok.Data;

/**
 * 实体类父类
 * @author heji-01
 */
public class BaseDTO {

    private int id;

    private String temp1;

    private String temp2;

    private Data createDate;

    private Data updateDate;

    private ValidFlagEnum validFlag;
}
