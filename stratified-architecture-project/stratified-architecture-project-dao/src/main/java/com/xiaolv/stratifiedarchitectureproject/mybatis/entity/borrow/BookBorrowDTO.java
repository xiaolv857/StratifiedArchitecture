package com.xiaolv.stratifiedarchitectureproject.mybatis.entity.borrow;

import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 借书实体类
 * @author heji-01
 */
@Data
public class BookBorrowDTO extends BaseDTO {
    /**
     * 用户id
     */
    private int userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 书籍id
     */
    private int bookId;
    /**
     * 书名
     */
    private String bookName;
    /**
     * 书籍数量
     */
    private int count;
    /**
     * 借书开始时间
     */
    private Date startDate;
    /**
     * 借书结束时间
     */
    private Date endDate;
    /**
     * 书籍单价
     */
    private BigDecimal price;
    /**
     * 最终成交价格
     */
    private BigDecimal tradeFee;



}
