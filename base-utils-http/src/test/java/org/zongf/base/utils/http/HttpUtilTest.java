package org.zongf.base.utils.http;

import org.junit.Test;
import org.zongf.base.utils.http.model.HttpRequestHeaders;
import org.zongf.base.utils.http.model.HttpRequestParams;
import org.zongf.base.utils.http.util.HttpUtil;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/** http工具类
 * @author zongf
 * @date 2019-12-04
 */
public class HttpUtilTest {



    @Test
    public void test(){
        String url = "https://www.baidu.com";

        String html = HttpUtil.doGet(url, null, null);
        System.out.println(html);
    }

    @Test
    public void test2(){
        String url = "http://localhost:9100/hello/say";
        HttpRequestParams paramMap = new HttpRequestParams();
        paramMap.put("name", "'\"&%zhangsan");
        paramMap.put("nickName", "'\"&%nickname");

        HttpRequestHeaders headerMap = new HttpRequestHeaders();
        headerMap.put("header1", "1111");
        headerMap.put("header2", "2222");

        String result = HttpUtil.doGet(url, paramMap, headerMap);

        System.out.println(result);
    }


}
