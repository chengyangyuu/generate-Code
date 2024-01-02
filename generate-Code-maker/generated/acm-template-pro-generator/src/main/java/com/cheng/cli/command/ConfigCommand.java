package com.cheng.cli.command;
import cn.hutool.core.util.ReflectUtil;
import com.cheng.model.DataModel;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

/**
 * 输出允许用户传入的参数信息
 */
@Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        // 实现 config 命令的逻辑
        System.out.println("查看参数信息");

        //huTool反射工具包快速实现
        Field[] fields = ReflectUtil.getFields(DataModel.class);
        for (Field field:fields){
            System.out.println("字段名称:"+field.getName());
            System.out.println("字段类型"+field.getType());
            System.out.println("--------");
        }

    }
}
