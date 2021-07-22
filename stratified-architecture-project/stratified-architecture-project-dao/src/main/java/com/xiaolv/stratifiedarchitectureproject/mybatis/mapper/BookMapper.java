package com.xiaolv.stratifiedarchitectureproject.mybatis.mapper;


import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    /**
     * @return
     */
    List<BookDTO> findAll();

    BookDTO findById(int id);

    List<BookDTO> findByName(String name);
}
