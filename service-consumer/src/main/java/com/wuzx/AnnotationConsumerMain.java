package com.wuzx;

import com.wuzx.bean.ConsumerComponet;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

public class AnnotationConsumerMain {


    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();


        final ConsumerComponet consumerComponet = context.getBean(ConsumerComponet.class);

        while (true) {
            for (int i = 0; i < 1000; i++) {


                new Thread(()->{

                    final String hello = consumerComponet.sayHello("world");

                    System.out.println("result" + hello);

                }).start();
            }
        }
    }


    @Configuration
    @EnableDubbo
    @PropertySource("classpath:/dubbo-consumer.properties")
    @ComponentScan(basePackages = "com.wuzx.bean")
    static class ConsumerConfiguration {

    }

}
