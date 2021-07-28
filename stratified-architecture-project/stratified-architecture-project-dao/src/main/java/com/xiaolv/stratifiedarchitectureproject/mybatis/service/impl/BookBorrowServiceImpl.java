package com.xiaolv.stratifiedarchitectureproject.mybatis.service.impl;

import com.xiaolv.stratifiedarchitectureproject.mybatis.constants.ResultDTO;
import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.book.BookDTO;
import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.borrow.BookBorrowDTO;
import com.xiaolv.stratifiedarchitectureproject.mybatis.enums.HttpCode;
import com.xiaolv.stratifiedarchitectureproject.mybatis.enums.ValidFlagEnum;
import com.xiaolv.stratifiedarchitectureproject.mybatis.mapper.book.BookMapper;
import com.xiaolv.stratifiedarchitectureproject.mybatis.mapper.borrow.BookBorrowMapper;
import com.xiaolv.stratifiedarchitectureproject.mybatis.service.BookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 借书逻辑处理层
 * @author heji-01
 */
@Service
public class BookBorrowServiceImpl implements BookBorrowService {

    @Autowired
    private BookBorrowMapper bookBorrowMapper;

    @Autowired
    private BookMapper bookMapper;


    @Override
    public ResultDTO doBorrow(int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName, boolean vipFlag) {
            //step1：非法校验
            //借书的编号
        if (0>= bookId){
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "书籍编号不存在，请确认后输入！");
        }

        if (startDate.after(endDate)){
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "起始日期不能晚于归还日期");
        }

        //step2：获取书籍
        if (borrowCount <= 0){
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "借书数量需大于0");
        }

        //查找书籍
        BookDTO bookDTO = bookMapper.findById(bookId);
        //书籍存在性判断
        if (null == bookDTO){
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "书籍不存在");
        }
        //数量是否足够
        int bookCount = bookDTO.getBookCount();
        if (bookCount <= 0 ){
            //TODO  在查找书籍的时候如果书籍数量为0，前端直接禁用该租借按钮
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "该书籍数量为0");
        }

        if (borrowCount > bookCount){
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "剩余书籍数量不足" + bookCount);
        }
        //step3：借书操作
        int result = doInsertBookBorrowRecord(bookId,bookDTO,bookCount,startDate,endDate,userId,userName,vipFlag);
        if (result <= 0 ){
            //新增失败
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "借书失败，请联系管理员");
        }
        //step4：减少书籍数量
        bookDTO.setBookCount(bookCount - borrowCount);
        bookDTO.setUpdateDate(new Date());
        bookMapper.update(bookDTO);
        return new ResultDTO(HttpCode.EXCEPTION.getCode(), "借书成功");

    }

    private int doInsertBookBorrowRecord(int bookId, BookDTO bookDTO, int bookCount, Date startDate, Date endDate, int userId, String userName, boolean vipFlag) {
        BookBorrowDTO bookBorrowDTO = new BookBorrowDTO();
        bookBorrowDTO.setBookId(bookId);
        bookBorrowDTO.setBookName(bookDTO.getBookName());
        bookBorrowDTO.setCount(bookCount);
        bookBorrowDTO.setStartDate(startDate);
        bookBorrowDTO.setEndDate(endDate);

        //用户信息从session中获取 HttpSession session = request getSession();
        bookBorrowDTO.setUserId(userId);
        bookBorrowDTO.setUserName(userName);
        //设置书籍价格
        BigDecimal bookPrice = bookDTO.getBookPrice();
        long day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
        long totalPrice = bookPrice.intValue() * day;

        bookBorrowDTO.setPrice(new BigDecimal(totalPrice));
        bookBorrowDTO.setTradeFee(new BigDecimal(totalPrice));

        if (vipFlag){
            bookBorrowDTO.setTradeFee(new BigDecimal("0.0"));
        }
        bookBorrowDTO.setCreateDate(new Date());
        bookBorrowDTO.setValidFlag(ValidFlagEnum.ENABLE);
        //新增
        int result = bookBorrowMapper.insert(bookBorrowDTO);
        return result;
    }
}
