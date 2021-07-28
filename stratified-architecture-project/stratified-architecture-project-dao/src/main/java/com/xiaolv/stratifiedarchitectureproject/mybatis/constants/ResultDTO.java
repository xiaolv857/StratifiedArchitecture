package com.xiaolv.stratifiedarchitectureproject.mybatis.constants;

import lombok.Data;

/**
 * 基本返回数据结构
 * @author heji-01
 */

@Data
public class ResultDTO {

    private String system;

    private Integer code;

    private  String msg;

    private Object data;

    public ResultDTO(int code, String msg) {
        this.system = "library";
        this.code = code;
        this.msg = msg;
    }


    public ResultDTO(int code, String msg, Object data) {
        this.system = "library";
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
