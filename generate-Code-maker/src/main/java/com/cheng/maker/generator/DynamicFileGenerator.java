package com.cheng.maker.generator;

import cn.hutool.core.io.FileUtil;
import com.cheng.maker.model.DataModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 动态资源生成器
 */
public class DynamicFileGenerator {

    /**
     * 生成动态文件
     * @param inputPath
     * @param outPutPath
     * @param model
     * @throws IOException
     * @throws TemplateException
     */
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

        //文件不存在
        if(!FileUtil.exist(outPutPath)){
            FileUtil.touch(outPutPath);
        }


        //指定生成的文件  "MainTemplate.java"
        Writer out = new FileWriter(outPutPath);
        //生成
        template.process(model, out); // 生成文件后别忘了关闭哦 out.close();

    }
}
