package com.wuzx.bean;


import com.wuzx.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class ConsumerComponet {

    @Reference
    private HelloService helloService;

    public String sayHello(String name) {
        return helloService.ssayHello(name);
    }

}
