package org.zongf.base.utils.common;

import org.junit.Test;
import org.zongf.base.utils.common.enums.CharsetEnum;
import org.zongf.base.utils.common.util.URLCoderUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zongf
 * @date 2019-12-04
 */
public class HelloTest {

    @Test
    public void test(){

//        String encodeStr = URLCoderUtil.encode("你们好he  %%&!'llo", CharsetEnum.GBK);
//        System.out.println("encode:" + encodeStr);
//        System.out.println("decode:" + URLCoderUtil.decode(encodeStr, CharsetEnum.GBK));
//
////        Charset.availableCharsets().forEach((key, val) -> System.out.println(key + ":" + val));

        hello("zhangsan");
        hello("lisi", "AAA");
        hello("wangwu", "111", "ccc");
    }


    public static void hello(String name, String... msg){
        System.out.println(name + ":" + Arrays.asList(msg));
    }
}
