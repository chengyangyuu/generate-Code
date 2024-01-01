package com.cheng.maker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 *静态资源生成器
 */
public class StaticFileGenerator {

    /**
     * 生成静态文件
     * @param srcPath
     * @param destPath
     */
    public static void copyFileByHutool(String srcPath, String destPath) {
        FileUtil.copy(srcPath, destPath, false);
    }

}
