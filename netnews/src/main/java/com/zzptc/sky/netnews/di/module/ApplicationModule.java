package com.zzptc.sky.netnews.di.module;


import android.content.Context;

import com.zzptc.sky.netnews.NewsApplication;
import com.zzptc.sky.netnews.di.scope.ContextLife;
import com.zzptc.sky.netnews.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private NewsApplication mNewsApplication;

    public ApplicationModule(NewsApplication application){
        mNewsApplication = application;
    }

    @Provides
    @PerApp
    @ContextLife("Application")
    public Context provideApplicationContext(){
        return mNewsApplication.getApplicationContext();
    }
}
