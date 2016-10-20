package com.zzptc.sky.netnews;

import android.app.Application;


import com.zzptc.sky.netnews.common.Constants;
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

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化数据库
        //官方推荐将获取 DaoMaster 对象的方法放到 Application 层，这样将避免多次创建生成 Session 对象
        initDatabase();
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
}
