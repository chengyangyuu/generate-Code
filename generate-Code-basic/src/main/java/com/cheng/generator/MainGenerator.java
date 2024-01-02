package com.cheng.generator;

import com.cheng.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

import static com.cheng.generator.StaticGenerator.copyFileByHutool;

/**
 * 核心生成器
 */
public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("ben");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果");
        doGenerate(mainTemplateConfig);
    }
    public static void doGenerate(Object model) throws TemplateException, IOException {

        String inputRootPath = "D:\\code\\generate-Code\\generate-Code-basic\\acm-template-pro";
        String outputRootPath = "D:\\code\\generate-Code\\acm-template-pro";
        String inputPath;
        String outputPath;
        inputPath = new File(inputRootPath, "src/com/cheng/acm/MainTemplate.java.ftl").getAbsolutePath();
        outputPath = new File(outputRootPath, "src/com/cheng/acm/MainTemplate.java").getAbsolutePath();
        DynamicGenerator.doGenerate(inputPath, outputPath, model);
        inputPath = new File(inputRootPath, ".gitignore").getAbsolutePath();
        outputPath = new File(outputRootPath, ".gitignore").getAbsolutePath();
        StaticGenerator.copyFileByHutool(inputPath, outputPath);
        inputPath = new File(inputRootPath, "README.md").getAbsolutePath();
        outputPath = new File(outputRootPath, "README.md").getAbsolutePath();
        StaticGenerator.copyFileByHutool(inputPath, outputPath);

//
//        //D:\code\generator-Code\generator-Code-basic
//        String projectPath = System.getProperty("user.dir");
//        //获取父项目的路径(gene-Code)
//        File projecttFile = new File(projectPath).getParentFile();
//
//        //输入路径 ACM程序路径
////        D:\code\generator-Code\generator-Code-demo-project\acm-template
//        String srcPath = new File(projecttFile, "generator-Code-demo-project/acm-template").getAbsolutePath();
//        copyFileByHutool(srcPath, projectPath);
//
//        //生成动态文件  位置指定到 静态中
//        //D:\code\generator-Code\generator-Code-basic\src/main/resources/templates
//        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
//        String outputPath = projectPath + File.separator + "acm-template/src/com/cheng/acm/MainTemplate.java";
//
//        DynamicGenerator.doGenerate(inputPath, outputPath, model);
    }
}
