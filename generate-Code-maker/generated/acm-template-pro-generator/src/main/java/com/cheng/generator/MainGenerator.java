package com.cheng.generator;

import com.cheng.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
* 核心生成器
*/
public class MainGenerator {

public static void doGenerate(Object model) throws TemplateException, IOException {

    String inputRootPath = "/generate-Code/generate-Code-demo-project/acm-template-pro";
    String outputRootPath = "generated";
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
        inputPath = new File(inputRootPath, ".gitignore").getAbsolutePath();
        outputPath = new File(outputRootPath, ".gitignore").getAbsolutePath();
            StaticGenerator.copyFileByHutool(inputPath, outputPath);
        inputPath = new File(inputRootPath, "README.md").getAbsolutePath();
        outputPath = new File(outputRootPath, "README.md").getAbsolutePath();
            StaticGenerator.copyFileByHutool(inputPath, outputPath);
    }
}
