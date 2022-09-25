package com.feng.utils;

/**
 * @author
 * @time 2022/9/25 16:32
 * @Description- 枚举类
 */
public enum EnumDemo {
    ONE(1,"韩"),
    TWO(2,"赵"),
    TREE(3,"魏"),
    FOUR(4,"楚"),
    FIVE(5,"燕"),
    SIX(6,"齐");

    private Integer code;

    private String value;

    EnumDemo(Integer code,String value){
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static EnumDemo forEach(int index) {
        EnumDemo[] myArray = EnumDemo.values();
        for (EnumDemo enumDemo : myArray) {
            if (index == enumDemo.getCode()){
                return enumDemo;
            }
        }
        return null;
    }
}