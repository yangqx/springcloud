package com.tflx.springcloud.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {//等同  spring  applicationContenx.xml

    //配置负载均衡 实现 RestTemplate
    //IRule
    //RoundRobinRule 轮询
    //RandomRule随机
    //RetryRule
    //AvailabilityFilteringRule  先过滤掉不可用的  然后轮询
    @Bean
    @LoadBalanced  //Rabbin
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }




}
