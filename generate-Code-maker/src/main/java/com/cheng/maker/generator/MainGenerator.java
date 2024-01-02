package com.cheng.maker.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.cheng.maker.generator.file.DynamicFileGenerator;
import com.cheng.maker.meta.Meta;
import com.cheng.maker.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        Meta meta = MetaManager.getObject();
        System.out.println(meta);
        //D:\code\generator-Code\generator-Code-maker
        String projectPath = System.getProperty("user.dir");
        //新建一个目标地址
        String outputPath = projectPath + File.separator + "generated" + File.separator + meta.getName();
        if (!FileUtil.exist(outputPath)) {
            FileUtil.mkdir(outputPath);
        }
        //读取resource目录
        ClassPathResource classPathResource = new ClassPathResource("");
        String inputResourcePath = classPathResource.getAbsolutePath();

        //java基础包路径
        //com.cheng
        String basePackage = meta.getBasePackage();
        String outputBasePackagePath = StrUtil.join("/", StrUtil.split(basePackage, "."));
        String outputBasePackageJavaPath = outputPath + File.separator + "src/main/java/" + outputBasePackagePath;

        String inputFilePath;
        String outputFilePath;
        //Data.model
        inputFilePath = inputResourcePath + File.separator + "templates/java/model/DataModel.java.ftl";
        outputFilePath = outputBasePackageJavaPath + "/model/Data.Model.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);

        //cli/command/GenerateCommand.java.ftl
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/GenerateCommand.java.ftl";
        outputFilePath = outputBasePackageJavaPath + "/cli/command/GenerateCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);

        //java/cli/command/ConfigCommand.java.ftl
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ConfigCommand.java.ftl";
        outputFilePath = outputBasePackageJavaPath + "/cli/command/ConfigCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);

        //java/cli/command/ListCommand.java.ftl
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ListCommand.java.ftl";
        outputFilePath = outputBasePackageJavaPath + "/cli/command/ListCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);

        //java/cli/CommandExecutor.java.ftl
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/CommandExecutor.java.ftl";
        outputFilePath = outputBasePackageJavaPath + "/cli/CommandExecutor.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);

        //templates/java/Main.java.ftl
        inputFilePath = inputResourcePath + File.separator + "templates/java/Main.java.ftl";
        outputFilePath = outputBasePackageJavaPath + "/Main.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);

        // generator.DynamicGenerator
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/DynamicGenerator.java.ftl";
        outputFilePath = outputBasePackageJavaPath + "/generator/DynamicGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath , outputFilePath, meta);

        // generator.MainGenerator
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/MainGenerator.java.ftl";
        outputFilePath = outputBasePackageJavaPath + "/generator/MainGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath , outputFilePath, meta); 

        // generator.StaticGenerator
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/StaticGenerator.java.ftl";
        outputFilePath = outputBasePackageJavaPath + "/generator/StaticGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath , outputFilePath, meta);

    }

}
