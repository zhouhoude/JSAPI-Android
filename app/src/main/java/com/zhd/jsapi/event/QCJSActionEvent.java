package com.zhd.jsapi.event;

import com.webview.webviewlib.framework.QCJSAPIInterface;
import com.webview.webviewlib.framework.QCJSCallBack;
import com.webview.webviewlib.framework.QCJSDataRequest;

/**
 * @author liaoheng  liao_heng@126.com
 * @version V1.0
 * @title: QCJSActionEvent
 * @description: TODO
 * @date 2017/8/28 17:55
 */
public class QCJSActionEvent<T extends QCJSDataRequest>{
    QCJSAPIInterface jsapi;
    T data;
    QCJSCallBack qcjsCallBack;

    public QCJSActionEvent(QCJSAPIInterface jsapi, T data, QCJSCallBack qcjsCallBack) {
        this.jsapi = jsapi;
        this.data = data;
        this.qcjsCallBack = qcjsCallBack;
    }


    public QCJSAPIInterface getJsapi() {
        return jsapi;
    }

    public void setJsapi(QCJSAPIInterface jsapi) {
        this.jsapi = jsapi;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public QCJSCallBack getQcjsCallBack() {
        return qcjsCallBack;
    }

    public void setQcjsCallBack(QCJSCallBack qcjsCallBack) {
        this.qcjsCallBack = qcjsCallBack;
    }
}
