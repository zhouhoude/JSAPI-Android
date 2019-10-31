package com.webview.webviewlib.framework;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSONObject;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouhoude  344724288@qq.com
 * @version V1.0
 * @title: QCX5WebviewJSAPI
 * @description: TODO
 * @date 2017/8/22 11:19
 */
public class QCX5WebviewJSAPI implements QCJSAPIInterface {
    WeakReference<QCWebView> qcWebViewWeakReference;
    Map<String, QCJSAction>  actionMap;

    public QCX5WebviewJSAPI(QCWebView webview){
        this.qcWebViewWeakReference = new WeakReference<QCWebView>(webview);
        actionMap = new HashMap<>();
        initQCJSAPI(webview);
    }

    public QCWebView getWebView() {
        return qcWebViewWeakReference.get();
    }

    @Override
    public Context getContext(){
        if(getWebView() != null){
            return getWebView().getContext();
        }
        return null;
    }

    @Override
    public Activity getActivity(){
        if(getWebView() == null){
            return null;
        }
        if(getWebView().getContext() == null){
            return null;
        }
        if(getWebView().getContext() instanceof Activity){
            return (Activity) getWebView().getContext();
        }else {
            return null;
        }
    }

    @Override
    public void runUiThread(Runnable runnable) {
        if(getActivity() != null){
            getActivity().runOnUiThread(runnable);
        }
    }

    @Override
    public void initQCJSAPI(QCWebView webview) {
        if(getWebView() != null){
            getWebView().addJavascriptInterface(this, "QCJSInterface");
        }
    }

    @Override
    public void appCallback(final String callbackId, final QCJSDataBean response) {
        if(getWebView() == null || callbackId == null){
            Log.e("QCWebView","QCX5WebviewJSAPI.appCallback has null webview or callbackId");
            return;
        }
        if(getActivity()!=null){
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(getWebView() != null){
                        QCJSDataResponse responseBean = new QCJSDataResponse();
                        responseBean.setCallbackId(callbackId);
                        responseBean.setData(response);
                        QCWebView qcWebView = getWebView();
                        String callback = "javascript:QCJSAPI.appCallback("+ JSONObject.toJSONString(responseBean) +")";
                        qcWebView.loadUrl(callback,null);
                    }
                }
            });
        }
    }

    @Override
    @JavascriptInterface
    public void callApp(final String doc) {
        if(getWebView() != null && getContext() != null && getContext() instanceof Activity){
            ((Activity) getContext()).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    controller(doc);
                }
            });
        }
    }

    private void controller(String doc){
        QCJSInterceptor interceptor = getWebView().getInterceptor();
        final QCJSDataRequest request = JSONObject.parseObject(doc, QCJSDataRequest.class);
        if(request != null && request.getMethod() != null && !"".equals(request.getMethod())){
            if(interceptor != null && !interceptor.interceptor(getWebView().getUrl(), request.getMethod())){
                QCJSDataBean bean = new QCJSDataBean();
                bean.setCode(QCJSError.JSCODE_NO_METHOD);
                bean.setMessage(QCJSError.getJSMessage(QCJSError.JSCODE_NO_METHOD));
                appCallback(request.getCallback(),bean);
                return;
            }
            if(actionMap != null && actionMap.get(request.getMethod()) != null){
                actionMap.get(request.getMethod()).addAction(QCX5WebviewJSAPI.this, request.getParams(), new QCJSCallBack(request.getMethod(), request.getCallback()){
                    @Override
                    public void callback(QCJSDataBean response) {
                        appCallback(getCallBackid(), response);
                        actionMap.get(getMethodName()).removeCallBack(this);
                    }

                    @Override
                    public void callbackNoRemove(QCJSDataBean response) {
                        appCallback(getCallBackid(), response);
                    }
                });
            }else{
                QCJSDataBean bean = new QCJSDataBean();
                bean.setCode(QCJSError.JSCODE_NO_METHOD);
                bean.setMessage(QCJSError.getJSMessage(QCJSError.JSCODE_NO_METHOD));
                appCallback(request.getCallback(),bean);
            }
        }
    }

    @Override
    public void resigsterAction(String javaMethod, QCJSAction action){
        if(actionMap != null){
            actionMap.put(javaMethod, action);
        }
    }
}
