package com.zzptc.sky.netnews;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;


import com.socks.library.KLog;
import com.zzptc.sky.netnews.common.Constants;
import com.zzptc.sky.netnews.di.component.ApplicationComponent;
import com.zzptc.sky.netnews.di.component.DaggerApplicationComponent;
import com.zzptc.sky.netnews.di.module.ApplicationModule;
import com.zzptc.sky.netnews.greendao.DaoMaster;
import com.zzptc.sky.netnews.greendao.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Hu Zhilin on 2016/10/19.
 */

public class NewsApplication extends Application {

    private DaoSession mDaoSession;
    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = true;

    private ApplicationComponent mApplicationComponent;

    //全局的上下文，方便需要使用的地方获取
    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this;
        //统一Activity生命周期的打印日志
        initActivityLifecycleLogs();
        //初始化数据库
        //官方推荐将获取 DaoMaster 对象的方法放到 Application 层，这样将避免多次创建生成 Session 对象
        initDatabase();
        //把整个App的Tag都设置成一个
        KLog.init(BuildConfig.DEBUG);

        //注入ApplicationContext
        initApplicationComponent();
    }

    /**
     * 初始化数据库
     */
    private void initDatabase(){
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(this,ENCRYPTED ? Constants.ENCRYPTED_DB_NAME : Constants.DB_NAME);
        Database db = ENCRYPTED ? openHelper.getEncryptedReadableDb("super-secret") : openHelper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }

    /**
     * 返回DaoSession
     * @return
     */
    public DaoSession getDaoSession(){
        return mDaoSession;
    }


    private void initApplicationComponent(){
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }

    /**
     * 返回全局上下文
     * @return
     */
    public static Context getAppContext(){
        return mAppContext;
    }


    private void initActivityLifecycleLogs(){
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                KLog.v("=========", activity + "  onActivityCreated");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                KLog.v("=========", activity + "  onActivityCreated");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                KLog.v("=========", activity + "  onActivityResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                KLog.v("=========", activity + "  onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                KLog.v("=========", activity + "  onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                KLog.v("=========", activity + "  onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                KLog.v("=========", activity + "  onActivityDestroyed");
            }
        });
    }

}
