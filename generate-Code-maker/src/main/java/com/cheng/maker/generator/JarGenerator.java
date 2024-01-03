package com.cheng.maker.generator;

import java.io.*;

/**
 * 程序打包方法
 */
public class JarGenerator {
    //根据一个目录去打jar包
    public static void doGenerate(String projectDir) throws IOException, InterruptedException {
        //清理包 + 打包 命令
        // 注意不同操作系统，执行的命令不同
        String winMavenCommand = "mvn.cmd clean package -DskipTests=true";
        String otherMavenCommand = "mvn clean package -DskipTests=true";
        String mavenCommand = winMavenCommand;

        //为命令指定一个路径
        // 还要拆一下 因为Processbuilder会自动把所有的命令当成一个字符串转义
        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));

        Process process = processBuilder.start();

        // 读取命令的输出
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // 等待命令执行完成
        int exitCode = process.waitFor();
        System.out.println("命令执行结束，退出码：" + exitCode);

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        //需要pom文件才能打包
        doGenerate("D:\\code\\generate-Code\\generate-Code-maker\\generated\\acm-template-pro-generator");
    }
}
