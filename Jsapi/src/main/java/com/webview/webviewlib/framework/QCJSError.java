package com.webview.webviewlib.framework;

/**
 * @author zhouhoude  344724288@qq.com
 * @version V1.0
 * @title: QCJSErrorCode
 * @description: TODO
 * @date 2017/8/22 11:55
 */
public class QCJSError {
    // 操作成功
    public static final int JSCODE_SUCCESS = 0;
    // 方法不支持
    public static final int JSCODE_NO_METHOD = 1000;
    // 参数错误
    public static final int JSCODE_PARAME_ERROR = 1001;
    // 处理失败
    public static final int JSCODE_FAILED = 1002;
    // 取消操作
    public static final int JSCODE_CANCEL = 1003;
    // 无此权限
    public static final int JSCODE_NO_PERMISSION = 1004;
    // 客户端初始化失败
    public static final int JSCODE_CLIENT_INIT_FAILED = 1005;
    // 客户端处理失败
    public static final int JSCODE_CLIENT_FAILED = 1006;
    // 客户端版本过低
    public static final int JSCODE_LOW_VERSION = 1007;
    // 客户端版本过低
    public static final int JSCODE_LOW_OS_VERSION = 1008;


    public static String getJSMessage(int code){
        switch (code){
            case JSCODE_SUCCESS:
                return "操作成功";
            case JSCODE_NO_METHOD:
                return "方法不支持";
            case JSCODE_PARAME_ERROR:
                return "参数错误";
            case JSCODE_FAILED:
                return "处理失败";
            case JSCODE_CANCEL:
                return "取消操作";
            case JSCODE_NO_PERMISSION:
                return "无此权限";
            case JSCODE_CLIENT_INIT_FAILED:
                return "客户端初始化失败";
            case JSCODE_CLIENT_FAILED:
                return "客户端处理失败";
            case JSCODE_LOW_VERSION:
                return "客户端版本过低";
            case JSCODE_LOW_OS_VERSION:
                return "客户端OS版本过低";
            default:
                return null;
        }
    }
}
