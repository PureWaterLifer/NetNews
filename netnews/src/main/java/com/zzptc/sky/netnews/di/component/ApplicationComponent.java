package com.zzptc.sky.netnews.di.component;


import android.content.Context;

import com.zzptc.sky.netnews.di.module.ApplicationModule;
import com.zzptc.sky.netnews.di.scope.ContextLife;
import com.zzptc.sky.netnews.di.scope.PerApp;

import dagger.Component;

@PerApp
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    @ContextLife("Application")
    Context getApplication();
}
