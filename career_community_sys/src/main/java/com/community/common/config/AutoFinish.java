package com.community.common.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: ruoyi
 * @BelongsPackage: com.community.common.config
 * @Author: GH
 * @CreateTime: 2024-01-07  22:19
 * @Description: TODO
 * @Version: 1.0
 */


@Component
public class AutoFinish implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("应用已经准备就绪 ... 启动浏览器并自动加载指定的页面 ... ");
        try {
            //指定自己项目的路径
            Runtime.getRuntime().exec("cmd   /c   start   http://localhost:80");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

