package org.zongf.base.utils.http.builder;

import org.zongf.base.utils.common.enums.CharsetEnum;
import org.zongf.base.utils.http.model.HttpRequestConfig;

/**
 * @author zongf
 * @date 2019-12-05
 */
public class HttpRequestConfigBuilder {


    // 代理服务器ip
    private String proxyHost;

    // 代理服务器端口号
    private int proxyPort;

    // 连接超时
    private int connnectTimeout;

    // 读取超时
    private int readTimeout;

    // 请求编码格式
    private CharsetEnum reqeustCharset;

    // 响应格式
    private CharsetEnum responseCharset;


    private static HttpRequestConfig httpRequestConfig;


    public HttpRequestConfigBuilder create(){
        return new HttpRequestConfigBuilder();
    }

    public HttpRequestConfigBuilder proxy(String proxyHost, int proxyPort){
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        return this;
    }

    public HttpRequestConfigBuilder connectTimeout(int connnectTimeout) {
        this.connnectTimeout = connnectTimeout;
        return this;
    }

    public HttpRequestConfigBuilder readTimeout(int readTimeout){
        this.readTimeout = readTimeout;
        return this;
    }

    public HttpRequestConfig build(){
        HttpRequestConfig config = new HttpRequestConfig();
        config.setProxyHost(this.proxyHost);
        config.setProxyPort(this.proxyPort);
        config.setConnnectTimeout(this.connnectTimeout);
        config.setReadTimeout(this.readTimeout);
        config.setReqeustCharset(this.reqeustCharset);
        config.setResponseCharset(this.responseCharset);
        return config;
    }



}
