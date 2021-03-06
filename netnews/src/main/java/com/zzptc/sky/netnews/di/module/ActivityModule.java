package com.zzptc.sky.netnews.di.module;


import android.app.Activity;
import android.content.Context;

import com.zzptc.sky.netnews.di.scope.ContextLife;
import com.zzptc.sky.netnews.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity){
        mActivity = activity;
    }

    @PerActivity
    @Provides
    @ContextLife("Activity")
    public Context provideActivityContext(){
        return  mActivity;
    }


    @PerActivity
    @Provides
    public Activity provideActivity(){
        return  mActivity;
    }
}
