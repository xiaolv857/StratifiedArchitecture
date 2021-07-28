package com.xiaolv.stratifiedarchitectureproject.mybatis.entity;

import com.xiaolv.stratifiedarchitectureproject.mybatis.enums.ValidFlagEnum;
import lombok.Data;

import java.util.Date;

/**
 * 实体类父类
 * @author heji-01
 */
@Data
public class BaseDTO {

    private int id;

    private String temp1;

    private String temp2;

    private Date createDate;

    private Date updateDate;

    private ValidFlagEnum validFlag;
}
