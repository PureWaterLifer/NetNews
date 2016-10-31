package com.zzptc.sky.netnews.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.zzptc.sky.netnews.mvp.view.base.BaseView;

/**
 * Created by Hu Zhilin on 2016/10/25.
 */

public interface BasePresenter {

    void onCreate();

    void onDestroy();

    void attachView(@NonNull BaseView view);

}
