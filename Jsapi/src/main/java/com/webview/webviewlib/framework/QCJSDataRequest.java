package com.webview.webviewlib.framework;

/**
 * @author zhouhoude  344724288@qq.com
 * @version V1.0
 * @title: QCJSData
 * @description: TODO
 * @date 2017/8/22 9:50
 */
public class QCJSDataRequest {
    private String method;
    private String callback;
    private String params;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
}
