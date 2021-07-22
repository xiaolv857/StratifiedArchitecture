package com.xiaolv.stratifiedarchitectureproject.mybatis.mapper.book;


import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.book.BookClassDTO;

import java.util.List;

public interface BookClassMapper {

    List<BookClassDTO>  findListByName(String name);


    BookClassDTO findById(int id);

    int insert(BookClassDTO enpty);

    int update(BookClassDTO enpty);

    int delate(int id);


}
