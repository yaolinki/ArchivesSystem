package com.system.archives.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
//@AllArgsConstructor
@NoArgsConstructor
public class aa {
    public Integer name = 123;

    //日期格式化
/*    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public LocalDateTime time;*/

    public List<String> list=new ArrayList<>();

    //    public aa() {
//    }
//
//    public aa(String name) {
//        this.name = name;
//    }



    public aa(Integer name,List<String> list) {
        this.name = name;
        this.list=list;




//        list.add("aaaaaaa");
//        list.add("bbbbbbb");
//        list.add("ccccccc");
//        list.add("ddddddd");
//        list.add("hello,world");
    }
}
