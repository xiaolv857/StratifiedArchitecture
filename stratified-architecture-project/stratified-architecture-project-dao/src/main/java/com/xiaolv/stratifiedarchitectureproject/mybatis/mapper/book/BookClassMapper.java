package com.xiaolv.stratifiedarchitectureproject.mybatis.mapper.book;


import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.book.BookClassDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author heji-01
 */
@Mapper
public interface BookClassMapper {
    /**
     * 111
     * @param name
     * @return
     */
    List<BookClassDTO>  findListByName(String name);

    /**
     * 222
     * @param id
     * @return
     */
    BookClassDTO findById(int id);

    /**
     * 333
     * @param entity
     * @return
     */
    int insert(BookClassDTO entity);

    /**
     * 444
     * @param entity
     * @return
     */
    int update(BookClassDTO entity);

    /**
     * 555
     * @param id
     * @return
     */
    int delete(int id);


}
