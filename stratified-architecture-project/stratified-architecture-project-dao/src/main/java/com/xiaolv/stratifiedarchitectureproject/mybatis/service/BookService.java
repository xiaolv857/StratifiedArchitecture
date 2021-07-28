package com.xiaolv.stratifiedarchitectureproject.mybatis.service;

import com.xiaolv.stratifiedarchitectureproject.mybatis.constants.ResultDTO;
import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.book.BookDTO;

/**
 * @author heji-01
 */
public interface BookService {

    /**
     * 111
     * @param name
     * @return
     */

    ResultDTO findListByName(String name);


    /**
     * 222
     * @param id
     * @return
     */


    ResultDTO findById(int id);

    /**
     * 333
     * @param entity
     * @return
     */
    ResultDTO insert(BookDTO entity);

    /**
     * 444
     * @param entity
     * @return
     */

    ResultDTO update(BookDTO entity);

    /**
     * 555
     * @param id
     * @return
     */

    ResultDTO delete(int id);
}
