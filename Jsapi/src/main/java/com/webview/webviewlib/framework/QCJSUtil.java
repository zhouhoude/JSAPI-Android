package com.webview.webviewlib.framework;

import android.app.Activity;

import com.webview.webviewlib.framework.QCJSAPIInterface;
import com.webview.webviewlib.framework.QCJSCallBack;
import com.webview.webviewlib.framework.QCJSError;

/**
 * Created by zhujingcheng on 2018/12/22.
 */

public class QCJSUtil {
    public static boolean notNull(QCJSAPIInterface jsApi,QCJSCallBack qcjsCallBack){
        if (jsApi == null || jsApi.getContext() == null || !(jsApi.getContext() instanceof Activity)) {
            qcjsCallBack.normalCallback(QCJSError.JSCODE_CLIENT_INIT_FAILED);
            return false;
        }
        if(qcjsCallBack != null) {
            qcjsCallBack.normalCallback(QCJSError.JSCODE_CLIENT_INIT_FAILED);
            return false;
        }
        return true;
    }
}
