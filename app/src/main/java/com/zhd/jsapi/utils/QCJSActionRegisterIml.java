package com.zhd.jsapi.utils;

import com.webview.webviewlib.framework.QCJSActionRegister;
import com.webview.webviewlib.framework.QCWebView;
import com.zhd.jsapi.action.QCJS_CanGoBack;
import com.zhd.jsapi.action.QCJS_GoBack;
import com.zhd.jsapi.action.QCJS_PopWindow;

/**
 * @author liaoheng  liao_heng@126.com
 * @version V1.0
 * @title: QCJSActionIml
 * @description: TODO
 * @date 2017/8/24 17:52
 */
public class QCJSActionRegisterIml extends QCJSActionRegister {

    /*
    * 方法名：registerMethod
    * 描述：注册所有JS与原生交互的Api
    * */
    @Override
    public void registerMethod() {
        //canGoBack
        resigsterAction(QCJSActionName.CanGoBack, new QCJS_CanGoBack());
        //返回上一页
        resigsterAction(QCJSActionName.GoBack, new QCJS_GoBack());
        //关闭页面
        resigsterAction(QCJSActionName.PopWindow, new QCJS_PopWindow());

    }
}
