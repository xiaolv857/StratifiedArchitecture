package com.xiaolv.stratifiedarchitectureproject.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 书实体类
 * @author heji-01
 */

@Data
public class BookDTO implements Serializable {
    private static final long serialVersionUID = -7074036518971546718L;
    /**
     * 编号
     */
    private Long id;

    /**
     * 书名
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 作者
     */
    private String author;
}
