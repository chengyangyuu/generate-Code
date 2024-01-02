package com.cheng.maker.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.cheng.maker.generator.file.FileGenerator;
import com.cheng.maker.model.DataModel;
import lombok.Data;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

import picocli.CommandLine.Option;

@Command(name = "generator", description = "生成代码", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {
    /**
     * 是否循环
     */
    @Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否循环", interactive = true, echo = true)
    private boolean loop;

    /**
     * 作者注释
     */
    @Option(names = {"-DynamicGenerator.java.ftl", "--author"}, arity = "0..1", description = "作者", interactive = true, echo = true)
    private String author = "";

    /**
     * 输出信息
     */
    @Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出信息", interactive = true, echo = true)
    private String outputText = "sum = ";

    @Override
    public Integer call() throws Exception {
        //创建数据模型
        DataModel dataModel = new DataModel();
        BeanUtil.copyProperties(this, dataModel);
        FileGenerator.doGenerate(dataModel);
        System.out.println("配置信息" + dataModel);
        FileGenerator.doGenerate(dataModel);
        return 0;
    }

}
