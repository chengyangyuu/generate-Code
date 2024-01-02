package com.cheng.generator;

import com.cheng.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 动态资源生成器
 */
public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        //D:\code\generator-Code\generator-Code-basic
        String projectPath = System.getProperty("user.dir");
        //D:\code\generator-Code\generator-Code-basic\src/main/resources/templates
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";
        //创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("ben");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果");
        doGenerate(inputPath, outputPath, mainTemplateConfig);

    }

    public static void doGenerate(String inputPath, String outPutPath, Object model) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        // 指定模板文件所在的路径 src/main/resources/templates"
        configuration.setDirectoryForTemplateLoading(new File(inputPath).getParentFile());
        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        //生成模板对象 名字从input提取
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        //指定生成的文件  "MainTemplate.java"
        Writer out = new FileWriter(outPutPath);
        //生成
        template.process(model, out); // 生成文件后别忘了关闭哦 out.close();

    }
}
