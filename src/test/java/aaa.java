import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.*;
import java.util.stream.Stream;


public class aaa {
    @Test
    public void a1(){
        bb b=(v)->{
            System.out.println("aa");
        };
        a1[] a1s = new a1[10];
        System.out.println();

        List<Integer> list = Empy.getlist();
        list.toString();
        Stream<Integer> stream = list.stream();
        stream.filter((s)->{
            return s>80;
        }).skip(2).limit(3).distinct().forEach(System.out::println);
        /* filter skip limit distinct 都是筛选与切片
        * */
        list.stream().map((s)->{
            return s.getClass();
        }).forEach(System.out::println);
        /* map是映射 中间操作
        * */

        /* 排序 sorted 中间操作
        * */

        /* foreach allmatch anymatch findfirst
        count max min  conllect
        归约 reduce 以上都是终端操作
        * */
        list.stream().sorted().forEach(System.out::println);
        list.stream().sorted().reduce(0,(a1,a2)->{
            return a1+a2;
        });
       // list.stream().max()
        /* 收集 collect
        * */
    }
}
