package com.system.archives.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.system.archives.entity.aa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class test {

    @PostMapping("/123")
    @ResponseBody
    public aa a1(String name, @RequestBody aa a1){
        log.info("已经调用接口");
        log.info("已经调用接口");
        log.info("已经调用接口");
        log.info("已经调用接口");
        log.info("已经调用接口");
        log.info("已经调用接口");
        log.info("已经调用接口");
        log.info("已经调用接口");
        log.info("已经调用接口");
        log.info("已经调用接口");

        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");


        System.out.println();
        //JSONUtils.toJSONString()


        return new aa(a1.getName(),a1.getList());
    }

    @GetMapping("/")
    public String a2(){
        return "forward:/axios.html";
    }

}




