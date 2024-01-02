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
        //D:\code\generator-Code\generator-Code-basic
        String projectPath = System.getProperty("user.dir");
        //获取父项目的路径(gene-Code)
        File projecttFile = new File(projectPath).getParentFile();

        //输入路径 ACM程序路径
//        D:\code\generator-Code\generator-Code-demo-project\acm-template
        String srcPath = new File(projecttFile, "generator-Code-demo-project/acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(srcPath);
        for (File file:files){
            System.out.println(file);
        }
    }
}
