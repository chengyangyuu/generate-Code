package ${basePackage}.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 *静态资源生成器
 */
public class StaticGenerator {

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
