package com.zzptc.sky.netnews.mvp.ui.activities.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toolbar;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.socks.library.KLog;
import com.zzptc.sky.netnews.NewsApplication;
import com.zzptc.sky.netnews.R;
import com.zzptc.sky.netnews.annotation.BindValues;
import com.zzptc.sky.netnews.di.component.ActivityComponent;
import com.zzptc.sky.netnews.di.component.DaggerActivityComponent;
import com.zzptc.sky.netnews.di.module.ActivityModule;
import com.zzptc.sky.netnews.mvp.presenter.base.BasePresenter;
import com.zzptc.sky.netnews.utils.NetUtil;

import butterknife.ButterKnife;

/**
 * Created by Hu Zhilin on 2016/10/26.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private boolean mIsHasNavigationView = false;

    private ActivityComponent mActivityComponent;

    private T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //日志输出
        KLog.i(getClass().getSimpleName());
        //使用注解的方式判断当前类是否存在导航视图
        initAnnotation();
        //判断网络是否可用
        NetUtil.isNetworkErrorThenShowMsg();
        //初始化Activity组件
        initActivityComponent();
        //设置沉浸式状态栏
        setStatusBarTranslucent();
        //设置布局文件
        setContentView(getLayoutId());
        //初始化注入
        initInjector();
        //绑定Butter Knife
        ButterKnife.bind(this);
        //初始化所有控件
        initViews();
        //因为每一个界面中都有Toolbar，因此可以在BaseActivity中初始化Toolbar
        initToolbar();
        //如果存在导航视图的话，则初始化DrawerLayout
        if(mIsHasNavigationView){
            initDrawerLayout();
        }
        //初始化presenter
        if(presenter != null){
            presenter.onCreate();
        }
    }

    private void initAnnotation(){
        if(getClass().isAnnotationPresent(BindValues.class)){
            BindValues annotation = getClass().getAnnotation(BindValues.class);
            mIsHasNavigationView = annotation.mIsHasNavigationView();
        }
    }


    private void initActivityComponent(){
        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((NewsApplication)getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    public ActivityComponent getActivityComponent(){
        return mActivityComponent;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    protected void setStatusBarTranslucent(){
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintColor(R.color.colorPrimary);
        }
    }

    protected abstract int getLayoutId();

    protected abstract void initInjector();

    protected abstract void initViews();

    private void initToolbar(){

    }

    private void initDrawerLayout(){

    }
}
