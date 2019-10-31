package com.webview.webviewlib.framework;


import android.app.Activity;
import android.content.Context;

/**
 * @author zhouhoude  344724288@qq.com
 * @version V1.0
 * @title: QCJSAPIInterface
 * @description: TODO
 * @date 2017/8/22 9:36
 */
public interface QCJSAPIInterface {

    void initQCJSAPI(QCWebView webview);

    Context getContext();

    Activity getActivity();

    QCWebView getWebView();

    void runUiThread(Runnable runnable);

    void appCallback(String callbackId, QCJSDataBean responseBean);

    void callApp(String doc);

    void resigsterAction(String javaMethod, QCJSAction action);
}
