package com.webview.webviewlib.framework;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;

import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhoude  344724288@qq.com
 * @version V1.0
 * @title: MyWebView
 * @description: TODO
 * @date 2017/8/17 17:17
 */
public class QCWebView extends WebView {

    QCX5WebviewJSAPI qcx5WebviewJSAPI;
    QCJSActionRegister qcjsActionRegister;
    QCJSInterceptor interceptor;

    public void initQCJSAPI() {
        if(qcx5WebviewJSAPI != null){
            qcx5WebviewJSAPI.initQCJSAPI(this);
        }
    }

    public void setInterceptor(QCJSInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    protected QCJSInterceptor getInterceptor() {
        return interceptor;
    }

    public void defaultSetting(boolean webviewCache, String userAgent){
        QCWebViewUtil.defaultSetting(this, webviewCache,userAgent);
    }

    public void setJSActionRegister(QCJSActionRegister qcjsActionRegister) {
        if(qcjsActionRegister != null){
            qcjsActionRegister.setWebView(this);
            this.qcjsActionRegister = qcjsActionRegister;
        }
    }

    public void resigsterAction(String javaMethod, QCJSAction action){
        if(qcx5WebviewJSAPI != null){
            qcx5WebviewJSAPI.resigsterAction(javaMethod, action);
        }
    }

    public QCWebView(Context context) {
        super(context);
        qcx5WebviewJSAPI = new QCX5WebviewJSAPI(this);
    }

    public QCWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        qcx5WebviewJSAPI = new QCX5WebviewJSAPI(this);
    }

    public QCWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        qcx5WebviewJSAPI = new QCX5WebviewJSAPI(this);
    }

    public QCWebView(Context context, AttributeSet attributeSet, int i, boolean b) {
        super(context, attributeSet, i, b);
        qcx5WebviewJSAPI = new QCX5WebviewJSAPI(this);
    }

    public QCWebView(Context context, AttributeSet attributeSet, int i, Map<String, Object> map, boolean b) {
        super(context, attributeSet, i, map, b);
        qcx5WebviewJSAPI = new QCX5WebviewJSAPI(this);
    }

    @Override
    public void addJavascriptInterface(Object o, String s) {
        super.addJavascriptInterface(o, s);
    }

    public void setWebChromeClient(QCWebChromeClient webChromeClient) {
        super.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(QCWebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
    }

    @Override
    public void loadUrl(String s) {
        s = s.replaceAll("\\+","%2B");
        super.loadUrl(s);
    }

    @Override
    public void clearCache(boolean b) {
        super.clearCache(b);
    }

    @Override
    public WebSettings getSettings() {
        return super.getSettings();
    }

}
