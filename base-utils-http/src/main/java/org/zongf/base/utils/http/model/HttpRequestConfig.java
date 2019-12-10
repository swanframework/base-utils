package org.zongf.base.utils.http.model;

import org.zongf.base.utils.common.enums.CharsetEnum;

import javax.swing.*;

/**
 * @author zongf
 * @date 2019-12-05
 */
public class HttpRequestConfig {

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

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public int getConnnectTimeout() {
        return connnectTimeout;
    }

    public void setConnnectTimeout(int connnectTimeout) {
        this.connnectTimeout = connnectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public CharsetEnum getReqeustCharset() {
        return reqeustCharset;
    }

    public void setReqeustCharset(CharsetEnum reqeustCharset) {
        this.reqeustCharset = reqeustCharset;
    }

    public CharsetEnum getResponseCharset() {
        return responseCharset;
    }

    public void setResponseCharset(CharsetEnum responseCharset) {
        this.responseCharset = responseCharset;
    }
}
