package com.zhd.jsapi.action;

import com.webview.webviewlib.framework.QCJSAPIInterface;
import com.webview.webviewlib.framework.QCJSAction;
import com.webview.webviewlib.framework.QCJSCallBack;
import com.webview.webviewlib.framework.QCJSDataRequest;
import com.zhd.jsapi.event.QCJSActionEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * @author liaoheng  liao_heng@126.com
 * @version V1.0
 * @title: QCJSGoBack
 * @description: TODO
 * @date 2017/8/28 14:53
 */
public class QCJS_PopWindow extends QCJSAction<QCJSDataRequest>{

    @Override
    public void action(QCJSAPIInterface jsApiInfo, QCJSDataRequest data, QCJSCallBack qcjsCallBack) {
        EventBus.getDefault().post(new QCJSActionEvent(jsApiInfo, data, qcjsCallBack));
    }
}
