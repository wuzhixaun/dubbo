package com.wuzx.service.impl;

import com.wuzx.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName HelloServiceImpl.java
 * @Description TODO
 * @createTime 2022年02月22日 14:34:00
 */

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String ssayHello(String name) {
        return String.format("hello:%s", name);
    }
}
