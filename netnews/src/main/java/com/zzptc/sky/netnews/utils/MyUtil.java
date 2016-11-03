package com.zzptc.sky.netnews.utils;

import android.app.Activity;
import android.content.SharedPreferences;

import com.zzptc.sky.netnews.NewsApplication;
import com.zzptc.sky.netnews.common.Constants;

import rx.Subscription;

/**
 * Created by Hu Zhilin on 2016/10/25.
 */

public class MyUtil {

    /**
     * 取消订阅
     * @param subscription 订阅者
     */
    public static void unSubscribe(Subscription subscription){
        if(subscription != null && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

    /**
     * 判断是否为夜间模式
     * @return
     */
    public static boolean isNightMode(){
        SharedPreferences sp = NewsApplication.getAppContext().getSharedPreferences(
                Constants.SHARES_COLORFUL_NEWS, Activity.MODE_PRIVATE);

        return sp.getBoolean(Constants.SHARES_COLORFUL_NEWS, false);
    }
}
