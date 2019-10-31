package com.webview.webviewlib.framework;

/**
 * Created by zhouhoude_mac on 2018/5/10.
 */

public interface QCJSInterceptor {
    boolean interceptor(String url, String method);
}
