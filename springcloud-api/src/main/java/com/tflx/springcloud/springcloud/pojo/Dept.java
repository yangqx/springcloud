package com.tflx.springcloud.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {
    private Long deptno;
    private String dname;
    //微服务  一个服务对应一个数据库；同一个信息可能存在不同数据库
    private String db_source;

    public Dept(String dname){
        this.dname = dname;
    }

//    public Long getDeptno() {
//        return deptno;
//    }
//
//    public void setDeptno(Long deptno) {
//        this.deptno = deptno;
//    }
//
//    public String getDname() {
//        return dname;
//    }
//
//    public void setDname(String dname) {
//        this.dname = dname;
//    }
//
//    public String getDb_source() {
//        return db_source;
//    }
//
//    public void setDb_source(String db_source) {
//        this.db_source = db_source;
//    }
}
