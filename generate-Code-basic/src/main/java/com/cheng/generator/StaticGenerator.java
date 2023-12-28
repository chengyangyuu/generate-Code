package com.cheng.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 *静态资源生成器
 */
public class StaticGenerator {
    public static void main(String[] args) {
        //获取整个项目的根目录(basic)
//        D:\code\generate-Code\generate-Code-basic
        String projectPath = System.getProperty("user.dir");

        //获取父项目的路径(gene-Code)
        File projecttFile = new File(projectPath).getParentFile();

        //输入路径 ACM程序路径
//        D:\code\generate-Code\generate-Code-demo-project\acm-template
        String srcPath = new File(projecttFile, "generate-Code-demo-project/acm-template").getAbsolutePath();

        copyFileByHutool(srcPath, projectPath);
    }

    /**
     * Params:
     * @param srcPath 源文件或目录
     * @param destPath 目标文件或目录，目标不存在会自动创建（目录、文件都创建）
     * isOverride – 是否覆盖目标文件
     */
    public static void copyFileByHutool(String srcPath, String destPath) {
        FileUtil.copy(srcPath, destPath, false);
    }

}
