package com.xiaolv.stratifiedarchitectureproject.mybatis.mapper.book;


import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.book.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author heji-01
 */
@Mapper
public interface BookMapper {

    /**
     * @return
     */
    List<BookDTO> findAll();

    BookDTO findById(int id);

    List<BookDTO> findByName(String name);
}
