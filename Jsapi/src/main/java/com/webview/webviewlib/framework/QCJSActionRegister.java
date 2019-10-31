package com.webview.webviewlib.framework;


/**
 * @author zhouhoude  344724288@qq.com
 * @version V1.0
 * @title: QCJSActionRegister
 * @description: TODO
 * @date 2017/8/24 16:55
 */
public abstract class QCJSActionRegister {

    QCWebView webView;

    public void setWebView(QCWebView webView) {
        this.webView = webView;
        registerMethod();
    }

    public void resigsterAction(String javaMethod, QCJSAction action){
        webView.resigsterAction(javaMethod,action);
    }

    public abstract void registerMethod();
}
