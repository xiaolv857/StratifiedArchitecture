package com.xiaolv.stratifiedarchitectureproject.web.book;

import com.xiaolv.stratifiedarchitectureproject.mybatis.constants.ResultDTO;
import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.book.BookClassDTO;
import com.xiaolv.stratifiedarchitectureproject.mybatis.enums.HttpCode;
import com.xiaolv.stratifiedarchitectureproject.mybatis.service.BookClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heji-01
 */
@RestController
@RequestMapping("/bookClass")
public class BookClassController {

    @Autowired
    private BookClassService bookClassService;

    /**
     * 根据名称查找数据
     * @param name
     * @return
     */
    @RequestMapping("/findListByName")
    public ResultDTO findListByName(String name) {
        try {
            return bookClassService.findListByName(name);
        }catch (Exception e) {
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
           return bookClassService.findById(id);

       }catch (Exception e){
           return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
       }

    }


    /**
     * 新增数据
     * @param bookClassDTO
     * @return
     */
    @RequestMapping("/insert")
    public ResultDTO insert(BookClassDTO bookClassDTO) {
        try {
            return bookClassService.insert(bookClassDTO);
        }catch (Exception e) {
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 更新数据
     * @param bookClassDTO
     * @return
     */
    @RequestMapping("/update")
    public ResultDTO update(BookClassDTO bookClassDTO) {
        try {
            return bookClassService.update(bookClassDTO);
        }catch (Exception e) {
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
            return bookClassService.delete(id);
        }catch (Exception e) {
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }


}
