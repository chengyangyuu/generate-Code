package com.cheng.maker.model;

import lombok.Data;


/**
 * 动态模板参数配置
 */
@Data
public class DataModel {

    /**
     * 是否循环
     */
    private boolean loop;

    /**
     * 作者注释
     */
    private String author = "";

    /**
     * 输出信息
     */
    private String outputText = "sum = ";


}
