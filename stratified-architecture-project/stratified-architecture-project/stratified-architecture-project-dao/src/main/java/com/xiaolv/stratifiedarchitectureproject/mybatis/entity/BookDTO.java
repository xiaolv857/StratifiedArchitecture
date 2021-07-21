package com.xiaolv.stratifiedarchitectureproject.mybatis.entity;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 书籍实体类
 * @author heji-01
 */
@Data
public class BookDTO implements Serializable {

    private static final long serialVersionUID = -6937925174615329823L;
    private int id;


    private String name;


    private BigDecimal price;


    private  String author;

}
