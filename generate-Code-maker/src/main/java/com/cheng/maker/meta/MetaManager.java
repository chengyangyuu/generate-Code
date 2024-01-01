package com.cheng.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManager {

    private static volatile Meta meta;

    public static Meta getObject() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    //初始化赋值
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    public static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta initMeta = JSONUtil.toBean(metaJson, Meta.class);
        //防止用户乱输 对参数校验
        return initMeta;
    }

}
