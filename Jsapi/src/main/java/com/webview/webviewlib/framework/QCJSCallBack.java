package com.webview.webviewlib.framework;

import java.io.Serializable;

/**
 * @author zhouhoude  344724288@qq.com
 * @version V1.0
 * @title: QCJSCallBack
 * @description: TODO
 * @date 2017/8/22 17:09
 */
public abstract class QCJSCallBack implements Serializable{
    public String methodName;
    public String callBackid;

    QCJSCallBack(String methodName, String callBackid){
        this.callBackid = callBackid;
        this.methodName = methodName;
    }

    public String getCallBackid() {
        return callBackid;
    }

    public String getMethodName() {
        return methodName;
    }

    public void normalCallback(int code){
        QCJSDataBean response = new QCJSDataBean();
        response.setCode(code);
        response.setMessage(QCJSError.getJSMessage(code));
        callback(response);
    }

    public void normalCallback(int code, String message){
        QCJSDataBean response = new QCJSDataBean();
        response.setCode(code);
        response.setMessage(message);
        callback(response);
    }

    public void normalCallbackNoremove(int code){
        QCJSDataBean response = new QCJSDataBean();
        response.setCode(code);
        response.setMessage(QCJSError.getJSMessage(code));
        callbackNoRemove(response);
    }

    public void normalCallbackNoremove(int code, String message){
        QCJSDataBean response = new QCJSDataBean();
        response.setCode(code);
        response.setMessage(message);
        callbackNoRemove(response);
    }

    public abstract void callback(QCJSDataBean response);
    public abstract void callbackNoRemove(QCJSDataBean response);
}
