package com.xiaolv.stratifiedarchitectureproject.mybatis.controller;


import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.BookDTO;
import com.xiaolv.stratifiedarchitectureproject.mybatis.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author heji-01
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired(required=false)
    private BookMapper bookMapper;



    @RequestMapping("/findAll")
    public List<BookDTO> findAll() {
        return bookMapper.findAll();

    }
}
