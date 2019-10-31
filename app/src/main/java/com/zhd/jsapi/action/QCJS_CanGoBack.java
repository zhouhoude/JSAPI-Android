package com.zhd.jsapi.action;

import com.webview.webviewlib.framework.QCJSAPIInterface;
import com.webview.webviewlib.framework.QCJSAction;
import com.webview.webviewlib.framework.QCJSCallBack;
import com.webview.webviewlib.framework.QCJSDataBean;
import com.webview.webviewlib.framework.QCJSDataRequest;
import com.webview.webviewlib.framework.QCJSError;
import com.zhd.jsapi.bean.QCJSCanGoBackResponseBean;

/**
 * @author liaoheng  liao_heng@126.com
 * @version V1.0
 * @title: QCJScanGoBack
 * @description: TODO
 * @date 2017/8/28 14:53
 */
public class QCJS_CanGoBack extends QCJSAction<QCJSDataRequest>{

    @Override
    public void action(QCJSAPIInterface jsApiInfo, QCJSDataRequest data, QCJSCallBack qcjsCallBack) {
        QCJSCanGoBackResponseBean responseBean = new QCJSCanGoBackResponseBean();
        if(jsApiInfo.getWebView().canGoBack()){
            responseBean.setCanGoBack("1");
        }else{
            responseBean.setCanGoBack("0");
        }
        QCJSDataBean response = new QCJSDataBean();
        response.setCode(QCJSError.JSCODE_SUCCESS);
        response.setMessage(QCJSError.getJSMessage(QCJSError.JSCODE_SUCCESS));
        response.setData(responseBean);
        qcjsCallBack.callback(response);
    }
}
