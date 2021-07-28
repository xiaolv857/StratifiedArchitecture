package com.xiaolv.stratifiedarchitectureproject.mybatis.mapper.borrow;

import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 *借书还书接口层
 * @author heji-01
 */
@Mapper
public interface BookBorrowMapper {


    int insert(BookBorrowDTO bookBorrowDTO);
}
