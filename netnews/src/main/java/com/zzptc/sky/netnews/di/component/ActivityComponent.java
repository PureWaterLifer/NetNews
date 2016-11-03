package com.zzptc.sky.netnews.di.component;

import android.app.Activity;
import android.content.Context;

import com.zzptc.sky.netnews.di.module.ActivityModule;
import com.zzptc.sky.netnews.di.scope.ContextLife;
import com.zzptc.sky.netnews.di.scope.PerActivity;
import com.zzptc.sky.netnews.mvp.ui.activities.NewsActivity;

import dagger.Component;

/**
 * Created by Hu Zhilin on 2016/10/27.
 */

@PerActivity
@Component(dependencies = {ApplicationComponent.class},modules = {ActivityModule.class})
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(NewsActivity newsActivity);
}
