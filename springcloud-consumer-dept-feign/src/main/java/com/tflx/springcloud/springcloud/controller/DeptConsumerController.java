package com.tflx.springcloud.springcloud.controller;

import com.tflx.springcloud.springcloud.pojo.Dept;
import com.tflx.springcloud.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerController {
//   消费者  不应该有service
    //(url,实体 Map,Class<T> responseType)
//    @Autowired
//    private RestTemplate restTemplate;//提供多种便捷访问远程http服务的方法  简单的restFul服务模板

    @Autowired
    private DeptClientService deptClientService ;

    //ribbon    我们通过服务名称来获取访问地址
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
//    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){

//        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
        return this.deptClientService.addDept(dept);
    }
    @RequestMapping("/consumer/dept/get/{id}")

    public Dept get(@PathVariable("id") Long id){
//        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);

        return this.deptClientService.queryById(id);
    }


    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
//        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
        System.out.println(12456);
        return this.deptClientService.queryAll() ;
    }

}
