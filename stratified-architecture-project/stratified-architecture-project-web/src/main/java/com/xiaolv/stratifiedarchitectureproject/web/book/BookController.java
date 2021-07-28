package com.xiaolv.stratifiedarchitectureproject.web.book;

import com.xiaolv.stratifiedarchitectureproject.mybatis.constants.ResultDTO;
import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.book.BookDTO;
import com.xiaolv.stratifiedarchitectureproject.mybatis.enums.HttpCode;
import com.xiaolv.stratifiedarchitectureproject.mybatis.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heji-01
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    /**
     * 根据名称查找数据
     * @param bookName
     * @return
     */
    @RequestMapping("/findListByName")
    public ResultDTO findListByName(String bookName) {
        try {
            return bookService.findListByName(bookName);
        }catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 根据id查找数据
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ResultDTO findById(int id) {
        try {
            return bookService.findById(id);

        }catch (Exception e){
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }

    }


    /**
     * 新增数据
     * @param bookDTO
     * @return
     */
    @RequestMapping("/insert")
    public ResultDTO insert(BookDTO bookDTO) {
        try {
            return bookService.insert(bookDTO);
        }catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 更新数据
     * @param bookDTO
     * @return
     */
    @RequestMapping("/update")
    public ResultDTO update(BookDTO bookDTO) {
        try {
            return bookService.update(bookDTO);
        }catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public ResultDTO delete(int id) {
        try {
            return bookService.delete(id);
        }catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }


}
