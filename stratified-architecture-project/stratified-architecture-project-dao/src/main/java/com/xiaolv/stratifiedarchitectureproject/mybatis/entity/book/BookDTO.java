package com.xiaolv.stratifiedarchitectureproject.mybatis.entity.book;

import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.BaseDTO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 书籍实体类
 * @author heji-01
 */
@Data

public class BookDTO extends BaseDTO implements Serializable {


    private static final long serialVersionUID = -4905279642002997669L;

    private String bookName;

    private int bookClassId;

    private BigDecimal bookPrice;

    private int bookCount;

    private  String bookPublish;

    private  String bookAuthor;

    private  String bookImg;

    private Timestamp publishDate;


}
