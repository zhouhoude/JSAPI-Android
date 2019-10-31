package com.webview.webviewlib.framework;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

import java.io.File;

/**
 * @author zhouhoude  344724288@qq.com
 * @version V1.0
 * @title: QCWebViewUtil
 * @description: TODO
 * @date 2017/8/23 14:25
 */
public class QCWebViewUtil {
    private static String APP_CACHE_DIRNAME = "/webcache/";

    public static void defaultSetting(QCWebView qcWebView, boolean webviewCache, String userAgent){
        qcWebView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        //WebView属性设置！！！
        WebSettings settings = qcWebView.getSettings();
        settings.setTextZoom(100);
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        if(webviewCache){
            settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }else {
            settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        }
        settings.setUseWideViewPort(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setBlockNetworkImage(true);
        //设置 缓存模式
        // 开启 DOM storage API 功能
        settings.setDomStorageEnabled(true);
        //开启 database storage API 功能
        settings.setDatabaseEnabled(true);
        String cacheDirPath = qcWebView.getContext().getFilesDir().getAbsolutePath()+APP_CACHE_DIRNAME;

        //设置数据库缓存路径
        settings.setDatabasePath(cacheDirPath);
        //设置  Application Caches 缓存目录
        settings.setAppCachePath(cacheDirPath);
        //开启 Application Caches 功能
        settings.setAppCacheEnabled(true);
        if(userAgent != null){
            settings.setUserAgentString(settings.getUserAgentString() + userAgent);
        }
    }

    public static void clearFile(Context context){
        //清理Webview缓存数据库
        File appCache = context.getExternalCacheDir().getAbsoluteFile();

        //删除APP 缓存目录
        if(appCache.exists()){
            deleteFile(appCache);
        }
        clearCache(context);
    }

    public static void clearCache(Context context){
        //QbSdk.clearAllWebViewCache()会导致原生崩溃
//        QbSdk.clearAllWebViewCache(context,true);
        //清理Webview缓存数据库
        try {
            new QCWebView(context).clearCache(true);
            context.deleteDatabase("webview.db");
            context.deleteDatabase("webviewCache.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = context.getCacheDir().getAbsoluteFile();

        //WebView 缓存文件
        File appCacheDir = new File(context.getFilesDir().getAbsolutePath()+APP_CACHE_DIRNAME);

        File webviewCacheDir = new File(context.getCacheDir().getAbsolutePath()+"/webviewCache");
        //删除APP 缓存目录
        if(file.exists()){
            deleteFile(file);
        }
        //删除webview 缓存目录
        if(webviewCacheDir.exists()){
            deleteFile(webviewCacheDir);
        }
        //删除webview 缓存 缓存目录
        if(appCacheDir.exists()){
            deleteFile(appCacheDir);
        }

    }

    /**
     * 递归删除 文件/文件夹
     *
     * @param file
     */
    private static void deleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    deleteFile(files[i]);
                }
            }
            file.delete();
        }
    }
}
