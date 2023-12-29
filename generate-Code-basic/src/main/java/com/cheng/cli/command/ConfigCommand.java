package com.cheng.cli.command;
import cn.hutool.core.util.ReflectUtil;
import com.cheng.Main;
import com.cheng.generator.MainGenerator;
import com.cheng.model.MainTemplateConfig;
import picocli.CommandLine.Command;

import java.io.File;
import java.lang.reflect.Field;

/**
 * 输出允许用户传入的参数信息
 */
@Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        //查看用户需要填什么信息
//        //原生反射
//        Class<?> mainTemplateConfigClass = MainTemplateConfig.class;
//        //获取类的所有字段
//        Field[] declaredField = mainTemplateConfigClass.getDeclaredFields();
//        //就可以遍历打印字段信息了
        //huTool反射工具包快速实现
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field:fields){
            System.out.println("字段名称:"+field.getName());
            System.out.println("字段类型"+field.getType());
            System.out.println("--------");
        }

    }
}
