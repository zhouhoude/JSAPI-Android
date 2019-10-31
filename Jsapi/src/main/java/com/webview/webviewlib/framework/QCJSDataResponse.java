package com.webview.webviewlib.framework;

/**
 * @author zhouhoude  344724288@qq.com
 * @version V1.0
 * @title: QCJSDataResponse
 * @description: TODO
 * @date 2017/8/24 11:25
 */
public class QCJSDataResponse {
    private String callbackid;
    private QCJSDataBean data;

    public QCJSDataBean getData() {
        return data;
    }

    public void setData(QCJSDataBean data) {
        this.data = data;
    }

    public String getCallbackid() {
        return callbackid;
    }

    public void setCallbackId(String callbackId) {
        this.callbackid = callbackId;
    }
}
