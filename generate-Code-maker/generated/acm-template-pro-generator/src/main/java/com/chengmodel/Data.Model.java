package com.cheng.model;

import lombok.Data;


/**
* 动态模板参数配置
*/
@Data
public class DataModel {
        /**
         * 是否生成循环
         */
    private boolean loop = false;
        /**
         * 作者注释
         */
    private String author = "cheng";
        /**
         * 输出信息
         */
    private String outputText = "sum = ";

}
