package com.cheng.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.cheng.generator.MainGenerator;
import com.cheng.model.DataModel;
import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

import picocli.CommandLine.Option;

@Command(name = "generator", description = "生成代码", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {
        @Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否生成循环", interactive = true, echo = true)
        private boolean loop = false;         @Option(names = {"-a", "--author"}, arity = "0..1", description = "作者注释", interactive = true, echo = true)
        private String author = "cheng";         @Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出信息", interactive = true, echo = true)
        private String outputText = "sum = "; 
    public Integer call() throws Exception {
    DataModel dataModel = new DataModel();
    BeanUtil.copyProperties(this,
    dataModel); MainGenerator.doGenerate(dataModel);
    return 0;
    }
}