package com.xiaolv.stratifiedarchitectureproject.mybatis.service;

import com.xiaolv.stratifiedarchitectureproject.mybatis.constants.ResultDTO;

import java.util.Date;

/**
 * @author heji-01
 */
public interface BookBorrowService {



    ResultDTO doBorrow(int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName, boolean vipFlag);
}
