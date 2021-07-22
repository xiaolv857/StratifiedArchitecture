package com.xiaolv.stratifiedarchitectureproject.mybatis.service.impl;

import com.xiaolv.stratifiedarchitectureproject.mybatis.constants.ResultDTO;
import com.xiaolv.stratifiedarchitectureproject.mybatis.entity.book.BookClassDTO;
import com.xiaolv.stratifiedarchitectureproject.mybatis.enums.HttpCode;
import com.xiaolv.stratifiedarchitectureproject.mybatis.mapper.book.BookClassMapper;
import com.xiaolv.stratifiedarchitectureproject.mybatis.service.BookClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author heji-01
 */
@Service
public class BookClassServiceImpl implements BookClassService {

    @Autowired
    private BookClassMapper bookClassMapper;

    @Override
    public ResultDTO findListByName(String name) {
        //非空判断
        if (StringUtils.isEmpty(name)){
            return new ResultDTO(HttpCode.FAIL.getCode(), "搜索关键字不能为空");
        }
        //业务查找
        List<BookClassDTO> list = bookClassMapper.findListByName(name);
        if (CollectionUtils.isEmpty(list)){
            return new ResultDTO(HttpCode.FAIL.getCode(),"暂无对应分类数据");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "查找成功",list);

    }

    @Override
    public ResultDTO findById(int id) {
        //非空判断
        if (0 == id){
            return new ResultDTO(HttpCode.FAIL.getCode(), "数据id不能为空");
        }

        //业务查找
        BookClassDTO bookClassDTO = bookClassMapper.findById(id);
        if (null == bookClassDTO){
            return new ResultDTO(HttpCode.FAIL.getCode(), "暂无对应分类数据");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "查找成功",bookClassDTO);
    }

    @Override
    public ResultDTO insert(BookClassDTO entity) {
        //非空判断
        if (StringUtils.isEmpty(entity.getName())){
            return new ResultDTO(HttpCode.FAIL.getCode(), "分类名称不能为空");
        }
        int influenceNumber = bookClassMapper.insert(entity);
        if (influenceNumber <= 0){
            //新增失败
            return new ResultDTO(HttpCode.FAIL.getCode(), "新增失败");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "新增成功");
    }

    @Override
    public ResultDTO update(BookClassDTO entity) {
        //非空判断
        if (StringUtils.isEmpty(entity.getId())){
            return new ResultDTO(HttpCode.FAIL.getCode(), "数据id不能为空");
        }
        int influenceNumber = bookClassMapper.update(entity);
        if (influenceNumber <= 0){
            //更新失败
            return new ResultDTO(HttpCode.FAIL.getCode(), "更新失败");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "更新成功");

    }

    @Override
    public ResultDTO delete(int id) {
        //非空判断
        if (0 == id){
            return new ResultDTO(HttpCode.FAIL.getCode(), "数据id不能为空");
        }
        int influenceNumber = bookClassMapper.delete(id);
        if (influenceNumber <= 0){
            //删除失败
            return new ResultDTO(HttpCode.FAIL.getCode(), "删除失败");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "删除成功");
    }
}
