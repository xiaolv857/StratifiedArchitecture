package com.xiaolv.stratifiedarchitectureproject.web.borrow;

import com.alibaba.fastjson.JSONObject;
import com.xiaolv.stratifiedarchitectureproject.mybatis.constants.ResultDTO;
import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.book.BookDTO;
import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.borrow.BookBorrowDTO;
import com.xiaolv.stratifiedarchitectureproject.mybatis.enums.HttpCode;
import com.xiaolv.stratifiedarchitectureproject.mybatis.enums.ValidFlagEnum;
import com.xiaolv.stratifiedarchitectureproject.mybatis.mapper.book.BookMapper;
import com.xiaolv.stratifiedarchitectureproject.mybatis.service.BookBorrowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 借书还书控制层
 * @author heji-01
 */
@RestController
@RequestMapping("/borrow")
public class BookBorrowController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookBorrowService bookBorrowService;


    /**
     * 借书操作
     * @param jsonParams
     * @return
     */
    @RequestMapping("/doBorrow")
    private ResultDTO doBorrow(@RequestBody JSONObject jsonParams){
        try {

            int bookId = Integer.parseInt(String.valueOf(jsonParams.getOrDefault("bookId",0)));
            //租借的日期
            Date startDate = jsonParams.getDate("startDate");
            Date endDate = jsonParams.getDate("endDate");
            int borrowCount = jsonParams.getInteger("borrowCount");
            int userId = jsonParams.getInteger("userId");
            String userName = jsonParams.getString("userName");
            boolean vipFlag = jsonParams.getBoolean("vipFlag");

            return bookBorrowService.doBorrow(bookId,startDate,endDate,borrowCount,userId,userName,vipFlag);



        }catch (Exception e){
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }


    }

}
