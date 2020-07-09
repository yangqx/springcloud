package com.tflx.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {


    @Bean
    public IRule myIRule(){
//        return new MyRandomRule();//默认是轮询   现在是我自定义的
        return new RandomRule();
    }
}
