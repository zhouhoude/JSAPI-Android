package com.webview.webviewlib.framework;


import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhoude  344724288@qq.com
 * @version V1.0
 * @title: QCJSAction
 * @description: TODO
 * @date 2017/8/22 16:43
 */
public abstract class QCJSAction<T extends QCJSDataRequest> implements Serializable{
    private List<QCJSCallBack> callBackList = new ArrayList<>();

    public List<QCJSCallBack> getCallBackList() {
        return callBackList;
    }

    public void addAction(QCJSAPIInterface jsApiInfo, String dataStr, QCJSCallBack qcjsCallBack){
        try{
            Class<T> entityClass = getTClass();
            T data = JSON.parseObject(dataStr, entityClass);
            if(QCJSUtil.notNull(jsApiInfo, qcjsCallBack)){
                callBackList.add(qcjsCallBack);
                action(jsApiInfo, data, qcjsCallBack);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Class<T> getTClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void removeCallBack(QCJSCallBack qcjsCallBack){
        callBackList.remove(qcjsCallBack);
    }

    public abstract void action(QCJSAPIInterface jsApiInfo, T data, QCJSCallBack qcjsCallBack);

    public void normalCallBack(QCJSCallBack qcjsCallBack, int code, String message){
        QCJSDataBean response = new QCJSDataBean();
        response.setCode(code);
        response.setMessage(message);
        callBack(qcjsCallBack,response);
    }
    public void normalCallBack(QCJSCallBack qcjsCallBack, int code){
        qcjsCallBack.normalCallback(code);
    }

    public void normalCallBackNoRemove(QCJSCallBack qcjsCallBack, int code, String message){
        QCJSDataBean response = new QCJSDataBean();
        response.setCode(code);
        response.setMessage(message);
        callBackNoRemove(qcjsCallBack,response);
    }

    public void normalCallBackNoRemove(QCJSCallBack qcjsCallBack, int code){
        qcjsCallBack.normalCallback(code);
    }

    public void callBack(QCJSCallBack qcjsCallBack, QCJSDataBean response){
        qcjsCallBack.callback(response);
    }

    public void callBackNoRemove(QCJSCallBack qcjsCallBack, QCJSDataBean response){
        qcjsCallBack.callbackNoRemove(response);
    }
}
