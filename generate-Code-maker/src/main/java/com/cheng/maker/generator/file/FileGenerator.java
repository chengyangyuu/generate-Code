package com.cheng.maker.generator.file;

import com.cheng.maker.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

import static com.cheng.maker.generator.file.StaticFileGenerator.copyFileByHutool;

/**
 * 核心生成器
 */
public class FileGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //创建数据模型
        DataModel dataModel = new DataModel();
        dataModel.setAuthor("ben");
        dataModel.setLoop(false);
        dataModel.setOutputText("求和结果");
        doGenerate(dataModel);
    }
    public static void doGenerate(Object model) throws TemplateException, IOException {
        //D:\code\generator-Code\generator-Code-basic
        String projectPath = System.getProperty("user.dir");
        //获取父项目的路径(gene-Code)
        File projecttFile = new File(projectPath).getParentFile();

        //输入路径 ACM程序路径
//        D:\code\generator-Code\generator-Code-demo-project\acm-template
        String srcPath = new File(projecttFile, "generator-Code-demo-project/acm-template").getAbsolutePath();
        StaticFileGenerator.copyFileByHutool(srcPath, projectPath);

        //生成动态文件  位置指定到 静态中
        //D:\code\generator-Code\generator-Code-basic\src/main/resources/templates
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "acm-template/src/com/cheng/acm/MainTemplate.java";

        DynamicFileGenerator.doGenerate(inputPath,outputPath,model);
    }
}
