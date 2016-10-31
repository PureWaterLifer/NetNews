package com.zzptc.sky.netnews.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.zzptc.sky.netnews.listener.RequestCallBack;
import com.zzptc.sky.netnews.mvp.view.base.BaseView;
import com.zzptc.sky.netnews.utils.MyUtil;

import rx.Subscription;

/**
 * Created by Hu Zhilin on 2016/10/25.
 */

public class BasePresenterImpl<T,E extends BaseView> implements BasePresenter,RequestCallBack<T> {

    private E mView;
    private Subscription subscription;

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {
        MyUtil.unSubscribe(subscription);
    }

    @Override
    public void attachView(@NonNull BaseView view) {
        mView = (E) view;
    }

    @Override
    public void beforeRequest() {
        mView.showProgress();
    }

    @Override
    public void onSuccess(T data) {
        mView.hideProgress();
    }

    @Override
    public void onError(String errorMsg) {
        mView.hideProgress();
        mView.showMsg(errorMsg);
    }
}
