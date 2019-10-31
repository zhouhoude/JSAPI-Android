package com.zhd.jsapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.webview.webviewlib.framework.QCJSError;
import com.webview.webviewlib.framework.QCWebView;
import com.zhd.jsapi.event.QCJSActionEvent;
import com.zhd.jsapi.utils.QCJSActionName;
import com.zhd.jsapi.utils.QCJSActionRegisterIml;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class WebViewActivity extends AppCompatActivity {

    private QCWebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        webview = findViewById(R.id.webview);
        webview.setJSActionRegister(new QCJSActionRegisterIml());
        webview.loadUrl("");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(QCJSActionEvent event){
        if(event.getJsapi() == null || event.getJsapi().getContext() != this) return;
        if(event.getQcjsCallBack() == null) return;
        if(QCJSActionName.PopWindow.equals(event.getQcjsCallBack().getMethodName())){
            finish();
            event.getQcjsCallBack().normalCallback(QCJSError.JSCODE_SUCCESS);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
