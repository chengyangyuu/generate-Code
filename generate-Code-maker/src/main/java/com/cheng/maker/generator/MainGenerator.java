package com.cheng.maker.generator;

import com.cheng.maker.meta.Meta;
import com.cheng.maker.meta.MetaManager;

public class MainGenerator {
    public static void main(String[] args) {
        Meta meta = MetaManager.getObject();
        System.out.println(meta);
    }

}
