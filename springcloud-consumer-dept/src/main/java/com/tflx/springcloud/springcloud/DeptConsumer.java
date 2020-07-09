package com.tflx.springcloud.springcloud;

import com.tflx.springcloud.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

//ribbon 与 eureka整合后，不用关心 IP地址和端口号
@SpringBootApplication
@EnableEurekaClient
//微服务启动的时候 加载自定义的ribbon
@RibbonClient(name="SPRINGCLOUD-PROVIDER-DEPT",configuration = MyRule.class)
public class DeptConsumer {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer.class,args);
    }
}
