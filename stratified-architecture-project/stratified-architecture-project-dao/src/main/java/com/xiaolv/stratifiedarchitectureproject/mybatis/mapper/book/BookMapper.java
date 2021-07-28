package com.xiaolv.stratifiedarchitectureproject.mybatis.mapper.book;


import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.book.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**书籍实体信息接口
 * @author heji-01
 */
@Mapper
public interface BookMapper {

    /**
     * 111
     * @param name
     * @return
     */
    List<BookDTO>  findListByName(String name);

    /**
     * 222
     * @param id
     * @return
     */
    BookDTO findById(int id);

    /**
     * 333
     * @param entity
     * @return
     */
    int insert(BookDTO entity);

    /**
     * 444
     * @param entity
     * @return
     */
    int update(BookDTO entity);

    /**
     * 555
     * @param id
     * @return
     */
    int delete(int id);
}
