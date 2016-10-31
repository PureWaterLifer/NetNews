package com.zzptc.sky.netnews.utils;

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
}
