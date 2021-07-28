package com.xiaolv.stratifiedarchitectureproject.mybatis.enums;

/**
 * @author heji-01
 */

public enum UserTypeEnum {
    /**
     * 枚举值必须加注释
     * 学生枚举值
     */
    STUDENT(1,"学生"),
    /**
     * 老师枚举值
     */
    TEACHER(2,"老师"),
    /**
     * 图书管理员枚举值
     */
    LIB_ADMIN(3,"图书管理员"),
    /**
     * 系统管理员枚举值
     */
    SYS_ADMIN(4,"系统管理员");

    private  int num;

    private String name;


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    UserTypeEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }

}
