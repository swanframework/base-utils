package org.zongf.base.utils.http.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.zongf.base.utils.common.util.CloseUtil;
import org.zongf.base.utils.common.util.URLCoderUtil;
import org.zongf.base.utils.http.model.HttpRequestHeaders;
import org.zongf.base.utils.http.model.HttpRequestParams;

import java.io.IOException;

/** Http 工具类
 * @author zongf
 * @date 2019-12-04
 */
public class HttpUtil {
    /*
        // 无参数函数
        public static String doGet(String url);
        public static String doGet(String url, List<Header> mapHeader);
        public static String doGet(String url, HttpRequestConfig config);
        public static String doGet(String url, List<Header> headerList, HttpRequestConfig config);

        public static String doGet(String url, Map<String, Objectr> params);
        public static String doGet(STring url, Map<String, Object> params, List<Header> headerList);
        public static String doGet(String url, Map<String, Object> prarams, HttpRequestConfig config);
        public static String doGet(String url, Map<String, Object> prarams, List<Header> headerList, HttpRequestConfig config);

        public static String doGet(String url, String jsonBody);
        public static String doGet(String url, String jsboBody, List<Header> headerList);
        public static String doGet(String url, String jsonBody, HttpRequestConfig config);
        public static String doGet(String url, String jsonBody, List<Header> hdeaderList, HttpRequestConfig config);

     */

//    public static String doGet(String url, Map<String, Object> params, )


    public static String doGet(String url, HttpRequestParams httpParams, HttpRequestHeaders headers){

        CloseableHttpClient httpClient = HttpClientBuilder.create()

                .build();

        CloseableHttpResponse response = null;
        try {

            StringBuffer paramSb = new StringBuffer();
            paramSb.append(url).append("?");

            httpParams.forEach((key, val) -> paramSb.append(key).append("=").append(URLCoderUtil.encode(String.valueOf(val))).append("&"));

            paramSb.deleteCharAt(paramSb.length() - 1);
            HttpGet httpGet = new HttpGet(paramSb.toString());

            headers.forEach((key, val) -> httpGet.setHeader(key, String.valueOf(val)));
            System.out.println(paramSb.toString());
            response = httpClient.execute(httpGet);



            HttpEntity entity = response.getEntity();

            return EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(response, httpClient);
        }

        return null;
    }



}
