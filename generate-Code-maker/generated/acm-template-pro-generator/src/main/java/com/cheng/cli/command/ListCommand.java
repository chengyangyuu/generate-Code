package com.cheng.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

import picocli.CommandLine.Option;

/**
 * 查看文件列表的命令
 */
@Command(name = "list", description = "查看文件列表", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{

    @Override
    public void run() {

        String srcPath = "/generate-Code/generate-Code-demo-project/acm-template-pro";
        List<File> files = FileUtil.loopFiles(srcPath);
        for (File file:files){
            System.out.println(file);
        }
    }
}
