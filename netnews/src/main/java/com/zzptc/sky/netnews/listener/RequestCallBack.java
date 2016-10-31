package com.zzptc.sky.netnews.listener;

/**
 * Created by Hu Zhilin on 2016/10/25.
 */

public interface RequestCallBack<T> {

    void beforeRequest();

    void onSuccess(T data);

    void onError(String errorMsg);
}
