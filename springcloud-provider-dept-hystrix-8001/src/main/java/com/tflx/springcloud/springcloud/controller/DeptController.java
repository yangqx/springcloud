package com.tflx.springcloud.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tflx.springcloud.springcloud.pojo.Dept;
import com.tflx.springcloud.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {


    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/list")
    public List<Dept> getAll(){
        return deptService.queryAll();
    }

    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        Dept dept = deptService.queryById(id);
        if(dept == null){
            throw new RuntimeException(id + "该用户不存在");
        }

        return dept;
    }

    public Dept hystrixGet(@PathVariable("id")Long id){
        Dept dept = new Dept().setDeptno(id).setDname("id => " + id + "没有对应的ID").setDb_source("no db ");
        return dept;
    }

}
